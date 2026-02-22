package org.jawwad;

import org.jawwad.models.Car;
import org.jawwad.models.User;

import java.util.*;

class Main{
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>(List.of(4, 5, 9, 8));
        int [] arr = {4, 5, 7, 2, 3};
        Collections.sort(nums);
        Arrays.sort(arr);

        System.out.println(nums);
        for (int x: arr){
            System.out.println(x);
        }

    }
}