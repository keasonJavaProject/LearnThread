package gy.java.thread.simple;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by KEASON on 2017/5/10.
 */
public class MyFirstThreadTest extends BaseTest {
    @Autowired
    private MyFirstThread myFirstThread;

    @org.junit.Test
    public void getList() throws Exception {
        myFirstThread.getList();
    }

    @org.junit.Test
    public void showListRemoveWithForeach() throws Exception {
        myFirstThread.showListRemoveWithForeach();
    }

    @org.junit.Test
    public void showListRemoveWithIterator() throws Exception {
        myFirstThread.showListRemoveWithIterator();
    }

    @org.junit.Test
    public void showListRemoveWithListGet() throws Exception {
        myFirstThread.showListRemoveWithIterator();
    }

}