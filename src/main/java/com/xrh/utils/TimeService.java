package com.xrh.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 解决多线程并发调用System.currentTimeMillis()性能问题
 * Created by buptxuruhong on 2018/4/30.
 */
public class TimeService {
    private static long currentTimeMillis = System.currentTimeMillis();
    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    public static long currentTimeMillis(){
        return currentTimeMillis;
    }

    static {
        executorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                currentTimeMillis = System.currentTimeMillis();
            }
        }, 0, 1, TimeUnit.MILLISECONDS);
    }
}

