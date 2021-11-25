package com.test.demo.basic.temp;

import java.util.Date;
import java.util.regex.Pattern;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: SomeTest.java
 * @包 路 径： com.test.demo.basic.temp
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/11/8 10:09
 */
public class SomeTest {
    public static void main(String[] args) {

        String a = "asdf,";
        String substring = a.substring(0, a.length() - 1);
        System.out.println(substring);


//        Map map = new HashMap<>();
//        map.put("1","11");
//        map.put("2","12");
//        Set set = map.keySet();
//
//        for (Object o : set) {
//            map.remove(o);
//        }
//        System.out.println(map);

        System.out.println(new Date().getTime());

        System.out.println("1无\n1".matches("(?s)'.*'"));
        System.out.println("1无\n1".replaceAll("(?s)'.*'",""));
        Pattern compile = Pattern.compile(".*", Pattern.MULTILINE);
        System.out.println(compile.matcher("无").find());
    }
}