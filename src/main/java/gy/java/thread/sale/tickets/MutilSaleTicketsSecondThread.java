package gy.java.thread.sale.tickets;

/**
 * Created by KEASON on 2017/5/11.
 * 多线程共享数据，执行相同代码。
 */
public class MutilSaleTicketsSecondThread {

    public static void main(String[] args) {
        MutilSaleTicketsSecondThread mutilSaleTicketsThread =new MutilSaleTicketsSecondThread();
        mutilSaleTicketsThread.show();
    }

    public  void show() {
        Tickets tickets=new Tickets();
        new Thread(new Run1(tickets)).start();
        new Thread(new Run2(tickets)).start();
    }

    class Run1 implements  Runnable{
        Tickets tickets;
        Run1(Tickets tickets){
           this.tickets = tickets;
        }
        @Override
        public void run() {
            while (true){
                tickets.increment();
            }
        }
    }

    class Run2 implements  Runnable{
        Tickets tickets;
        Run2(Tickets tickets){
            this.tickets = tickets;
        }
        @Override
        public void run() {
            while (true){
                tickets.decrement();
            }
        }
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
