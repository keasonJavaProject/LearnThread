package gy.thread.sychronized;

import gy.thread.simple.BaseTest;
import gy.thread.sychronized.FourStringThread;
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