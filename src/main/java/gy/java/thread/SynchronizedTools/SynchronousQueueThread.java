package gy.java.thread.SynchronizedTools;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by KEASON on 2017/5/11.
 * 阻塞队列，规定队列大小，到了CAPACITY 最大值，put()就会阻塞。
 *                         队列为空时，take()就会阻塞。
 */
public class SynchronousQueueThread {
    public static final int CAPACITY = 3;
    static BlockingQueue<String> stringBlockingDeque = new ArrayBlockingQueue<String>(CAPACITY);
    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            int temp =i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        try {
                            System.out.println(Thread.currentThread().getName()+"准备存入数据,当前size:"+stringBlockingDeque.size());
                            stringBlockingDeque.put(String.valueOf(temp));
                            Thread.sleep(2000);
                            System.out.println(Thread.currentThread().getName()+"存入数据："+temp+"  当前size:"+stringBlockingDeque.size());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }).start();
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        System.out.println(Thread.currentThread().getName()+"准备取数据：当前size:"+stringBlockingDeque.size());
                        String str = stringBlockingDeque.take();
                        Thread.sleep(5000);
                        System.out.println(Thread.currentThread().getName()+"取出数据："+str+"  当前size:"+stringBlockingDeque.size());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
}
