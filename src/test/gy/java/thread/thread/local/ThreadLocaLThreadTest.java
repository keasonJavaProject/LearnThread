package gy.java.thread.thread.local;

import gy.java.thread.simple.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by KEASON on 2017/5/10.
 */
public class ThreadLocaLThreadTest extends BaseTest {
    @Autowired
    ThreadLocaLThread threadLocaLThread;

    @Test
    public void show() throws Exception {
        threadLocaLThread.show();
    }

}