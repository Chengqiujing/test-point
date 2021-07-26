package com.test.demo.basic;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.Arrays;


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
