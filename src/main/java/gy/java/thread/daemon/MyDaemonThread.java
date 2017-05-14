package gy.java.thread.daemon;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by KEASON on 2017/5/14.
 */
public class MyDaemonThread {
    static class InnerClass implements Runnable {
        @Override
        public void run() {
            int j=0;
            while (!Thread.interrupted()) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                    if (j++ == 15) {
                        return;
                    }
                    System.out.println(Thread.currentThread()+" "+j+"   "+ this );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InnerClass());
        //设置后台线程之后，主线程10之后结束，自己创建的线程也死了
        thread.setDaemon(true);
        thread.start();
        TimeUnit.SECONDS.sleep(10);
        thread.interrupt();
        TimeUnit.SECONDS.sleep(10);
    }
}
