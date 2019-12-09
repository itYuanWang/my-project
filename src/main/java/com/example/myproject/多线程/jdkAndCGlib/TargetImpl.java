package com.example.myproject.多线程.jdkAndCGlib;

/**
 * @Description: []
 * @Author: wangyuanyuan
 * @CreateDate: 2019/7/17 15:41
 */
public class TargetImpl implements Target {
    @Override
    public int test(int i) {
        return i+1;
    }
}
