package com.test.demo.question;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.util.concurrent.*;

/**
 * *************************************************************************
 * <p/>
 *
 * @文件名称: ScheduleTaskTest.java
 * @包 路 径： com.test.demo.question
 * @版权所有：北京数字认证股份有限公司 (C) 2021
 * @类描述:
 * @版本: V1.0
 * @author：chengqj
 * @创建时间：2021/9/8 14:18
 */

public class ScheduleTaskTest {
    public static void main(String[] args) {
        test1();

//        schedualThreadPool();
//        threadPoolExecuator();
    }

    public static void test1(){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(0);
//        service.schedule(task("111",0),10,TimeUnit.SECONDS);
//        service.schedule(task("222",0),10,TimeUnit.SECONDS);
//        service.schedule(task("333",0),10,TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture = service.scheduleAtFixedRate(task("111", 0), 0, 4, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture1 = service.scheduleAtFixedRate(task("222", 0), 0, 4, TimeUnit.SECONDS);
        ScheduledFuture<?> scheduledFuture2 = service.scheduleAtFixedRate(task("333", 0), 0, 4, TimeUnit.SECONDS);


    }

    public static void schedualThreadPool() {
        ThreadPoolTaskScheduler taskScheduler = new ThreadPoolTaskScheduler();
        taskScheduler.setPoolSize(1); // 核心线程数,如果线程数不够，就会串行
        taskScheduler.setWaitForTasksToCompleteOnShutdown(true); // 是否优雅关闭
        taskScheduler.setAwaitTerminationSeconds(60); // 延迟关闭时间
        taskScheduler.setRemoveOnCancelPolicy(true);
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = taskScheduler.getScheduledThreadPoolExecutor();

        BlockingQueue<Runnable> queue = scheduledThreadPoolExecutor.getQueue();

        taskScheduler.initialize(); // 创建一个线程池

        System.out.println("开始任务~~");
        System.out.println("启动前核心线程数：" + taskScheduler.getPoolSize());
        System.out.println("活动线程数："+ taskScheduler.getActiveCount());

        taskScheduler.schedule(task("执行任务1。。。",10),new CronTrigger("0/1 * * * * ?"));  // 创建一个周期任务

        ScheduledFuture<?> schedule = taskScheduler.schedule(task("执行任务2。。。",0),
                new CronTrigger("0/1 * * * * ?")); // 创建一个可关闭的周期任务

        System.out.println("启动后核心线程数：" + taskScheduler.getPoolSize());
        System.out.println("活动线程数："+ taskScheduler.getActiveCount());


        // 关闭一个任务
        waitSeconds(5);
        schedule.cancel(true);
        taskScheduler.setPoolSize(5);
        taskScheduler.afterPropertiesSet();

        System.out.println("关闭任务后的核心线程数：" + taskScheduler.getPoolSize());
        System.out.println("活动线程数："+ taskScheduler.getActiveCount());
    }

    public static void threadPoolExecuator() {
         /*
            关于线程池的一点解释：
            1.线程池的核心参数：核心线程数，最大线程数，等待队列（有界或无界），（存活时间不涉及解释）
            这三个参数的关系是
            1）创建线程池，这时候核心线程没有创建
            2）开始执行任务，创建核心线程
            3）当创建的核心线程数达到核心线程数最大值后，任务开始加入队列，如果是有界队列，则队列满后，开始启用新线程，直到达到最大线程数。
               换言之，如果队列是无解队列，那么最大线程数是没有意义的。
            4）当最大线程数达到最大后，才开始走拒绝策略

            2.线程池的阻塞状态
            线程池的执行并不会阻塞主线程，但是核心线程在没有任务执行的时候会处于阻塞状态
         */

        BlockingQueue workQueue = new LinkedBlockingDeque();
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(4, 4, 10, TimeUnit.SECONDS, workQueue, new ThreadPoolExecutor.AbortPolicy());

        System.out.println("开始任务~~");

        for (int i = 0; i < 10; i++) {
            poolExecutor.execute(task("执行任务"+i+"。。。",60));  // 创建一个任务
        }

        waitSeconds(5);
        poolExecutor.setCorePoolSize(7); // 并没有更新运行中的参数

        System.out.println("无解队列：" + workQueue.size());
        System.out.println("main结束");



    }

    private class MySchedule extends ThreadPoolTaskScheduler {



    }

    /*private class MyScheduledThreadPoolExecutor extends ScheduledThreadPoolExecutor{

        public MyScheduledThreadPoolExecutor(int corePoolSize, ThreadFactory threadFactory, RejectedExecutionHandler handler) {
            super.super(corePoolSize, Integer.MAX_VALUE, 0, NANOSECONDS,
                    new LinkedBlockingQueue<Runnable>(), threadFactory, handler);
        }
    }*/

    public static void waitSeconds(int seconds){
        System.out.println("暂停 "+seconds+" 秒");
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Runnable task(String str,int waitSeconds){
        return () -> {
            System.out.println(str);
            if(waitSeconds > 0)
                waitSeconds(waitSeconds);
        };
    }
}
