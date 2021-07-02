package com.test.demo.question;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: StringChange.java
 * @包 路 径： com.test.demo.question
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/7/2 13:25
 */
public class StringChange {
    /**
     * 在方法内改变String
     */

    public static void main(String[] args) {
        String a = "123";
        changeStr(a);
        System.out.println(a);
    }

    public static void changeStr(String s){
        s = "321";
    }

}
