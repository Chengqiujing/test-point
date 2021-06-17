package com.test.demo.basic;

import lombok.Data;

import java.io.*;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: SerilizeableTest.java
 * @包 路 径： com.test.demo.basic
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/6/17 16:49
 */
@Data
public class SerializableTest implements Serializable {

    private String a;

    public static String b = "M";


    public static void main(String[] args) {

        /*
            主要检验一下，对象序列化后，能不能反序列化为成员变量相同的别的对象
            注意:静态的成员变量不会被序列化

            验证结果:
            不可以转换为其它成员变量相同的类型
            Exception in thread "main" java.lang.ClassCastException: com.test.demo.basic.SerializableTest cannot be cast to com.test.demo.basic.Other
	        at com.test.demo.basic.SerializableTest.main(SerializableTest.java:49)
         */
        File file = new File("d:/test.txt");
        SerializableTest serializableTest = new SerializableTest();
        serializableTest.setA("asdf");

        // 写出
        try {
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(file));
            objout.writeObject(serializableTest);
            objout.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读入
        try {
            InputStream in = new FileInputStream(file);
            ObjectInputStream objin = new ObjectInputStream(in);
            Other other = (Other) objin.readObject(); // 转换成不通类型
            System.out.println(other);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
    }
}


@Data
class Other implements Serializable{
    private String a;

    private static String b = "M";

}
