package gy.java.thread.producer.consumer;

/**
 * Created by KEASON on 2017/5/11.
 */
public class MainTest {
    public static void main(String[] args) {
        Iphone iphone = new Iphone();
        Thread t1 = new Thread(new Producer(iphone));
        Thread t2 = new Thread(new Salesman(iphone));
        t1.start();
        t2.start();
    }
}
