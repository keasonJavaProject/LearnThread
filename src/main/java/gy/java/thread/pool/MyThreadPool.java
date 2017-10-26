package gy.java.thread.pool;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

/**
 * Created by PicaHelth on 2017/10/26.
 */
public class MyThreadPool {
    public static void main(String[] args) {
        ExecutorService service =  Executors.newFixedThreadPool(2);
        service.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("just make it out ,for now!");
            }
        });
        service.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        try {
            new CountDownLatch(1).await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
