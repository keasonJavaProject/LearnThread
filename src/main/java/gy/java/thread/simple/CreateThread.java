package gy.java.thread.simple;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by KEASON on 2017/5/10.
 */
@Service
public class CreateThread {
    private static int size = 3;
    private ExecutorService threadPool= Executors.newFixedThreadPool(size);
    private ExecutorService threadPoolCache= Executors.newCachedThreadPool();

    private class FirstThread extends Thread{
        private boolean flag;
        public FirstThread(boolean flag) {
            this.flag = flag;
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread()+"hello"+ new Date());
        }
    }

    public void showThread() {
        for (int i =0;i<10;i++) {
            boolean flag = true;
            if (i % 5 == 0) {
                flag =false;
            }
            threadPoolCache.submit(new FirstThread(flag));
        }
    }
}
