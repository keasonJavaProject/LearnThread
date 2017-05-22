package gy.java.thread.simple;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by KEASON on 2017/5/10.
 */
public class CreateThreadTest extends BaseTest {
    @Autowired
    CreateThread createThread;

    @Test
    public void showThread() throws Exception {
        createThread.showThread();
    }

}