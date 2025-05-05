package in.bjena.interviews;

public class TwoThreadsPrintEvenOrOddNumbers {
	// Question asked me in the VCIT 1st round
	int counter = 1;
	int max = 10;

	public static void main(String[] args) {
		// Create two threads that will print even or odd numbers
		TwoThreadsPrintEvenOrOddNumbers ob = new TwoThreadsPrintEvenOrOddNumbers();

		Runnable evenTask = () -> {
			ob.printNumber(1);
		};

		Runnable oddTask = () -> {
			ob.printNumber(0);
		};

		Thread t1 = new Thread(evenTask, "T1");
		Thread t2 = new Thread(oddTask, "T2");
		t1.start();
		t2.start();

	}

	public void printNumber(int rem) {
		synchronized (this) {
			while (counter < max) {
				// If count is even then print
				if (counter % 2 == rem) {
					// Exception handle
					try {
						wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				// Print the number
				System.out.println(Thread.currentThread().getName() + " " + counter);
				// Increment counter
				counter++;
				// Notify to second thread
				notify();
			}
		}
	}
}
