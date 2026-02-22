package org.jawwad.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamsApi {

    public void understandingForEach(){
        List<Integer> nums = Arrays.asList(4, 5, 2, 3);

        for(int x: nums){
            System.out.print(x + " ");
        }
        System.out.println();
        nums.forEach(x-> System.out.print(x + " "));
        System.out.println();
        //Understanding how forEach works
        //It takes in a consumer (a functional interface)

        Consumer<Integer> consumer= new Consumer<Integer>(){

            @Override
            public void accept(Integer x) {
                System.out.print(x + " ");
            }
        };

        nums.forEach(consumer); //works the same

    }

    public static void main(String[] args) {
        StreamsApi streamsApi = new StreamsApi();
//        streamsApi.understandingForEach();


        List<Integer> nums = new ArrayList<>(List.of(4, 23, 2, 4, 67, 20));

        //Stream is an interface in Java
        Stream<Integer> stream = nums.stream();
        stream.forEach(n-> System.out.print(n + " "));
        System.out.println();
        //Straem can only be used once.
//        stream.forEach(n-> System.out.print(n + " ")); This will throw an error

        Stream<Integer> s1 = nums.stream();
        Stream<Integer> s2 = s1.filter(n->n%2 == 0); //filter out only even vals
        Stream<Integer> s3 = s2.map(n-> n*5); //let all be multiples of 10

        List<Integer> res = s3.toList();

        Stream<Integer> s4 = res.stream();
        int sum = s4.reduce(0, (c,e)->c+e);

        System.out.println(res);
        System.out.println(sum);

    }
}
