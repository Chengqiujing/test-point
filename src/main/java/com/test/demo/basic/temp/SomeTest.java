package com.test.demo.basic.temp;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
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

    public final static int NAME_LENGTH_MIN = 1;
    public final static int NAME_LENGTH_MAX = 60;
    public final static String NAME_LENGTH_DESCRIPTION = MessageFormat.format("长度只能在{0}到{1}之间", NAME_LENGTH_MIN, NAME_LENGTH_MAX);

    public static void main(String[] args) {

        String a = "asdf,";
        String substring = a.substring(0, a.length() - 1);
        System.out.println(substring);

        String b = "qqq";
        changeString(b);
        System.out.println(b);

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
        System.out.println("1无\n1".replaceAll("(?s)'.*'", ""));
        Pattern compile = Pattern.compile(".*", Pattern.MULTILINE);
        System.out.println(compile.matcher("无").find());

        String msg = "123{0}765";
        String test = MessageFormat.format(msg, "test");
        System.out.println(test);

        // 正则表达式匹配空格

        System.out.println("()（ ）.|".matches("^[\\u4e00-\\u9fa5_a-zA-Z0-9（）()/,.|!！@#$%^&*=《》<>{} ]+$"));

        System.out.println(NAME_LENGTH_DESCRIPTION);


        for (int i = 9; i > 0; i--) {
            switch (i) {
                case 1:
                    System.out.println(i);
                case 2:
                    System.out.println(i);
                case 3:
                    System.out.println(i);
                default:
                    break;
            }
        }

        try {
//            int b = 1 / 0;
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(123);

        System.out.println(SomeTest.class.getResource("/").getPath());


        BlockingQueue queue = new LinkedBlockingQueue(1);
        boolean offer = queue.offer(new Object());
        System.out.println(offer);
        boolean offer1 = queue.offer(new Object());
        System.out.println(offer1);


        int num = 12;
        System.out.println("123 " + num++);
        System.out.println(num);

        // 时间测试
        // 报错Exception in thread "main" java.time.temporal.UnsupportedTemporalTypeException: Unsupported unit: Seconds
        // at java.time.LocalDate.until(LocalDate.java:1614)
        try {
            LocalDate start = LocalDate.parse("2022/07/14", DateTimeFormatter.ofPattern("yyyy/MM/dd"));


            Period between1 = Period.between(start, LocalDate.now());
            System.out.println(between1.getDays());


            Duration between = Duration.between(start, LocalDate.now());
            long days = between.toDays();
            System.out.println(days);


        } catch (Exception e) {
            e.printStackTrace();
        }


        /**
         * 从第几个开始截取，如果不足，就截取全部
         */
        String url = "https://192.168.136.67:";
        int pos = -1;

        for (int i = 0; i < 4; i++) {
            int t = url.indexOf("/", ++pos);
            if(t>0){
                pos = t;
            }else{
                pos = url.length();
                break;
            }
        }
        System.out.println(url.substring(0, pos));


        Map map = new HashMap<>();
        map.put("123", "0000");
        System.out.println(map.remove("123"));

    }


    private static void changeString(String str) {
        str = new String("123");
    }
}