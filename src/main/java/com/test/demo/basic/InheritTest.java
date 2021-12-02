package com.test.demo.basic;

/**
 * *************************************************************************
 * <p/>
 * 静态变量有没有办法被重写
 *
 * 类是通过类名调用的，也就没有必要强调继承一说
 * 实际是可以继承的，但因为是通过类名调用的还是本类的，没有重写一说了
 * @author：chengqj
 * @创建时间：2021/11/25 14:23
 */
public class InheritTest {

    public static void main(String[] args) {

        System.out.println(B.name);
        System.out.println(B.getName());

//        StringBuilder stringBuilder = new StringBuilder();
//        String a = null;
//        stringBuilder.append("123").append(a);
//        System.out.println(stringBuilder);
//
//        System.out.println("0&" + null);
    }
}
class A {
    public static String name = "123";

    public static String getName(){
        return name;
    }
}

class B extends A {
//    public static String name = "321";

    public static String getName(){
        return name;
    }
}
