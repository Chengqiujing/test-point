package com.test.demo.basic;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author：chengqj
 * @createDate：2022/8/1 15:21
 * ©北京数字认证股份有限公司 2022
 * @description:
 */
public class ThreadTest4 {
    private static BlockingQueue blockingQueue = new ArrayBlockingQueue(10);
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // 容器中的阻塞状态调用的是 Thread.interrupted()，会重置打断状态
                    blockingQueue.take();
                } catch (InterruptedException e) {
                    // 验证容器抛出打断异常后，是否会改变线程的打断状态
                    System.out.println(Thread.currentThread().isInterrupted());
                    Thread.currentThread().interrupt();// 是否执行这一步来恢复打断状态，取决于接下来的代码是否有可能依赖线程状态
                }finally {
                    // 验证容器抛出打断异常后，是否会改变线程的打断状态
                    System.out.println(Thread.currentThread().isInterrupted());
                }
            }
        });
        thread.start();

        thread.interrupt();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
}
