package com.test.demo.ws;

import javax.xml.ws.Endpoint;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: WebServiceTest.java
 * @包 路 径： com.test.demo.ws
 * @版权所有：北京数字认证股份有限公司 (C) 2022
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2022/1/6 17:36
 */
public class WebServiceTest {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/wether", new WetherService());
        System.out.println("创建webservice程序");
    }
}
