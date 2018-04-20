package gy.java.thread.join;

public class MyThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            public void run() {
                System.out.println("hello1");
            }
        };

        Runnable runnable1=new Runnable() {
            public void run() {
                System.out.println("hello2");
            }
        };

        /**
         * 即join()的作用是：“等待该线程终止”，这里需要理解的就是该线程是指的主线程等待子线程的终止。
         * 也就是在子线程调用了join()方法后面的代码，只有等到子线程结束了才能执行。
         */
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable,i+"");
            thread.start();
            thread.join();
            Thread thread2  =new Thread(runnable1,i+"");
            thread2.start();
            thread2.join();
            System.out.println();
        }
    }
}
