package com.example.myproject.多线程.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Description: []
 * @Author: wangyuanyuan
 * @CreateDate: 2019/8/7 17:20
 */
public class LockConditionDemo {
    private Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args){
        LockConditionDemo demo = new LockConditionDemo();
        new Thread(()->demo.await(),"thread1").start();
        new Thread(()->demo.signal(),"thread2").start();
    }

    private void await(){
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

    private void signal(){
        try {
            lock.lock();
            System.out.println("开始通知signal! ThreadName" + Thread.currentThread().getName());
            condition.signal();
            System.out.println("结束通知signal! ThreadName" + Thread.currentThread().getName());
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }

    }
}
