package com.test.demo.basic.temp;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author：chengqj
 * @createDate：2022/3/23 10:29
 * ©北京数字认证股份有限公司 2022
 * @description:
 *
 *
 * chengqj 2022/4/2 11:31 BlockingQueue满容量会怎么样
 */
public class T {


    static int i = 9;

    static {
        i = 1;
        System.out.println(i);

    }

    private static volatile int a = 1;

    public static void main(String[] args) throws InterruptedException {
        System.out.println(i);

        // 验证添加超过容量
        BlockingQueue queue = new LinkedBlockingQueue(1);
//        boolean offer = queue.offer(new Object());
//        System.out.println(offer);
//        boolean offer1 = queue.offer(new Object());
//        System.out.println(offer1);

        // 验证线程关闭是否会使take打断
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    queue.take();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        });
//        thread.start();
//        try {
//            TimeUnit.SECONDS.sleep(1);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        thread.interrupt();
//
//        try {
//            TimeUnit.SECONDS.sleep(100);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        // 输出函数会造成数据同步，在线程中会备份两份，外层的改变并不会改变内层，输出函数是线程安全函数，
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
//                    System.out.println("running");
//                    try {
//                        TimeUnit.SECONDS.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }

                    if(a == 0){
//                        System.out.println("break");
                        break;
                    }
                }
            }
        });
        thread.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        a = 0;
        System.out.println("change");
        thread.join();
    }







    public void test(){
        System.out.println(j);
    }

    int j = 9;
}
