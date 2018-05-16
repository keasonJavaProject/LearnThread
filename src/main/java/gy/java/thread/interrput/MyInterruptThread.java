package gy.java.thread.interrput;

public class MyInterruptThread {
	public static void main(String[] args) {
		Thread thread= new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println();
				System.out.println("hello keason");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					//InterruptedException 会清除中断状态
					System.out.println("currentThreadInterruptStatus:"+Thread.currentThread().isInterrupted());
					System.out.printf("hello keason catch interrupt exception");
				}
			}
		});
		thread.start();
		System.out.println("thread.isInterrupted(1):"+thread.isInterrupted());
		System.out.println("thread.isInterrupted(2):"+thread.isInterrupted());

		System.out.println("\r\n");
		System.out.println("thread.isInterrupted() 只获取中断状态");
		thread.interrupt();
		System.out.println("thread.isInterrupted(3):"+thread.isInterrupted());
		System.out.println("thread.isInterrupted(4):"+thread.isInterrupted());


		System.out.println("\r\n");
		thread= new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println();
				System.out.println("hello keason");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					//InterruptedException 会清除中断状态
					System.out.println("currentThreadInterruptStatus:"+Thread.currentThread().isInterrupted());
					System.out.printf("hello keason catch interrupt exception");
				}
			}
		});
		thread.start();
		System.out.println("Thread.interrupted() 会清除中断状态");
		thread.interrupt();
		System.out.println("thread.isInterrupted(5):"+thread.isInterrupted());
		System.out.println("thread.interrupted(1):"+ thread.interrupted());
		System.out.println("thread.isInterrupted(6):"+thread.isInterrupted());




	}
}
