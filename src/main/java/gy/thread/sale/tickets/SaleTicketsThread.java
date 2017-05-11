package gy.thread.sale.tickets;

/**
 * Created by KEASON on 2017/5/11.
 * 多线程共享数据，执行相同代码。
 */
public class SaleTicketsThread {

    public static void main(String[] args) {
        SaleTicketsThread s =new SaleTicketsThread();
        s.show();
    }
    public  void show() {
        Tickets tickets=new Tickets();
        new Thread(tickets).start();
        new Thread(tickets).start();
    }
    class Tickets implements Runnable{
        int count=100;
        @Override
        public void run() {
            while(count>=0){
                count--;
                System.out.println(Thread.currentThread()+""+count);
            }
        }
    }
}
