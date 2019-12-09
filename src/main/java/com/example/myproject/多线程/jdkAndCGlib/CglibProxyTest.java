package com.example.myproject.多线程.jdkAndCGlib;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description: []
 * @Author: wangyuanyuan
 * @CreateDate: 2019/7/17 16:10
 */
public class CglibProxyTest implements MethodInterceptor {
    private CglibProxyTest(){}

    public static <T extends Target> Target newProxyInstance(Class<T> targetInstance){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetInstance);
        enhancer.setCallback((Callback) new CglibProxyTest());
        return (Target) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invokeSuper(o,objects);
    }
}
