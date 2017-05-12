package gy.java.thread.synchronizedCommunication;

/**
 * Created by KEASON on 2017/5/11.
 * 互斥通信
 * 子线程循环10 ，主线程循环5 次， 然后子线程循环10 ，主线再程循环5 次，如此循环50次
 */
public class SynchronizedCommunicationThread {
    static  class InnerClass{
        boolean isSub = true;
       void  sub(int loop) {
           synchronized (this) {
               while (!isSub) {
                   try {
                       this.wait();
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
               for (int i= 1; i<=10;i++) {
                   System.out.println(Thread.currentThread()+"loop " +loop +"   of " +i);
               }
               isSub= false;
               this.notify();
           }
       }

        void  main(int loop) {
            synchronized (this) {
                while (isSub) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i= 1; i<=5;i++) {
                    System.out.println(Thread.currentThread()+"loop " +loop +"  of " +i);
                }
                isSub =true;
                this.notify();
            }
        }
    }

    public static void main(String[] args) {
        InnerClass in = new InnerClass();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    in.main(i);
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    in.sub(i);
                }
            }
        }).start();
    }

}
