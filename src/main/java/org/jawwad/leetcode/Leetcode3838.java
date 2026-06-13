package org.jawwad.leetcode;

class Leetcode3838 {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder sb = new StringBuilder();
        for(String word: words){
            int totalWeight = 0;
            for(int i = 0; i<word.length(); i++){
                char ch = word.charAt(i);
                totalWeight+= weights[ch-'a'];
            }
            totalWeight = totalWeight%26;
            totalWeight = 25-totalWeight;
            char charToAppend = (char)('a' + totalWeight);
            sb.append(charToAppend);
        }

        return sb.toString();
    }
}
