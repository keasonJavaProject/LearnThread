package gy.java.thread.SynchronizedTools;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by KEASON on 2017/5/11.
 * CyclicBarrier 在多线程中执行，能让所有的线程根据设定的个数MAx_size ,分批都执行到同一个地方，然后才能继续向下边执行。
 *      若不够凑足一组，就一直等待下去。
 *      凑够一组之后，会执行回掉方法，执行new Runnable(){}的代码。
 *      cyclicBarrier.await(6, TimeUnit.SECONDS); 设定超时时间，若组不够，到了超时时间，自动报异常退出。
 */
public class CyclicBarrierThread {
    public static final int MAX_SIZE = 4;
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(MAX_SIZE, new Runnable() {
        @Override
        public void run() {
            System.out.println(System.nanoTime());
        }
    });

    public static void main(String[] args) {
        for(int i=0;i <MAX_SIZE*2+1; i++){
            final int temp = i;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(new Random().nextInt(5000));
                        System.out.println(Thread.currentThread().getName()+"   "+temp +"  one  wait for others");
                        cyclicBarrier.await(6, TimeUnit.SECONDS);
                        System.out.println("All come here ,let us go ...get out of the door");

                        Thread.sleep(new Random().nextInt(5000));
                        System.out.println(Thread.currentThread().getName()+"   "+temp +" two  wait for others");
                        cyclicBarrier.await(6, TimeUnit.SECONDS);
                        System.out.println("All come here ,let us go ...go for eating");

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}
