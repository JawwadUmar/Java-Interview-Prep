package org.jawwad.maps;

import java.util.HashMap;
import java.util.Map;
public class Example1 {
    public Map<Integer, Integer> mp;

    Example1(){
        this.mp = new HashMap<>();

        for(int i = 1; i<=10; i++){
            mp.put(i, i*7+4);
        }
    }
    public static void main(String[] args) {
        Example1 example1 = new Example1();
        Map<Integer, Integer> mp = example1.mp;

        for(Integer x: mp.keySet()){
            int key = x;
            int val = mp.get(key);

            System.out.println(key+ " "+ val);
        }

    }
}


