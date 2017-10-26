package gy.java.thread.simple;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by KEASON on 2017/5/10.
 */
@Service
public class ThreadWithException {
    private static int size = 3;
    private ExecutorService threadPool = Executors.newFixedThreadPool(size);

    private class FirstThread extends Thread {
        private int flag;

        public FirstThread(int flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            if (flag == 3) {
                int j = 1 / 0;
            }
            System.out.println(Thread.currentThread() + "hello " + flag + "    " + new Date());
        }
    }

    public void showThread() {
        for (int i = 0; i < 100; i++) {
//            threadPool.submit(new FirstThread(i));
            new Thread(new FirstThread(i)).start();
        }
    }
}
