package com.test.demo.basic.temp;

import java.text.MessageFormat;
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

    public final static int NAME_LENGTH_MIN = 1;
    public final static int NAME_LENGTH_MAX = 60;
    public final static String NAME_LENGTH_DESCRIPTION = MessageFormat.format("长度只能在{0}到{1}之间",NAME_LENGTH_MIN,NAME_LENGTH_MAX);
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

        String msg = "123{0}765";
        String test = MessageFormat.format(msg, "test");
        System.out.println(test);

        // 正则表达式匹配空格

        System.out.println("()（ ）.|".matches("^[\\u4e00-\\u9fa5_a-zA-Z0-9（）()/,.|!！@#$%^&*=《》<>{} ]+$"));

        System.out.println(NAME_LENGTH_DESCRIPTION);


        for (int i = 9; i > 0; i--) {
            switch (i){
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




    }
}