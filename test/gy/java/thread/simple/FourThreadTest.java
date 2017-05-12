package gy.java.thread.simple;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by KEASON on 2017/5/10.
 */
public class FourThreadTest extends BaseTest{
    @Autowired
    FourThread fourThread;

    @Test
    public void showFourThread() throws Exception {
        fourThread.showFourThread();
    }

}