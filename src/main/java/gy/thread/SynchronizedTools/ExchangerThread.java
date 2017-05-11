package gy.thread.SynchronizedTools;

import java.util.concurrent.Exchanger;

/**
 * Created by KEASON on 2017/5/11.
 */
public class ExchangerThread {
    static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "准备交换数据！"+"原来数据为：AA");
                String str ="";
                try {
                    Thread.sleep(1000);
                    str = exchanger.exchange("AA");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "交换数据！"+"结果为："+ str);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "准备交换数据！"+"原来数据为：BB");
                String str ="";
                try {
                    Thread.sleep(3000);
                    str = exchanger.exchange("BB");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "交换数据！"+"结果为："+ str);
            }
        }).start();
    }
}
