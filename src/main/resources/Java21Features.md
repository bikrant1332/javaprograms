Java 21 features::
- Record Patterns (JEP 440)
	Finalized feature allowing destructuring of record class instances in pattern matching.
	Enables concise and composable data queries with nested patterns.
	Example:
	record Point(int x, int y) {}
	public static int sumPoint(Object obj) {
	  if (obj instanceof Point(int x, int y)) {
	    return x + y;
	  }
	  return 0;
	}
- Pattern Matching for switch (JEP 441)
	Enhances switch statements to support pattern matching, making code more expressive and concise.
	example:
		record Point(int x, int y) { }
		enum Color { RED, GREEN, BLUE; }
		static void typeTester(Object obj) {
	    switch (obj) {
	        case null -> System.out.println("null");
	        case String s -> System.out.println("String: " + s);
	        case Color c -> System.out.println("Color with " + c.values().length + " values");
	        case Point p -> System.out.println("Record class: " + p);
	        case int[] ia -> System.out.println("Array of int values of length " + ia.length);
	        default -> System.out.println("Something else");
	    }
	}
	In this example, the switch expression matches the selector obj against various patterns including null, a String, an enum Color, a record Point, and an 	array of integers. Each case binds the matched value to a variable (s, c, p, ia) which can then be used directly in the case block without explicit casting. The default case handles any other unmatched types

- Sequenced Collections
	Introduces new interfaces: SequencedCollection, SequencedSet, and SequencedMap.
	These collections maintain a predefined encounter order, allowing direct access to first and last elements.
	Useful for collections where element order and predecessor/successor relations matter.
	This interface provides methods to access and manipulate elements at both ends of a collection, such as addFirst(), addLast(), getFirst(), getLast(), and also a reversed() view.
Example:
import java.util.ArrayList;
import java.util.SequencedCollection;
public class SequencedCollectionExample {
    public static void main(String[] args) {
        // Create a SequencedCollection using ArrayList (which implements SequencedCollection in Java 21)
        SequencedCollection<String> fruits = new ArrayList<>();
        // Add elements at the end
        fruits.addLast("Banana");
        fruits.addLast("Cherry");
        // Add element at the front
        fruits.addFirst("Apple");
        // Access first and last elements
        System.out.println("First element: " + fruits.getFirst()); // Output: Apple
        System.out.println("Last element: " + fruits.getLast());   // Output: Cherry
       // Remove first and last elements
        fruits.removeFirst(); // removes "Apple"
        fruits.removeLast();  // removes "Cherry"
        // Print remaining elements
        System.out.println("Remaining elements: " + fruits); // Output: [Banana]
        // Get reversed view
        SequencedCollection<String> reversed = fruits.reversed();
        System.out.println("Reversed collection: " + reversed);
    }
}
This example uses ArrayList as a SequencedCollection to show how you can add elements to the front and back, retrieve the first and last elements, remove them, and get a reversed view of the collection

- Virtual Threads
	Lightweight threads that drastically reduce memory footprint compared to traditional platform threads (around 1KB vs 1MB).
	Simplifies writing high-throughput concurrent applications.
	java
	Thread thread = Thread.ofVirtual().start(() -> {
	  System.out.println("Hello from a virtual thread!");
	});
	System.out.println(thread.isVirtual()); // true
	Supports creating millions of virtual threads using ExecutorService.

- String Templates (Preview)
	Provides a way to embed expressions inside string literals for easier and safer string construction.
	Example:
	int x = 10;
	int y = 20;
	String result = STR."\{x} + \{y} = \{x + y}";
	System.out.println(result); // Output: 10 + 20 = 30

- Unnamed Patterns and Variables (Preview)
	Allows the use of unnamed patterns and variables in pattern matching, improving code clarity when some parts of a pattern are irrelevant.
Unnamed variables are initialized but never used. They are denoted by an underscore (_). Typical use cases include ignoring values in lambda parameters, exception handlers, or local variables where the result is unneeded.
	Examples:
	Ignoring a value in a lambda:
		map.computeIfAbsent(key, _ -> new ArrayList<>());
	Here, the lambda parameter is unused and replaced with _.
	
	Ignoring an exception variable:
	
	try {
	    int number = Integer.parseInt(string);
	} catch (NumberFormatException _) {
	    System.err.println("Not a number");
	}
	The exception variable is not referenced, so _ is used.
	Local variable that is not used:
	
	int _ = someFunction(); // We don't need the result
	The result of someFunction() is intentionally ignored
	
Unnamed Patterns
	Unnamed patterns allow you to match record components or nested patterns without naming or using them. This is particularly useful with pattern matching for records and switch statements.
	Examples:	
	Pattern matching with records:
	java
	if (object instanceof Position(int x, _)) {
	    System.out.println("object is a position, x = " + x);
	}
	Only the x component is used; the second component is ignored.	
	Pattern matching with nested records:
	java
	if (object instanceof Path(Position(int x1, int y1), _)) {
	    System.out.printf("object is a path starting at x = %d, y = %d%n", x1, y1);
	}
	The second Position record is ignored entirely.
	Switch statement with unnamed patterns:
	java
	switch (ball) {
	    case RedBall _ -> process(ball);
	    case BlueBall _ -> process(ball);
	    case GreenBall _ -> stopProcessing();
	}
	The pattern variable is not needed, so _ is used
- Unnamed Classes and Instance Main Methods (Preview)
	Simplifies program startup by allowing unnamed classes and instance main methods, reducing boilerplate for beginners.
	Unnamed Classes in Java 21
Unnamed classes allow you to write Java programs without explicitly declaring a class name. The compiler implicitly wraps the top-level code in an unnamed class in the unnamed package. This simplifies the syntax for small programs or demos.

Example of an Unnamed Class
java
// No class declaration needed
void main() {
    System.out.println("Hello, World!");
}
This code compiles and runs as a complete Java program in Java 21. The compiler generates an unnamed class behind the scenes to hold the method.

Instance Main Methods in Java 21
Java 21 allows main methods to be instance methods (non-static) with no arguments or with a String array argument, and without requiring the public or static modifiers. This greatly simplifies the traditional public static void main(String[] args) signature.

Valid main method signatures include:
public static void main(String[] args) (traditional)

static void main()

void main(String[] args)

void main()

The instance main method void main() is the simplest form, requiring no parameters and no modifiers.

Example Using Instance Main Method
java
void main() {
    System.out.println("Hello, World!");
}
This method acts as the entry point for the unnamed class program.

How It Works Internally
When you run such a program, Java treats it as if you wrote:

java
new Object() {
    void main() {
        System.out.println("Hello, World!");
    }
}.main();
So the unnamed class is instantiated anonymously, and the instance main method is invoked.

Compilation and Execution
To compile and run unnamed classes and instance main methods in Java 21, you must enable preview features:

bash
javac --release 21 --enable-preview HelloWorld.java
java --enable-preview HelloWorld.java
Summary
Unnamed classes let you omit class declarations entirely.

Instance main methods let you write void main() without static or parameters.

These features simplify Java programs, especially for beginners or quick prototyping.

They are a preview feature in Java 21 and require enabling preview flags.
Scoped Values (Preview)
	Introduces scoped values as a new API for sharing immutable data within and across threads in a structured way.

- Generational Z Garbage Collector (JEP 439)
	Enhances the Z Garbage Collector to be generational, improving performance by separating young and old objects in memory management.
	Example: Enabling Generational ZGC in Java 21
To run a Java application with Generational ZGC enabled, use the following JVM options:

bash
java -XX:+UseZGC -XX:+ZGenerational -jar your-application.jar
-XX:+UseZGC enables the Z Garbage Collector.

-XX:+ZGenerational switches ZGC to its generational mode, introduced as a production feature in Java 21 (JEP 439).

Key Features of Generational ZGC
Generational Heap Structure: The heap is divided into young and old generations. New objects are allocated in the young generation, which is scanned frequently. Objects that survive longer are promoted to the old generation, which is scanned less often. This leverages the weak generational hypothesis that most objects die young, improving GC efficiency.

Concurrent and Low-Latency: Like classic ZGC, Generational ZGC performs almost all GC work concurrently with application threads, keeping pause times typically below a millisecond, regardless of heap size.

Efficient Large Object Handling: Large objects can now be allocated in the young generation and either collected quickly if short-lived or promoted efficiently if long-lived, avoiding premature allocation in the old generation and improving memory usage.

Optimized Barriers and Remembered Sets: It uses optimized store barriers and double-buffered remembered sets to track references between generations with minimal overhead, enhancing performance.

Region Density Analysis: The collector analyzes the density of regions in the young generation to selectively evacuate those with many dead objects, reducing GC effort and improving responsiveness