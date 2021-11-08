package com.test.demo.basic;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;


public class ScheduleTest {
    public static void main(String[] args) {
        // spring
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();;
        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
        threadPoolTaskScheduler.setPoolSize(1);
        threadPoolTaskScheduler.initialize();
        Calendar instance = Calendar.getInstance();
        instance.set(2021,8,13,23,55);
        threadPoolTaskScheduler.schedule(() -> {
            System.out.println(123);
        }, instance.getTime());

        try {
            TimeUnit.SECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // spring


//        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
//        service.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("111");
//            }
//        },3000,TimeUnit.MILLISECONDS);
////        service.scheduleAtFixedRate()
//
//        Timer timer = new Timer();
//
//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                timer.schedule(new TimerTask() {
//                    @Override
//                    public void run() {
//                        System.out.println("1ci");
//                    }
//                }, 3000, 1000);
//            }
//        });
//        thread.setDaemon(false);
//        thread.start();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        timer.cancel();
//
//        try {
//            System.out.println("dierci");
//            TimeUnit.SECONDS.sleep(10);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
