package com.test.demo.basic.temp;

import java.nio.ByteBuffer;
import java.util.Base64;

/**
 * @author：chengqj
 * @createDate：2022/5/25 9:41
 * ©北京数字认证股份有限公司 2022
 * @description:
 */
public class TestByteBuffer {

    public static void main(String[] args) {
        /**
         * 验证ByteBuffer
         */

        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        // 不满的byte数组 放入buffer
        byte[] bytes = new byte[10];
        bytes[0] = 1;
        bytes[1] = 0;
        bytes[2] = 1;
        bytes[3] = 1;

        System.out.println(Base64.getEncoder().encodeToString(bytes));
        byteBuffer.put(bytes,0, 4);
        byteBuffer.flip();
        byte[] array = byteBuffer.array();
        System.out.println(Base64.getEncoder().encodeToString(array));


    }


}
