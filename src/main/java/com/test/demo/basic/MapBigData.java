package com.test.demo.basic;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class MapBigData {
    public static void main(String[] args) {
        Map<String,Object> map = new HashMap<>();
        String s = UUID.randomUUID().toString();
        map.put(s,1);
        for (int i = 0; i < 1000000; i++) {
            map.put(UUID.randomUUID().toString(),1);
        }
        long l = System.currentTimeMillis();
        System.out.println(l);
        Object o = map.get(s);
        long l1 = System.currentTimeMillis();
        System.out.println(l1);
        System.out.println("time: "+(l1-l));
    }
}
