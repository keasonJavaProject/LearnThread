package gy.thread.sychronized.one.object;

import gy.thread.simple.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by KEASON on 2017/5/10.
 */
public class OneObjectSychronizedThreadTest extends BaseTest {
    @Autowired
    private  OneObjectSychronizedThread oneObjectSychronizedThread;

    @Test
    public void show() throws Exception {
        oneObjectSychronizedThread.show();
    }

    @Test
    public void show1() throws Exception {
        oneObjectSychronizedThread.show1();
    }

}