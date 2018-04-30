package com.xrh.queue;

/**
 * 生产者
 * Created by buptxuruhong on 2018/4/30.
 */
public class Producer implements Runnable{

    public void run() {
        for(;;){
            Message message = new Message("123");
            try {
                MessageQueue.getInstance().put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
