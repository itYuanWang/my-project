package com.example.myproject.多线程.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: []
 * @Author: wangyuanyuan
 * @CreateDate: 2019/8/7 17:49
 */
public class LockConditionDemo2 {
    private Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {
        LockConditionDemo2 demo2 = new LockConditionDemo2();

        new Thread(()->demo2.await(demo2.condition1),"thread1_condition1").start();
        new Thread(()->demo2.await(demo2.condition1),"thread2_condition2").start();
        new Thread(()->demo2.signal(demo2.condition1),"thread3_condition1").start();
//        Thread.sleep(5000);
//        new Thread(()->demo2.signal(demo2.condition2),"thread4_condition2").start();
    }

    private void await(Condition condition){
        try {
            lock.lock();
            System.out.println("开始等待await! ThreadName" + Thread.currentThread().getName());
            condition.await();
            System.out.println("结束等待await! ThreadName" + Thread.currentThread().getName());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private void signal(Condition condition){
        try {
            lock.lock();
            System.out.println("开始通知signal! ThreadName" + Thread.currentThread().getName());
//            condition.signal();
            condition.signalAll();
            System.out.println("结束通知signal! ThreadName" + Thread.currentThread().getName());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
