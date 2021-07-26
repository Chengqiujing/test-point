package com.test.demo.question;


public class StringChange {


    public static void main(String[] args) {
        /**
         * 在方法内改变String
         */
        String a = "123";
        changeStr(a);
        System.out.println(a);

        /**
         * 在方法内改变对象
         */
        Demo demo = null;
        Demo demo1 = new Demo();
        demo1.setName("demo1");
        Demo demo2 = new Demo();
        changeDemo(demo,demo1,demo2);
        System.out.println(demo); // 对象引用不会向外传递
        System.out.println(demo1); // 对象应用指向的对象还是会改变的
        System.out.println(demo2); // 对象引用不会向外传递

    }

    public static void changeStr(String s){
        s = "321";
    }

    public static void changeDemo(Demo d,Demo d1,Demo d2){
        d = new Demo();
        d.setName("d");

        d1.setName("d1");

        d2 = new Demo();
        d2.setName("d2");
    }
}
class Demo {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "name='" + name + '\'' +
                '}';
    }
}