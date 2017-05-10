package gy.thread.thread.local;

import org.springframework.stereotype.Service;
/**
 * Created by KEASON on 2017/5/10.
 * 当前前程之间共享变量，当前线程的变量被多个对象使用。
 * ThreadLocal 类似于Map<Thread,Object> map = new HashMap<Thread.currentThread(),new Object()> 的一个map；
 */
@Service
public class ThreadLocaLThread {
    ThreadLocal threadLocal = new ThreadLocal();
    ThreadLocal threadLocalOne = new ThreadLocal();
    public void show() {
        for (int i = 0; i < 10; i++) {
            int index = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocalOne.set(index+1);
                    threadLocal.set(index);
                    new A().Show();
                    new B().Show();
                }
            }).start();
        }
    }

    private class A{
        void Show() {
            System.out.println( threadLocal.get());
            System.out.println(threadLocalOne.get());
        }
    }

    private class B{
        void Show() {
            System.out.println( threadLocal.get());
            System.out.println(threadLocalOne.get());
        }
    }
}
