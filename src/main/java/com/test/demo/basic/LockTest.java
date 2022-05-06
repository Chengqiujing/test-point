package com.test.demo.basic;

import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author：chengqj
 * @createDate：2022/5/6 17:39
 * ©北京数字认证股份有限公司 2022
 * @description:
 */
public class LockTest {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) throws InterruptedException {
        LockTest locktest = new LockTest();

        Thread passThread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("执行 pass");
                if(reentrantLock.tryLock()){
                    locktest.processer();
                    reentrantLock.unlock();
                }
            }
        }, "pass");

        Thread blockThread = new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                System.out.println("执行 block");
                reentrantLock.lock();
                locktest.processer();
                reentrantLock.unlock();
            }
        }, "block");

        blockThread.start();
        TimeUnit.MILLISECONDS.sleep(200);
        passThread.start();
    }


    public void processer() throws InterruptedException {
        System.out.println("进来：" + Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
    }





}
