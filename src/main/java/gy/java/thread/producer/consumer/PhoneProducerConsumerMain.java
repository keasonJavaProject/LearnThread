package gy.java.thread.producer.consumer;

/**
 * Created by KEASON on 2017/5/11.
 * synchronized 实现生产消费者
 */
public class PhoneProducerConsumerMain {

    static class Salesman implements Runnable {
        Iphone iphone;
        Salesman(Iphone iphone) {
            this.iphone = iphone;
        }
        @Override
        public void run() {
            for (int i=0;i<10;i++) {
                this.iphone.getName(i+1);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    static class Producer implements Runnable {
       Iphone iphone ;

        public Producer(Iphone iphone) {
            this.iphone = iphone;
        }

        @Override
        public void run() {
            for (int i=0;i<10;i++) {
                try {
                    this.iphone.setName(i+1);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }

    static class Iphone {
        private boolean isSaled = true;
        private String name;

        public synchronized void  setName(int i) {
            System.out.println(Thread.currentThread().getName()+"正在生产第"+(i)+"部IPhone...");
            if (!isSaled) {
                System.out.println(Thread.currentThread().getName()+"第" + (i-1)+ "部IPhone等待被卖掉。");
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//          System.out.println(Thread.currentThread().getName()+"第" + (i-1)+ "部IPhone已被卖掉。");
            }

            this.name = "Iphone 5S("+i+")";
            this.isSaled = false;
            System.out.println(Thread.currentThread().getName()+"已生产第"+(i)+"部IPhone...");
            notify(); // 通知消费者线程已生产IPhone，等待被卖掉。
        }

        public synchronized String getName(int i) {
            if (isSaled) {
                System.out.println(Thread.currentThread().getName()+"wait for sale start...");
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"wait for sale end...");
            }

            this.isSaled = true;
            System.out.println(Thread.currentThread().getName() + "第"+i+"部IPhone已被卖掉。");
            notify(); // 通知生产者线程该IPhone已被卖掉，可以生产下一部了。
            return this.name;
        }
    }

    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        Thread t1 = new Thread(new Producer(iphone));
        Thread t2 = new Thread(new Salesman(iphone));
        t1.start();
        t2.start();
    }
}
