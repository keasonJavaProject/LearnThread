package gy.thread.thread.local;

import gy.thread.simple.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

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