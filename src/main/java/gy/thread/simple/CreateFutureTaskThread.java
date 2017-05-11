package gy.thread.simple;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by KEASON on 2017/5/11.
 * 1、创建线程的方式，extends Thread
 * 2 new Thread(new Runable(){}).start();
 * 3 new Thread(new FutureTask()).start();  其中FutureTask是extends Runnable的
 */
public class CreateFutureTaskThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int count = 0;
        for (int i = 0; i <10 ; i++) {
            System.out.println(Thread.currentThread() + "" + i);
            count =count+i;
        }
        return count;
    }


    public static void main(String[] args) {
        FutureTask<Integer> futureTask = new FutureTask<Integer>(new CreateFutureTaskThread());
        new Thread(futureTask).start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
