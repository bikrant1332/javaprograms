package in.bjena.interviews;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FuterDemoWIthExecutor {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// Creating the executor service
		ExecutorService executor = Executors.newFixedThreadPool(2);

		// Two task we assign runnable and callable
		// Assigning task to the executor service runnable
		Runnable runnableTask = () -> {
			try {
				System.out.println("Executing the RUNABLE task");
				TimeUnit.MILLISECONDS.sleep(300);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		// Callable task
		Callable<String> callableTask = () -> {
			System.out.println("Executing CALLABLE task " + LocalDateTime.now());
			TimeUnit.MILLISECONDS.sleep(300);
			return "Task's execution " + LocalDateTime.now();
		};

		List<Callable<String>> callableTasks = new ArrayList<>();
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		callableTasks.add(callableTask);
		// We have several options
		// 1.execute() - it is void method not return anything
		// 2.submit() - it returns a result of future type
		// 3.invokeAny() -Assigns a collection of tasks to an ExecutorService, causing
		// each to run,
		// and returns the result of a successful execution of one task (if there was a
		// successful execution):
		// 4.invokeAll()

		// executing the execute method for runnable task.
		executor.execute(runnableTask);

		// collecting the result with callable task
		Future<String> future = executor.submit(callableTask);

		// operations with future:
		while (!future.isDone()) {
			System.out.println("waiting future  result");
			TimeUnit.MILLISECONDS.sleep(500);
		}

		System.out.println("Futer: " + future.get());

		// invokeAny
		String result = executor.invokeAny(callableTasks);
		System.out.println("result from invokeAny: " + result);

		// invokeAll
		List<Future<String>> futures = executor.invokeAll(callableTasks);
		System.out.println("Inoking all with future: ");
		futures.forEach(t -> {
			try {
				System.out.println(t.get());
			} catch (InterruptedException | ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

		executor.shutdown();
	}
}
