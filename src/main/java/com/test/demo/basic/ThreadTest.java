package com.test.demo.basic;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

/**
 * @author：chengqj
 * @createDate：2022/7/15 13:56
 * ©北京数字认证股份有限公司 2022
 * @description:
 */
public class ThreadTest {


    private static int a = 1;
    public static void main(String[] args) {

        /*
        one线程是需要看到变量的线程
        two线程改变公共变量的值
        volatile 可以保证当发生变化的时候，及时写回主存，同时读取的时候，从主存读取

        当没有volatile的时候，two改变后也能促使one的退出，初步猜测，是循环时牵扯到方法跳跃，可能会重新从主存拉取数据
        方法结束会回写到主存
         */


        Thread one = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                while (a == 1){

                }
            }
        });

        Thread two = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                a++;
                TimeUnit.SECONDS.sleep(100);
            }
        });

        one.start();
        two.start();

        try {
            one.join(); // 一旦join主线程阻塞，接下来不再执行
//            System.out.println(123);
            two.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
