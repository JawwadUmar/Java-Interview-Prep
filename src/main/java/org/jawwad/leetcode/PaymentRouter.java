package org.jawwad.leetcode;

import com.google.gson.*;
import java.util.*;

public class PaymentRouter {

    public static String routePayment(String inputJson) {

        Gson gson = new Gson();
        JsonObject root = JsonParser.parseString(inputJson).getAsJsonObject();

        int penalty = root.get("penalty").getAsInt();

        // -------------------- Parse Providers --------------------
        Map<String, Provider> providers = new HashMap<>();

        JsonArray providerArray = root.getAsJsonArray("providers");
        for (JsonElement elem : providerArray) {
            JsonObject p = elem.getAsJsonObject();

            Provider provider = new Provider();
            provider.id = p.get("id").getAsString();
            provider.feeFixed = p.get("fee_fixed").getAsDouble();
            provider.feePct = p.get("fee_pct").getAsDouble();
            provider.successRate = p.get("success_rate").getAsDouble();
            provider.maxDailyAmount = p.get("max_daily_amount").getAsLong();
            provider.usedAmount = 0;

            provider.blacklistedBins = new HashSet<>();
            JsonArray bins = p.getAsJsonArray("blacklisted_bins");
            for (JsonElement bin : bins) {
                provider.blacklistedBins.add(bin.getAsString());
            }

            providers.put(provider.id, provider);
        }

        // -------------------- Parse Payments --------------------
        List<Payment> payments = new ArrayList<>();

        JsonArray paymentArray = root.getAsJsonArray("payments");
        for (JsonElement elem : paymentArray) {
            JsonObject p = elem.getAsJsonObject();

            Payment payment = new Payment();
            payment.id = p.get("id").getAsString();
            payment.amount = p.get("amount").getAsLong();
            payment.cardBin = p.get("card_bin").getAsString();
            payment.priority = p.get("priority").getAsInt();

            payment.preferredProviders = new ArrayList<>();
            if (p.has("preferred_providers")) {
                JsonArray prefs = p.getAsJsonArray("preferred_providers");
                for (JsonElement pref : prefs) {
                    payment.preferredProviders.add(pref.getAsString());
                }
            }

            payments.add(payment);
        }

        // -------------------- Sort Payments --------------------
        payments.sort((a, b) -> {
            if (b.priority != a.priority)
                return b.priority - a.priority;
            return Long.compare(b.amount, a.amount);
        });

        Set<String> processed = new HashSet<>();
        JsonArray resultArray = new JsonArray();

        // -------------------- Process Payments --------------------
        for (Payment payment : payments) {

            if (processed.contains(payment.id)) continue;
            processed.add(payment.id);

            Provider bestProvider = null;
            double bestCost = Double.MAX_VALUE;

            List<Provider> candidates = new ArrayList<>();

            // 1️⃣ Preferred providers first
            if (!payment.preferredProviders.isEmpty()) {
                for (String id : payment.preferredProviders) {
                    if (providers.containsKey(id)) {
                        candidates.add(providers.get(id));
                    }
                }
            } else {
                candidates.addAll(providers.values());
            }

            bestProvider = findBestProvider(payment, candidates, penalty);

            // 2️⃣ If preferred fail → check all providers
            if (bestProvider == null && !payment.preferredProviders.isEmpty()) {
                bestProvider = findBestProvider(payment,
                        new ArrayList<>(providers.values()),
                        penalty);
            }

            JsonObject result = new JsonObject();
            result.addProperty("payment_id", payment.id);

            if (bestProvider == null) {
                result.add("provider_id", JsonNull.INSTANCE);
                result.addProperty("cost", 0);
                result.addProperty("reason", "no_valid_provider");
            } else {
                double cost = calculateCost(bestProvider, payment, penalty);
                bestProvider.usedAmount += payment.amount;

                result.addProperty("provider_id", bestProvider.id);
                result.addProperty("cost", (int) Math.round(cost));
                result.addProperty("reason", "ok");
            }

            resultArray.add(result);
        }

        JsonObject output = new JsonObject();
        output.add("results", resultArray);

        return gson.toJson(output);
    }

    // -------------------- Helper Methods --------------------

    private static Provider findBestProvider(Payment payment,
                                             List<Provider> providers,
                                             int penalty) {

        Provider best = null;
        double bestCost = Double.MAX_VALUE;

        for (Provider p : providers) {

            if (p.blacklistedBins.contains(payment.cardBin))
                continue;

            if (p.usedAmount + payment.amount > p.maxDailyAmount)
                continue;

            double cost = calculateCost(p, payment, penalty);

            if (cost < bestCost ||
                    (Math.abs(cost - bestCost) < 0.0001 &&
                            best != null &&
                            p.id.compareTo(best.id) < 0)) {

                bestCost = cost;
                best = p;
            }
        }

        return best;
    }

    private static double calculateCost(Provider p,
                                        Payment payment,
                                        int penalty) {

        return p.feeFixed
                + (payment.amount * p.feePct)
                + ((1 - p.successRate) * penalty);
    }

    // -------------------- Models --------------------

    static class Provider {
        String id;
        double feeFixed;
        double feePct;
        double successRate;
        long maxDailyAmount;
        long usedAmount;
        Set<String> blacklistedBins;
    }

    static class Payment {
        String id;
        long amount;
        String cardBin;
        int priority;
        List<String> preferredProviders;
    }
}