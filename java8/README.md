# New Features in Java 8

Java 8 was released on 18th March 2014. That’s a long time ago but still many projects are running on Java 8. It’s 
because it was a major release with a lot of new features.

- **Lambda Expressions**: Concise functional code using ->.

- **Functional Interfaces**: Single-method interfaces.

- **Introduced and Improved APIs**:
  1. **Stream API**: Efficient Data Manipulation.
  2. **Date/Time API**: Robust Date and Time Handling.
  3. **Collection API Improvements**: Enhanced Methods for Collections (e.g., removeIf, replaceAll).
  4. **Concurrency API Improvements**: New classes for parallel processing (e.g., CompletableFuture).

- **Optional Class**: Handle null values safely.

- **forEach() Method in Iterable Interface**: Executes an action for each element in a Collection.

- **Default Methods**: Evolve interfaces without breaking compatibility.

- **Static Methods**: Allows adding methods with default implementations to interfaces.

- **Method References**: Refer to methods easily.


## Lambda Expressions / Functional Interfaces

Functional interfaces are a new concept introduced in Java 8. An interface with exactly one abstract method becomes a 
Functional Interface. We don’t need to use @FunctionalInterface annotation to mark an interface as a Functional 
Interface.

@FunctionalInterface annotation is a facility to avoid the accidental addition of abstract methods in the functional 
interfaces. You can think of it like @Override annotation, and it’s best practice to use it. java.lang.Runnable with a 
single abstract method run() is a great example of a functional interface.

One of the major benefits of the functional interface is the possibility to use lambda expressions to instantiate them. 
We can instantiate an interface with an anonymous class but the code looks bulky.

Functional interfaces, which are gathered in the java.util.function package, satisfy most developers’ needs in providing 
target types for lambda expressions and method references. Each of these interfaces is general and abstract, making them 
easy to adapt to almost any lambda expression. Developers should explore this package before creating new functional 
interfaces.

So lambda expressions are a means to create anonymous classes of functional interfaces easily. There are no runtime 
benefits of using lambda expressions, so use it cautiously. A new package java.util.function has been added with a bunch 
of functional interfaces to provide target types for lambda expressions and method references. Lambda expressions are a 
huge topic.


## Stream API

One of the major new features in Java 8 is the introduction of the stream functionality – java.util.stream – which 
contains classes for processing sequences of elements. The central API class is the Stream<T>. Stream API also simplifies 
multithreading by providing the parallelStream() method that runs operations over the stream’s elements in parallel mode.

A new java.util.stream has been added in Java 8 to perform filter/map/reduce like operations with the collection. Stream 
API will allow sequential as well as parallel execution. Collection interface has been extended with stream() and 
parallelStream() default methods to get the Stream for sequential and parallel execution.

There are many useful operations that can be performed on a stream. They are divided into intermediate operations 
(return Stream<T>) and terminal operations (return a result of definite type). Intermediate operations allow chaining.
It’s also worth noting that operations on streams don’t change the source.


## Date/Time API

It has always been hard to work with Date, Time, and Time Zones in java. There was no standard approach or API in java 
for date and time in Java. One of the nice addition in Java 8 is the java.time package that will streamline the process 
of working with time in java.

It has some sub-packages java.time.format that provides classes to print and parse dates and times and java.time.zone 
provides support for time zones and their rules. The new Time API prefers enums over integer constants for months and 
days of the week. One of the useful classes is DateTimeFormatter for converting DateTime objects to strings.


## Collection API Improvements

Some new methods added in Collection API are:
- Iterator default method forEachRemaining(Consumer action) to perform the given action for each remaining element until 
all elements have been processed or the action throws an exception.
- Collection default method removeIf(Predicate filter) to remove all the elements of this collection that satisfy the 
given predicate.
- Collection spliterator() method returning Spliterator instance that can be used to traverse elements sequentially or 
parallel.
- Map replaceAll(), compute(), merge() methods.
- Performance Improvement for HashMap class with Key Collisions.


## Concurrency API Improvements

Some important concurrent API enhancements are:
- ConcurrentHashMap compute(), forEach(), forEachEntry(), forEachKey(), forEachValue(), merge(), reduce() and search() 
methods.
- CompletableFuture that may be explicitly completed (setting its value and status).
- Executors newWorkStealingPool() method to create a work-stealing thread pool using all available processors as its 
target parallelism level.


## Optional Class

Before Java 8, developers had to carefully validate values they referred to because of the possibility of throwing the 
NullPointerException (NPE). All these checks demanded a pretty annoying and error-prone boilerplate code.

Java 8 Optional<T> class can help to handle situations where there is a possibility of getting the NPE. It works as a 
container for the object of type T. It can return a value of this object if this value is not a null. When the value 
inside this container is null, it allows doing some predefined actions instead of throwing NPE.


## forEach() Method in Iterable Interface

Whenever we need to traverse through a Collection, we need to create an Iterator whose whole purpose is to iterate over, 
and then we have business logic in a loop for each of the elements in the Collection. We might get 
ConcurrentModificationException if the iterator is not used properly.

Java 8 has introduced forEach method in java.lang.Iterable interface so that while writing code we focus on business 
logic. The forEach method takes java.util.function.Consumer object as an argument, so it helps in having our business 
logic at a separate location that we can reuse. 

The number of lines might increase but forEach method helps in having the logic for iteration and business logic at 
separate place resulting in higher separation of concern and cleaner code.


## Default Methods / Static Methods

Before Java 8, interfaces could have only public abstract methods. It was not possible to add new functionality to the 
existing interface without forcing all implementing classes to create an implementation of the new methods, nor was it 
possible to create interface methods with an implementation.

Java 8 uses default and static methods heavily in Collection API and default methods are added so that our code remains 
backward compatible.

If any class in the hierarchy has a method with the same signature, then default methods become irrelevant. The Object 
is the base class, so if we have equals(), hashCode() default methods in the interface, it will become irrelevant. 
That’s why for better clarity, interfaces are not allowed to have Object default methods.


## Method References

Method reference can be used as a shorter and more readable alternative for a lambda expression that only calls an 
existing method. There are four variants of method references: reference to a static method, reference to an instance 
method, reference to an instance method of an object of a particular type and reference to a constructor.


### Sources:
- https://www.baeldung.com/java-8-new-features
- https://www.baeldung.com/java-8-lambda-expressions-tips
- https://www.baeldung.com/java-8-streams-introduction
- https://www.digitalocean.com/community/tutorials/java-8-features-with-examples
- https://www.geeksforgeeks.org/java-8-features/
- https://www.geeksforgeeks.org/new-date-time-api-java8/