package gy.java.thread.simple;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

/**
 * Created by KEASON on 2017/5/10.
 */
public class ThreadWithExceptionTest extends BaseTest {
    /**
     *经过测试发现，要让多线程调试进入必须满足条件：
     * 1 在多线程上打thread 类型的断点.（！！！！不要混杂着主线程和多线程上都打断点，这样多线程进不去的）
     * 2 测试用例中使用 new CountDownLatch(1).await();
     * 3 多线程其中一个异常之后，程序则会一直在等待中？ 我测试的貌似不是这样的,
     *    gy 的任务中心，由于设置了个sleep ,导入数量和执行数量由于执行时有异常，计数器没有做计数，造成执行数量和导入数量永远不相等，所以一直在sleep等待。
     */
    @Autowired
    ThreadWithException service;

    @Test
    public void showThread() throws Exception {
        service.showThread();
        new CountDownLatch(1).await();
    }

}