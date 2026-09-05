package org.jawwad.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamApiPractice {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(1, 2 ,4 ,5 ,5 ,53, 6, 7, 8));
        Stream<Integer> stream = arr.stream();
        stream = stream.filter(n->n%2 ==0);
        stream = stream.map(x-> x/2);

        List<Integer> res = stream.toList(); //AFTER THE TERMINAL OPERATION, IT CAN NO LONGER BE USED

        System.out.println(res);
    }
}
