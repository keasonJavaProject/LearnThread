package gy.thread.simple;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

import static org.junit.Assert.*;

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