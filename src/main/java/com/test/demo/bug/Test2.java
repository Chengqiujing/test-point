package com.test.demo.bug;

import org.thymeleaf.expression.Dates;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: Test2.java
 * @包 路 径： com.test.demo.bug
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/4/21 18:42
 */
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
