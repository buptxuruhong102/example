package com.xrh.queue;

/**
 * 生产者
 * Created by buptxuruhong on 2018/4/30.
 */
public class Producer implements Runnable{

    public void run() {
        for(int i = 0; i < 100000000; i++){
            Message message = new Message(i+ "");
            try {
                MessageQueue.getInstance().put(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
