package gy.thread.simple;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

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