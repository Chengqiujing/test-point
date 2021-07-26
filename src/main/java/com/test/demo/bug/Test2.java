package com.test.demo.bug;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;


public class Test2 {
    public static void main(String[] args) {
        List<A> list = new ArrayList<>();
        A a = new A();
        list.add(a);
        list.add(a);
        list.add(a);
        list.add(a);
        List<A> list1 = list.subList(0, 9);
        System.out.println(list.size());
        List<A> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect.size());
    }
}
class A{
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
