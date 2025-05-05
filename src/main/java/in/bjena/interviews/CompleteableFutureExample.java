package in.bjena.interviews;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompleteableFutureExample {
	public static void main(String[] args) {
		CompleteableFutureExample ob = new CompleteableFutureExample();
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// directly calling a runnable thread to execute
		CompletableFuture.runAsync(() -> ob.noReturnMethod());

		// passing custom executor to the runnable thread
		CompletableFuture.runAsync(() -> ob.noReturnMethod(), executor);

		// Maximum can wait to complete the task for 100 seconds if task not completed
		// terminate the thread
		CompletableFuture.runAsync(() -> ob.noReturnMethod(), executor).orTimeout(100, TimeUnit.SECONDS);

		// Maximum can wait to complete the task for 100 seconds if task not completed
		// terminate the thread
		CompletableFuture.runAsync(() -> ob.noReturnMethod(), executor).orTimeout(100, TimeUnit.SECONDS);

		// Maximum can wait to complete the task for 100 seconds if task not completed
		// terminate the thread
		// Throw exception if any or after termination
		CompletableFuture.runAsync(() -> ob.noReturnMethod(), executor).orTimeout(100, TimeUnit.SECONDS)
				.exceptionally(e -> {
					System.out.print("throwing exception if nay");
					e.printStackTrace();
					return null;
				});

		// Above method not returning anything,
		// Bellow commands returning something
		// directly calling a callable thread to execute
		CompletableFuture.supplyAsync(() -> ob.returnMehtod());

		// passing custom executor to the callable thread
		CompletableFuture.supplyAsync(() -> ob.returnMehtod(), executor);

		// Maximum can wait to complete the task for 100 seconds if task not completed
		// terminate the thread
		CompletableFuture.supplyAsync(() -> ob.returnMehtod(), executor).orTimeout(100, TimeUnit.SECONDS);

		// Maximum can wait to complete the task for 100 seconds if task not completed
		// terminate the thread
		CompletableFuture.supplyAsync(() -> ob.returnMehtod(), executor).orTimeout(100, TimeUnit.SECONDS);

		// Maximum can wait to complete the task for 100 seconds if task not completed
		// terminate the thread
		// Throw exception if any or after termination
		CompletableFuture.supplyAsync(() -> ob.returnMehtod(), executor).orTimeout(100, TimeUnit.SECONDS)
				.exceptionally(e -> {
					System.out.print("throwing exception if nay");
					e.printStackTrace();
					return "Failed or Exception";
				});

	}

	public void noReturnMethod() {
		System.out.println("Thread Details : " + Thread.currentThread().getName());
		System.out.println("This method not returning anything");
	}

	public String returnMehtod() {
		System.out.println("Thread Details : " + Thread.currentThread().getName());
		System.out.println("This method not returning a String values");
		return "success";
	}
}
