package com.xrh.queue;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 消息队列封装
 * Created by buptxuruhong on 2018/4/30.
 */
public class MessageQueue {
    private static ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private LinkedBlockingQueue<Message> messageQueue = new LinkedBlockingQueue();
    private final static MessageQueue instance = new MessageQueue();

    private AtomicLong putCount = new AtomicLong();
    private long lastPutCount = 0;
    private AtomicLong takeCount = new AtomicLong();
    private long lastTakeCount = 0;

    private MessageQueue(){
        executorService.scheduleAtFixedRate(new Runnable() {
            public void run() {
                int capacity = messageQueue.size();
                //生产速率
                long temp1 = putCount.get();
                long put = temp1 - lastPutCount;
                lastPutCount = temp1;
                //消费速率
                long temp2 = takeCount.get();
                long take = temp2 - lastTakeCount;
                lastTakeCount = temp2;
                System.out.println("putRate=" + put + "/s; takeRate=" + take + "/s; CurrentSize=" + capacity);
            }
        }, 1, 1, TimeUnit.SECONDS);
    }

    public static MessageQueue getInstance(){
        return instance;
    }

    public void put(Message message) throws InterruptedException {
        messageQueue.put(message);
        putCount.incrementAndGet();
    }

    public Message take() throws InterruptedException {
        takeCount.incrementAndGet();
        return messageQueue.take();
    }

}
