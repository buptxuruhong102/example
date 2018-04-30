package com.xrh.queue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by buptxuruhong on 2018/4/30.
 */
public class Main {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        service.submit(producer);
        service.submit(consumer);
    }
}
