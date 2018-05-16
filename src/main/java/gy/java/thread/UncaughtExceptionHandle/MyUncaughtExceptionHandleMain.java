package gy.java.thread.UncaughtExceptionHandle;

import java.util.concurrent.*;

public class MyUncaughtExceptionHandleMain {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread myThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1/0);
            }
        });
        myThread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandle());
        myThread.start();




        ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread myThread =  new Thread(r);
                myThread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandle());
                return myThread;
            }
        });
        Future<?> feature = executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println(2/0);
            }
        });
        feature.get();
    }
}
