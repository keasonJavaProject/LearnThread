package gy.java.thread.producer.consumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by KEASON on 2017/5/12.
 * 阻塞队列，实现生产消费者
 */
public class BlockProducerConsummer {
   static BlockingQueue<Integer> queue = new ArrayBlockingQueue(3);
    static class InnerProducer{
        void showProduce(int i) {
            try {
                System.out.println(Thread.currentThread()+"准备生产,当前库存："+queue.size());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                queue.put(i);
                System.out.println(Thread.currentThread()+"生产完成 "+ i+"  当前库存："+queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class InnerConsumer {
        void showConsume() {
            try {
                System.out.println(Thread.currentThread()+"准备消费,当前库存："+queue.size());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                double random = queue.take();
                System.out.println(Thread.currentThread()+"消费完成 "+ random+"  当前库存："+queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        final InnerConsumer innerConsumer = new InnerConsumer();
        final InnerProducer innerProducer = new InnerProducer();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    innerConsumer.showConsume();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    innerProducer.showProduce(i);
                }
            }
        }).start();
    }

}
