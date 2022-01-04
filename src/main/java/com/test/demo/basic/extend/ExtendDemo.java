package com.test.demo.basic.extend;

import lombok.Data;

import java.util.Arrays;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: ExtendDemo.java
 * @包 路 径： com.test.demo.basic.extend
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/12/22 16:46
 */
public class ExtendDemo {


    /**
     * 继承后，各自的实例拥有自己的继承的成员变量，互相隔离
     * @param args
     */
    public static void main(String[] args) {
        ExtB b1 = new ExtB();
        b1.setOperatorId("111");
        ExtB b2 = new ExtB();
        b2.setOperatorId("222");

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b1.getOperatorId());
        System.out.println(b2.getOperatorId());

        String str = "1222";
        System.out.println(Arrays.toString(str.split(",")));


    }


}

@Data
class ExtA{

    private String operatorId;

}


@Data
class ExtB extends ExtA{

    private String info;

}


