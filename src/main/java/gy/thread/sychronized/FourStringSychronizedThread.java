package gy.thread.sychronized;

import org.springframework.stereotype.Service;

/**
 * Created by KEASON on 2017/5/10.
 */
@Service
public class FourStringSychronizedThread {
    private class InnerThread extends Thread{
        String string;
        public InnerThread(String string) {
            this.string = string;
        }

        @Override
        public void run() {
            showString(string);
        }
    }

    public void showFourStringThread() {
        for (int i = 0; i < 1000; i++) {
            new Thread(new InnerThread("keason")).start();
        }
    }

    public  synchronized  void  showString(String str) {
        for (int i = 0; i< str.length();i++){
            System.out.print(str.charAt(i));
        }
        System.out.println();
    }

}
