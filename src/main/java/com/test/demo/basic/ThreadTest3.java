package com.test.demo.basic;

/**
 * @author：chengqj
 * @createDate：2022/8/1 14:37
 * ©北京数字认证股份有限公司 2022
 *@description:
 */
public class ThreadTest3 {

    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                Thread.currentThread().interrupt();


                // currentThread().isInterrupted(true); 这个会重置状态
                System.out.println(Thread.interrupted());

                // currentThread().isInterrupted(false); 这个不会崇智状态
                System.out.println(Thread.currentThread().isInterrupted());


            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
