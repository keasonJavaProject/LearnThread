package gy.thread.communication;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by KEASON on 2017/5/11.
 */
public class CommunicationThread {
    private String [] foods = new String[4];
    private int index = 0;

    public void showThreadProducer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (this){
                        if(index ==-1){
                            index ++;
                        }
                        foods[index]="AA";
                        System.out.println("pruduce:foods["+index+"]"+"AA");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        index++;
                        this.notifyAll();
                        if (index>=4) {
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }

    public void showThreadConsumer() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    synchronized (this){
                        if(index==4){
                            index --;
                        }
                        foods[index] = "";
                        System.out.println("consume:foods[" + index + "]");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        index--;
                        this.notifyAll();
                        if(index<0){
                            try {
                                this.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }).start();
    }


    public static void main(String[] args) throws InterruptedException {
        CommunicationThread thread = new CommunicationThread();
        thread.showThreadProducer();
        thread.showThreadConsumer();
        new CountDownLatch(1).await();
    }
}
