package com.example.myproject.多线程.thread;

import java.util.concurrent.*;

/**
 * @Description: []
 * @Author: wangyuanyuan
 * @CreateDate: 2019/7/16 16:36
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(4);
        /**
         * 但是阿里巴巴规范指出，不允许使用Executors去创建，而是通过ThreadPoolExecutor的方式
         * 这样的处理方式让写的同学更加明确线程池的运行规则，规避资源耗尽的风险
         */

//        ExecutorService executorService = new ThreadPoolExecutor(2,2,0L,
//                TimeUnit.MILLISECONDS,
//                new LinkedBlockingDeque<>(10),
//                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy());

        /**
         * 自定义ThreadFactory,线程拒绝策略
         */
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<>(10),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread = new Thread(r);
                        thread.setName(r.getClass().getName());
                        return thread;
                    }
                },
                new ThreadPoolExecutor.AbortPolicy());

        for (int i=0; i < 10; i++) {
            int index = i;
            //提交一个线程
            executorService.submit(()->System.out.println("i:" + index + "executorService"));
        }
        executorService.shutdown();

    }
}
