package org.jawwad.methodref;

import java.util.ArrayList;
import java.util.List;

public class MethodReference {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(List.of("Faahd", "Eren", "Levi", "Luffy", "Sanji"));
//        List<String> upperCaseNamees = names.stream().map(n->n.toUpperCase()).toList();
        //The following is an example of Method Reference
        List<String> upperCaseNamees = names.stream().map(String::toUpperCase).toList();

        upperCaseNamees.forEach(System.out::println); //other example of method ref
    }
}
