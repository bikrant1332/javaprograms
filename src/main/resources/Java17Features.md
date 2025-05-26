Java 17  features details:
=================

-  Sealed Classes
--------------------
	Sealed classes restrict which other classes or interfaces may extend or implement them. This feature enhances encapsulation and control over class hierarchies, preventing unauthorized subclassing and improving maintainability in large projects.
Example:
	
	public sealed class Shape permits Circle, Square, Triangle {
    // Common properties and methods
	}

	public final class Circle extends Shape {
    // Circle-specific code
	}

	public final class Square extends Shape {
    // Square-specific code
	}

	public final class Triangle extends Shape {
    // Triangle-specific code
	}

Only the classes Circle, Square, and Triangle can extend Shape. Any other subclassing attempts will cause a compile-time error

- Pattern Matching for Switch (Preview)
--------------------------------------------------
	Java 17 introduces pattern matching for switch, allowing more concise and type-safe handling of different object types in switch statements and expressions. This eliminates the need for explicit casting and verbose type checks.
Example:
	
	int getNumberOfSides(Shape shape) {
    return switch (shape) {
        case Circle c -> 0; // Circle has no sides
        case Square s -> 4;
        case Triangle t -> 3;
        default -> throw new IllegalStateException("Unknown shape");
    };
	}
This feature simplifies the code by combining type checking and casting within the switch construct

- Text Blocks
----------------
	Text blocks allow writing multi-line string literals in a readable and concise way using triple double quotes ("""). Indentation and formatting are preserved, making it easier to work with long strings such as JSON, XML, or SQL queries
Example:
	
	String json = """
	    {
	        "name": "John",
	        "age": 30,
	        "city": "New York"
	    }
	    """;
	System.out.println(json);

This avoids the need for escape sequences and manual newline characters

- Enhanced Pseudo-Random Number Generators
------------------------------------------------------------
	Java 17 provides new interfaces and implementations for pseudo-random number generators (PRNGs), improving flexibility and performance.
Example:
	
	import java.util.random.RandomGenerator;
	import java.util.random.RandomGeneratorFactory;
	
	RandomGenerator generator = RandomGeneratorFactory.of("L64X128MixRandom").create();
	int randomInt = generator.nextInt();
	System.out.println(randomInt);

This allows choosing from different algorithms for random number generation

- New macOS Rendering Pipeline
------------------------------------------
	Java 2D API on macOS can now use the Apple Metal API for hardware-accelerated rendering instead of the deprecated OpenGL.
Example:
	
	-Dsun.java2d.metal=true
 in bash:
 	java -Dsun.java2d.opengl=true -jar YourApp.jar
 
 for a class: 	
 	java -Dsun.java2d.opengl=true YourMainClass
 
 for env variable:
	
	export JAVA_TOOL_OPTIONS="-Dsun.java2d.opengl=true"
	java -jar YourApp.jar
 
This improves graphics performance on macOS
Example with class:
	
	import javax.swing.*;
	
	public class OpenGLDemo {
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            JFrame frame = new JFrame("OpenGL Pipeline Demo");
	            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	            frame.add(new JLabel("OpenGL pipeline enabled with -Dsun.java2d.opengl=true"));
	            frame.setSize(400, 200);
	            frame.setLocationRelativeTo(null);
	            frame.setVisible(true);
	        });
	    }
	}

Run it with:
	
	java -Dsun.java2d.opengl=true OpenGLDemo



- Instanceof Pattern Matching
--------------------------------------
	Simplifies type checks and casting with instanceof
Example:
Before Java 17:
	
	if (obj instanceof String) {
	    String s = (String) obj;
	    System.out.println(s.toUpperCase());
	}

With Java 17:
	
	if (obj instanceof String s) {
	    System.out.println(s.toUpperCase());
	}
	
This reduces boilerplate and improves readability

- Records (Introduced in Java 16, widely used in Java 17)
--------------------------------------------------------------------
	Records provide a compact syntax for declaring classes that are transparent holders for shallowly immutable data
Example:

	public record Point(int x, int y) { }
	
	Point p = new Point(1, 2);
	System.out.println(p.x()); // 1

Records automatically generate constructor, equals, hashCode, and toString methods

- Memory Access API
--------------------------
	Java 17 includes incubating APIs for more efficient and safe access to off-heap memory, useful for performance-critical applications.
Using MappedByteBuffer to memory-map a file:
Example:

	import java.io.RandomAccessFile;
	import java.nio.MappedByteBuffer;
	import java.nio.channels.FileChannel;
		
	public class MemoryMappedFileExample {
	    public static void main(String[] args) throws Exception {
	        RandomAccessFile file = new RandomAccessFile("example.txt", "rw");
	        FileChannel channel = file.getChannel();
	        MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
	
	        String data = "Hello, Memory-Mapped File!";
	        buffer.put(data.getBytes());
	
	        buffer.flip();
	        byte[] readData = new byte[data.length()];
	        buffer.get(readData);
	
	        System.out.println(new String(readData));
	
	        channel.close();
	        file.close();
	    }
	}
	
This allows direct file manipulation in memory for performance benefits








