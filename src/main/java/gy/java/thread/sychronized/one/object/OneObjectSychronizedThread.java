package gy.java.thread.sychronized.one.object;

import gy.java.thread.sychronized.Student;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by KEASON on 2017/5/10.
 * 线程同步，公用对象当成原子性进行处理。避免数据不一致现象。
 * 1 synchronized
 * 2 reentrantLock
 */
@Service
public class OneObjectSychronizedThread {
    private ReentrantLock lock = new ReentrantLock();
    Student student = new Student();
    public void show() {
        for (int i =  0; i <10000 ; i++) {
            final Integer j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (student){
                        student.setId(j.longValue());
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        student.setName(String.valueOf(j));
                        System.out.println(Thread.currentThread()+""+"id:"+student.getId() +  "    name:"+student.getName());
                    }
                }
            }).start();
        }
    }

    public void show1() {
        for (int i =  0; i <10000 ; i++) {
            final Integer j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try{
                        lock.lock();
                        student.setId(j.longValue());
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        student.setName(String.valueOf(j));
                        System.out.println(Thread.currentThread()+""+"id:"+student.getId() +  "    name:"+student.getName());
                    }finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }
}
