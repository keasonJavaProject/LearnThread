package gy.java.thread.sychronized;

import gy.java.thread.simple.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by KEASON on 2017/5/10.
 */
public  class FourStringSychronizedThreadTest extends BaseTest {
        @Autowired
        FourStringSychronizedThread stringThread;

        @Test
        public void showFourStringThread() throws Exception {
            stringThread.showFourStringThread();
        }
}