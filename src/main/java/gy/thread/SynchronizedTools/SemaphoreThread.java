package gy.thread.SynchronizedTools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by KEASON on 2017/5/11.
 * Semaphore 确保线程并行执行的数据量为设定的数据量 MAX_Size
 */
public class SemaphoreThread {
    static int MAX_Size =4;
    static ExecutorService pool = Executors.newFixedThreadPool(10);
    static Semaphore semaphore = new Semaphore(MAX_Size);

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            int temp =i;
            pool.submit(new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread()+"进来，Semaphore left "+ semaphore.availablePermits());
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread()+"离开，Semaphore left "+semaphore.availablePermits());
                    semaphore.release();
                }
            });
        }
        pool.shutdown();
    }
}
