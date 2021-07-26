package com.test.demo.basic;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class QueueAndLinkedList {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        for (Integer integer : queue) {
            System.out.println(integer);
        }


        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (Integer integer : list) {
            System.out.println(integer);
        }

        Date date = new Date();
        date.setHours(0);
        date.setMinutes(0);
        date.setSeconds(0);
        System.out.println(date);

    }
}
