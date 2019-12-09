package com.example.myproject.多线程.jdkAndCGlib;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Description: []
 * @Author: wangyuanyuan
 * @CreateDate: 2019/7/17 16:54
 */
public class ProxyPerformanceTest {
    public static void main(String[] args){
        Target target = new TargetImpl();
        Target dynamicProxy = JdkDynamicProxyTest.newProxyInstance(target);
        Target cglibProxy = CglibProxyTest.newProxyInstance(target.getClass());

        int preRunCount = 10000;
        runWithMonitor(target,preRunCount);
        runWithMonitor(cglibProxy,preRunCount);
        runWithMonitor(dynamicProxy,preRunCount);

        Map<String,Target> tests = new LinkedHashMap<>();
        tests.put("native",target);
        tests.put("Dynamic",dynamicProxy);
        tests.put("Cglib",cglibProxy);

        int repeatCount = 3;
        int runCount = 1000000;
        runTest(repeatCount,runCount,tests);
        runCount = 50000000;
        runTest(repeatCount,runCount,tests);

    }

    private static void runWithMonitor(Target target, int preRunCount) {
        for (int i = 0; i < preRunCount; i++){
            target.test(i);
        }
    }

    private static void runTest(int repeatCount, int runCount, Map<String,Target> tests){
        System.out.println(String.format("\n====run test:[repeatCount=%s][runCount=%s][java.version=%s]=====",
                repeatCount,runCount,System.getProperty("java.version")));
        for (int i=0; i < repeatCount; i++) {
            System.out.println(String.format("\n---------test:[%s]-------",(i+1)));
            for (String key : tests.keySet()) {
                runWithMonitor(tests.get(key),runCount,key);
            }
        }

    }

    private static void runWithMonitor(Target target, int runCount, String key) {
        long millis = System.currentTimeMillis();
        for (int i = 0; i < runCount; i++) {
            target.test(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("[" + key + "]Total Time:"+ (endTime - millis) + "ms");

    }
}
