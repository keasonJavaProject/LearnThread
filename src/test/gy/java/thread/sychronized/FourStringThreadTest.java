package gy.java.thread.sychronized;

import gy.java.thread.simple.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by KEASON on 2017/5/10.
 */
public class FourStringThreadTest extends BaseTest {
   @Autowired
   FourStringThread stringThread;

    @Test
    public void showFourStringThread() throws Exception {
        stringThread.showFourStringThread();
    }

}