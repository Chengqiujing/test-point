package com.test.demo.basic;

import java.io.*;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: ByteTest.java
 * @包 路 径： com.test.demo.basic
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqiujing
 * @创建时间：2021/2/24 16:29
 */
public class ByteTest {
    public static void main(String[] args) throws IOException {
//        File file = new File("D:\\workpalce\\ideaWorkplace\\tms\\tms-tenantbusiness" +
//                "\\tms-tenantbusiness-assemble\\src\\main\\resources\\image\\icon.gif");
//        FileInputStream fileInputStream = new FileInputStream(file);
        URL resource = ByteTest.class.getClassLoader().getResource("image/icon.gif");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(resource.openStream());
        ByteBuffer allocate = ByteBuffer.allocate(5 * 1024);
        byte[] a = new byte[1024*3];
        int len = 0;
        while((len = bufferedInputStream.read(a)) != -1){
            allocate.put(a,0,len);
        }
        allocate.flip();
        byte[] image = new byte[allocate.limit()];
        allocate.get(image);
        allocate.clear();
        System.out.println(Arrays.toString(image));
    }
}
