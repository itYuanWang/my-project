package com.example.myproject.多线程.thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @Description: []
 * @Author: wangyuanyuan10
 * @Date: 2019-08-27 11:10
 **/
public class SummonDragonDemo {
    private static final int THREAD_COUNT_NUM = 7;
    private static CountDownLatch countDownLatch = new CountDownLatch(THREAD_COUNT_NUM);

    public static void main(String[] args) throws InterruptedException {
        for(int i = 1; i <= THREAD_COUNT_NUM; i++){
            int index = i;
            new Thread(()->{
               System.out.println("第" + index + "颗龙珠已经已经集齐");
                try {
                    Thread.sleep(new Random().nextInt(1000));

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("集齐七颗龙珠！召唤神龙！");
    }
}
