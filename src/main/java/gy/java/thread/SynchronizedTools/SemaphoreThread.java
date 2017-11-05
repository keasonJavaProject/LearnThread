package gy.java.thread.SynchronizedTools;

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
//                    if (semaphore.getQueueLength() > 0) {//若有等待，直接返回。
//                        return ;
//                    }

                    //最多等待40个，可用来处理高并发订单，让线程去等待
                    /** 但这种有问题，就是线程太多，一直处于等待中，会造成OutofMemory异常。
                     * 在高并发订单中，所以用消息队列，对于耗时的高并发操作，把处理请求直接封装成消息，直接返回前端响应。
                     * 然后再消息消费端，异步进行处理。
                     *
                     */
                    if (semaphore.getQueueLength() > 40 ) {
                        return ;
                    }



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
