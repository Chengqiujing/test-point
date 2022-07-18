package com.test.demo.basic;

import java.util.concurrent.TimeUnit;

/**
 * @author：chengqj
 * @createDate：2022/7/15 16:47
 * ©北京数字认证股份有限公司 2022
 * @description:
 */
public class ThreadTest2 {

    private static int a = 1;

    public static void main(String[] args) throws InterruptedException {


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
}
