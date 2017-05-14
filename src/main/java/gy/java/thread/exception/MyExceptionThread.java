package gy.java.thread.exception;

import java.util.concurrent.*;

/**
 * Created by KEASON on 2017/5/14.
 */
public class MyExceptionThread {
    public static void main(String[] args) {

        try {
            System.out.println("main1");
            int j = 1 / 0;
            System.out.println("main2");
        } catch (Exception e) {
            System.out.println("main exception");
        }

        //在线程内部的异常不能在 外边捕获到。
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("hello1");
                        int i = 1 / 0;
                        System.out.println("hello2");
                    } catch (Exception e) {
                        System.out.println("runnable exception");
                    }
                }
            }).start();


        //在run 线程外部，不能捕获到异常，所以不会打印runnable exception 3 4 而是直接抛异常
        try {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello3");
                    int i = 1 / 0;
                    System.out.println("hello4");
                }
            }).start();
        } catch (Exception e) {
            System.out.println("runnable exception 3 4");
        }



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //通过pool.submit  无论是传递进去runnable，还是callable 都能在future中捕获异常
        //通过线程池 callable
        ExecutorService pool = Executors.newFixedThreadPool(1);
        Future future=  pool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("call1");
                int j = 1 / 0;
                System.out.println("call2");
                return 1;
            }
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            System.out.println("future InterruptedException");
        } catch (ExecutionException e) {
            System.out.println("future ExecutionException");
        }


        //通过线程池 runnable
        Future future1 =  pool.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("call5");
                int j = 1 / 0;
                System.out.println("call6");
            }
        });
        try {
            future1.get();
        } catch (InterruptedException e) {
            System.out.println("future 56 InterruptedException");
        } catch (ExecutionException e) {
            System.out.println("future 56  ExecutionException");
        }



        ////////////////////////////////////////////////////////////////////////////////////////////
        //通过线程池  execute.方法捕获不到线程中的异常。
        ExecutorService pool2 = Executors.newFixedThreadPool(1);
        try {
            pool2.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("call7");
                    int j = 1 / 0;
                    System.out.println("call8");
                }
            });
        } catch (Exception e) {
            System.out.println("pool7&8 异常捕获不到。");
        }
    }



}
