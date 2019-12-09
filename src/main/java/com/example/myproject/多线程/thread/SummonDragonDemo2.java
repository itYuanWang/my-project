package com.example.myproject.多线程.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Description: []
 * @Author: wangyuanyuan10
 * @Date: 2019-08-27 20:56
 **/
public class SummonDragonDemo2 {
    private static final int THREAD_COUNT_NUM = 7;

    public static void main(String[] args){
        CyclicBarrier cyclicBarrier1 = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("7个法师着急完毕，同时出发，去往不同的地方寻找龙珠");
                summonGragon();
            }
        });
        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                System.out.println("第" + index + "法师来了");
                try {
                    cyclicBarrier1.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }


    private static void summonGragon(){
        CyclicBarrier cyclicBarrier2 = new CyclicBarrier(THREAD_COUNT_NUM, new Runnable() {
            @Override
            public void run() {
                System.out.println("集齐七颗龙珠，召唤神龙");
            }
        });
        for (int i = 1; i <= THREAD_COUNT_NUM; i++) {
            int index = i;
            new Thread(() -> {
                System.out.println("第" + index + "颗龙珠已收集到");
                try {
                    cyclicBarrier2.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }).start();
        }

    }
}
