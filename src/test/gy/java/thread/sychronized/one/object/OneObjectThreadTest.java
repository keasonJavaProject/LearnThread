package gy.java.thread.sychronized.one.object;

import gy.java.thread.simple.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by KEASON on 2017/5/10.
 */
public class OneObjectThreadTest extends BaseTest {
    @Autowired
    OneObjectThread oneObjectThread;

    @Test
    public void show() throws Exception {
        oneObjectThread.show();
    }

}