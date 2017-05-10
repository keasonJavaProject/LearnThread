package gy.thread.sychronized.one.object;

import gy.thread.sychronized.Student;
import org.springframework.stereotype.Service;

/**
 * Created by KEASON on 2017/5/10.
 * 通过添加Thread.sleep 来增加数据不一致的概率。
 */
@Service
public class OneObjectThread {
    Student student = new Student();
    public void show() {
        for (int i =  0; i <10000 ; i++) {
            Integer j = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    student.setId(j.longValue());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    student.setName(String.valueOf(j));
                    System.out.println(Thread.currentThread()+""+"id:"+student.getId() +  "    name:"+student.getName());
                }
            }).start();
        }
    }
}
