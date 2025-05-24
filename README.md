# javaprograms
This project contains several Java programs


Java 21 features:
================
- Record Patterns (JEP 440)
	Finalized feature allowing destructuring of record class instances in pattern matching.
	Enables concise and composable data queries with nested patterns.
- Pattern Matching for switch (JEP 441)
	Enhances switch statements to support pattern matching, making code more expressive and concise.
- Sequenced Collections
	Introduces new interfaces: SequencedCollection, SequencedSet, and SequencedMap.
	These collections maintain a predefined encounter order, allowing direct access to first and last elements.
	Useful for collections where element order and predecessor/successor relations matter.
	This interface provides methods to access and manipulate elements at both ends of a collection, such as addFirst(), addLast(), getFirst(), getLast(), and also a reversed() view.
- Virtual Threads
	Lightweight threads that drastically reduce memory footprint compared to traditional platform threads (around 1KB vs 1MB).
	Simplifies writing high-throughput concurrent applications.
- String Templates (Preview)
	Provides a way to embed expressions inside string literals for easier and safer string construction.
- Unnamed Patterns and Variables (Preview)
	Allows the use of unnamed patterns and variables in pattern matching, improving code clarity when some parts of a pattern are irrelevant.
	Unnamed variables are initialized but never used. They are denoted by an underscore (_). Typical use cases include ignoring values in lambda parameters, exception handlers, or local variables where the result is unneeded.
	Unnamed patterns allow you to match record components or nested patterns without naming or using them. This is particularly useful with pattern matching for records and switch statements.
- Unnamed Classes and Instance Main Methods (Preview)
	Simplifies program startup by allowing unnamed classes and instance main methods, reducing boilerplate for beginners.
	Unnamed Classes in Java 21
- Generational Z Garbage Collector (JEP 439)
	Enhances the Z Garbage Collector to be generational, improving performance by separating young and old objects in memory management.
