package com.test.demo.basic;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: StringBuilderTest.java
 * @包 路 径： com.test.demo.basic
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/8/11 15:40
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuffer stringBuilder = new StringBuffer();
        String str = null;
        stringBuilder.append("123").append(str).append("abc"); // 123nullabc
        System.out.println(stringBuilder.toString());
    }
}
