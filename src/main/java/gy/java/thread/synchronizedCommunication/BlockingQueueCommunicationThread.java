package gy.java.thread.synchronizedCommunication;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by KEASON on 2017/5/11.
 * 互斥通信
 * 子线程循环10 ，主线程循环5 次， 然后子线程循环10 ，主线再程循环5 次，如此循环50次
 */
public class BlockingQueueCommunicationThread {
    static  class InnerClass{
        BlockingQueue<Integer> blockingDequeSub = new ArrayBlockingQueue(1);
        BlockingQueue<Integer> blockingDequeMain = new ArrayBlockingQueue(1);

        {//类的默认构造器
            try {
                blockingDequeSub.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       void  sub(int loop) throws InterruptedException {
           blockingDequeSub.take();
           for (int i= 1; i<=10;i++) {
               System.out.println(Thread.currentThread()+"loop " +loop +"   of " +i);
           }
           blockingDequeMain.put(1);
       }

        void  main(int loop) throws InterruptedException {
            blockingDequeMain.take();
            for (int i= 1; i<=5;i++) {
                System.out.println(Thread.currentThread()+"loop " +loop +"  of " +i);
            }
            blockingDequeSub.put(1);
        }
    }

    public static void main(String[] args) {
        final InnerClass in = new InnerClass();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        in.main(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    try {
                        in.sub(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

}
