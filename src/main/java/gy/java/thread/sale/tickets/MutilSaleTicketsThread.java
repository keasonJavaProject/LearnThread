package gy.java.thread.sale.tickets;

/**
 * Created by KEASON on 2017/5/11.
 * 多线程共享数据，执行相同代码。
 */
public class MutilSaleTicketsThread {

    public static void main(String[] args) {
        MutilSaleTicketsThread mutilSaleTicketsThread =new MutilSaleTicketsThread();
        mutilSaleTicketsThread.show();
    }

    public  void show() {
        final Tickets tickets=new Tickets();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    tickets.increment();
                }

            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    tickets.decrement();
                }
            }
        }).start();
    }

    class Tickets{
        int count =100;
        public synchronized  void increment() {
            count++;
            System.out.println(Thread.currentThread()+"increment() "+count);
        }

        public synchronized void decrement() {
            count--;
            System.out.println(Thread.currentThread()+"decrement() "+count);
        }
    }
}
