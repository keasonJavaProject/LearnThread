package gy.java.thread.synchronizedCommunication;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by KEASON on 2017/5/11.
 * 互斥通信
 * 子线程循环10 ，主线程循环5 次， 然后子线程循环10 ，主线再程循环5 次，如此循环50次
 */
public class ConditionCommunicationThread {
    static  class InnerClass{
        ReentrantLock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        boolean isSub = true;

       void  sub(int loop) {
           lock.lock();
           while (!isSub) {
               try {
                   condition.await();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           for (int i= 1; i<=10;i++) {
               System.out.println(Thread.currentThread()+"loop " +loop +"   of " +i);
           }
           isSub= false;
           condition.signal();
           lock.unlock();
       }

        void  main(int loop) {
            lock.lock();
            while (isSub) {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            for (int i= 1; i<=5;i++) {
                System.out.println(Thread.currentThread()+"loop " +loop +"  of " +i);
            }
            isSub =true;
            condition.signal();
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        final InnerClass in = new InnerClass();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    in.main(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    in.sub(i);
                }
            }
        }).start();
    }

}
