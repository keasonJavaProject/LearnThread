package gy.java.thread.join;

import java.util.concurrent.*;

public class MyCallableThread {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<String> stringFuture = executor.submit(new Callable<String>() {
			@Override
			public String call() throws Exception {
				Thread.sleep(8000);
				return "ok";
			}
		});
		/*
		Returns true if this task completed. Completion may be due to normal termination, an exception, or cancellation
		-- in all of these cases, this method will return true.*/
		System.out.println(stringFuture.isDone());
		System.out.println(stringFuture.isCancelled());

		//stringFuture.get() 会一直阻塞，直到获取结果
		try {
			System.out.println(stringFuture.get(2,TimeUnit.SECONDS));
		} catch (TimeoutException e) {
			stringFuture.cancel(true);
			System.out.println(stringFuture.isCancelled());
			System.out.println(stringFuture.isDone());
		}
	}
}
