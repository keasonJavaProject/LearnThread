package gy.java.thread.simple;

import org.springframework.stereotype.Service;

/**
 * Created by KEASON on 2017/5/10.
 */
@Service
public class FourThread {
    private class InnerThread extends Thread{
        Long time;
        int index;
        public InnerThread(int index ,Long time) {
            this.time = time;
            this.index = index;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread() + "" +  index + " "+time);
        }
    }

    public void showFourThread() {
        FourThread fourThread = new FourThread();
        for (int i = 0; i < 4; i++) {
            new Thread(new InnerThread(i, fourThread.showTime())).start();
        }
    }

    public  long showTime() {
        synchronized (this){
            return System.currentTimeMillis()/1000;
        }
    }
}
