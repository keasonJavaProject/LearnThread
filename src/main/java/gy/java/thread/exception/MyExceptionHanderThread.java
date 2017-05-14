package gy.java.thread.exception;

import java.util.concurrent.*;

/**
 * Created by KEASON on 2017/5/14.
 */
public class MyExceptionHanderThread {
     static class MyExceptionHander implements Thread.UncaughtExceptionHandler{
         @Override
         public void uncaughtException(Thread t, Throwable e) {
             System.out.println("MyOwnThread"+ t+ e);
         }
     }

     static  class InnerMyThread implements Runnable{
         @Override
         public void run() {
             try {
                 TimeUnit.SECONDS.sleep(1);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             System.out.println("InnerMyThread");
             int j =1/0;
         }
     }

    static class InnerMyThreadFactoryImpl implements ThreadFactory{

         @Override
         public Thread newThread(Runnable r) {
             System.out.println("InnerMyThreadImpl start");
             Thread thread = new Thread(r);
             thread.setUncaughtExceptionHandler(new MyExceptionHander());
             return thread;
         }
     }

    public static void main(String[] args) {
        InnerMyThread innerMyThread = new InnerMyThread();
        Thread thread = new Thread(innerMyThread);
        thread.setUncaughtExceptionHandler(new MyExceptionHander());
        thread.start();

        ExecutorService pool = Executors.newFixedThreadPool(1,new InnerMyThreadFactoryImpl());
        pool.execute(innerMyThread);
    }
}
