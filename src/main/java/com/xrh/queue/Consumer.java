package com.xrh.queue;

/**
 * 消费者
 * Created by buptxuruhong on 2018/4/30.
 */
public class Consumer implements Runnable{
    public void run() {
        while (true){
            try {
                Message message = MessageQueue.getInstance().take();
                //System.out.println(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
