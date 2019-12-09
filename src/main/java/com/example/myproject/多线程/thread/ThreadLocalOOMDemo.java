package com.example.myproject.多线程.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: []
 * @Author: wangyuanyuan10
 * @Date: 2019-09-16 16:44
 **/
public class ThreadLocalOOMDemo {
    private static final int THREAD_LOOP_SIZE = 500;
    private static final int MOCK_BIG_DATA_SIZE = 10000;
    private static ThreadLocal<List> threadLocal = new ThreadLocal<>();

    public static void main(String[] args){
        ExecutorService service = Executors.newFixedThreadPool(THREAD_LOOP_SIZE);

        for (int i = 0;i < THREAD_LOOP_SIZE; i++) {
            service.execute(()->{
                threadLocal.set(new ThreadLocalOOMDemo().addBigList());
                Thread t = Thread.currentThread();
                System.out.println(Thread.currentThread().getName());
                threadLocal.remove();
            });
            try {
                Thread.sleep(1000L);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        service.shutdown();
    }

    private List<Long> addBigList(){
        List<Long> param = new ArrayList<>();
        for (int i = 0; i < MOCK_BIG_DATA_SIZE; i++){
            param.add(3L);
        }
        return param;
    }
}
