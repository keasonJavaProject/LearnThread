package gy.java.thread.UncaughtExceptionHandle;

public class MyUncaughtExceptionHandle implements Thread.UncaughtExceptionHandler {
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("Keason handle Thread Exception");
    }
}
