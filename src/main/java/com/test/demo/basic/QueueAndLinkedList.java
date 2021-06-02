package com.test.demo.basic;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: QueueAndLinkedList.java
 * @包 路 径： com.test.demo.basic
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/6/1 14:54
 */
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
