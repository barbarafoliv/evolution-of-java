# New Features in Java 21

The previous JDK version, Java 20, was released on 21 March 2023. The new version Java 21, set to be released on 19 
September 2023, is an LTS release that brings 15 finalized features including core language extensions,
new features for 
developing multithreaded code,
and updates for the Z Garbage Collector and continued work on providing a JNI alternative.

- Record Patterns
- Pattern Matching for Switch
- String Literal
- Virtual Threads
- Sequenced Collections
- Unnamed Patterns and Variables
- Unnamed Classes and Instance Main Methods
- Structured Concurrency
- Scooped Values


## Record Patterns

Record patterns were included in Java 19 and Java 20 as preview features. Now, with Java 21, they are out of the preview 
and include some refinements. This JEP extends the existing pattern-matching feature to destructure the record class 
instances, which enables writing sophisticated data queries. Moreover, this JEP adds support for nested patterns for 
more composable data queries.


## Pattern Matching for Switch

It simplifies switch statements, making them more concise and readable. Initially introduced in JDK 17, Pattern matching 
for the switch was refined in JDK 18, 19, and 20 and improved further in JDK 21. The main goal of this feature is to 
allow patterns in switch case labels and improve the expressiveness of switch statements and expressions. Besides, there 
is also an enhancement to handle NullPointerException by allowing a null case label.


## String Literal

String templates, which are scheduled to be introduced as a preview feature in JDK 21, aim to simplify the process of 
string formatting and manipulation in Java. This feature enables developers to incorporate expressions directly within 
string literals, thus facilitating the creation and formatting of intricate strings.

Java offers several mechanisms for composing strings with string literals and expressions. Some of these are String 
concatenation, StringBuilder class, String class format() method, and the MessageFormat class. Java 21 introduces string 
templates. These complement Java’s existing string literals and text blocks by coupling literal text with template 
expressions and template processors to produce the desired results.

We have a template processor (STR), a dot character, and a template that contains an embedded expression (\{name}). At 
runtime, when the template processor evaluates the template expression, it combines the literal text in the template 
with the values of the embedded expression to produce the result. The STR is one of Java’s template processors, and it 
is automatically imported into all Java source files. Java also offers FMT and RAW template processors.


## Virtual Threads

Virtual threads were initially introduced to the Java language as a preview feature in Java 19 and further refined in 
Java 20. Java 21 introduced some new changes. Virtual threads are lightweight threads with the purpose of reducing the 
effort of developing high-concurrent applications. Traditional threads, also called platform threads, are thin wrappers 
around OS threads. One of the major issues with platform threads is that they run the code on the OS thread and capture 
the OS thread throughout its lifetime. There is a limit to the number of OS threads, and this creates a scalability 
bottleneck.

Like platform threads, a virtual thread is also an instance of java.lang.Thread class, but it isn’t tied to a specific 
OS thread. It runs the code on a specific OS thread but does not capture the thread for an entire lifetime. Therefore, 
many virtual threads can share OS threads to run their code.

Java 21 introduced two notable changes to the virtual threads:
- Virtual threads now always support thread-local variables
- Virtual threads are created through the Thread.Builder APIs are also monitored through their lifetime and observable 
in the new thread dump

With the introduction of virtual threads, it becomes possible to execute millions of virtual threads using only a few 
operating system threads. The most useful aspect is that there is no need to modify existing Java code. All that 
is required is instructing our application framework to use virtual threads in place of platform threads. Please 
note that virtual threads are not faster than platform threads. They should be used to scale the number of concurrent 
tasks that spend much of their time waiting. For example, server applications that handle many client requests and 
perform blocking I/O operations. For resource/processing-intensive tasks, continue using the traditional platform 
threads, as virtual threads will not provide any advantage.


## Sequenced Collections

Java 21 introduces Sequenced Collections, making it easier to work with ordered data. In the Java collection framework, 
no collection type represents a sequence of elements with a defined encountered order. For instance, List and Deque 
interfaces define an encounter order, but their common super type Collection doesn’t. In the same way, Set doesn’t 
define an encounter order, but subtypes such as LinkedHashSet or SortedSet do. Java 21 introduced three new interfaces 
to represent sequenced collections, sequenced sets, and sequenced maps.

A sequenced collection is a collection whose elements have a defined encounter order. It has first and last elements, 
and the elements between them have successors and predecessors.  A sequenced set is a set that is a sequenced collection 
with no duplicate elements. A sequenced map is a map whose entries have a defined encountered order.

With the introduction of JDK 21 and the Sequenced Collections feature, accessing the first and last elements becomes 
more consistent and straightforward. The new methods simplify the process across different collection types:
*For List, Deque, Set*
- First Element — collection.getFirst()
- Last Element — collection.getLast()


## Unnamed Patterns and Variables

Java 21 introduces Unnamed Patterns and Variables, making your code more concise and expressive. It is common in some 
other programming languages (such as Scala and Python) that we can skip naming a variable that we will not use in the 
future. Now, since Java 21, we can use the unnamed/unused variables in Java as well. Underscore signifies the absence of 
a name.


## Unnamed Classes and Instance Main Methods

Java 21 introduces a fresh approach to defining classes and instance main methods right in your code. In Java, unnamed 
modules and packages are a familiar concept. When we do not create a module-info.java class, then the module is 
automatically assumed by the compiler. Similarly, if we do not add the package statement in the class in the root 
directory, the class just compiles and runs fine. The same way, we can now create unnamed classes. Quite obviously, an 
unnamed class is a class without a name.


## Structured Concurrency

Structured concurrency, in a preview stage, simplifies concurrent programming via an API for structured concurrency, 
treating groups of related tasks running in different threads as a single unit of work. This streamlines error handling 
and cancellation, improving reliability and enhancing observability. Structured concurrency previously was incubated in 
JDK 20 and JDK 19, released in March and September 2022 respectively; it is to be featured as a preview API in the 
java.util.concurrent package. The only significant change this time around is that the 
<a href="https://cr.openjdk.org/~alanb/sc/api/java.base/java/util/concurrent/StructuredTaskScope.html" 
rel="nofollow">StructuredTaskScope::Fork(…)</a> method returns a [Subtask] rather than a 
<a href="https://docs.oracle.com/en/java/javase/20/docs/api/java.base/java/util/concurrent/Future.html" 
rel="nofollow">Future</a>. Goals of structured concurrency include promoting a style of concurrent programming that can 
eliminate common risks arising from cancellation and shutdown, such as thread leaks and cancellation delays, along with 
improving the observability of concurrent code.

Structured concurrency is closely tied to virtual threads, and it aims to eliminate common risks such as cancellation, 
shutdown, thread leaks, etc., by providing an API that enhances the developer experience. If a task splits into 
concurrent subtasks, then they should all return to the same place, i.e., the task's code block. Furthermore, the 
lifetime of the subtasks should not be more than the parent itself. Imagine a task operation that would compose results 
of multiple fast-running I/O operations concurrently if each operation is executed in a thread. The structured 
concurrency model brings thread programming closer to the ease of single-threaded code style by leveraging the virtual 
threads API and the StructuredTaskScope.


## Scooped Values

Scoped values, also in preview, will enable the sharing of immutable data within and across threads. They are preferred 
to thread-local variables, particularly when using large numbers of virtual threads. Thread-local variables have design 
flaws including unconstrained mutability, unbounded lifetime, and expensive inheritance. A scoped value allows data to 
be safely shared between components in a large program without resorting to method arguments. This proposal was 
incubated in JDK 20. The goals of the plan include ease of use, comprehensibility, robustness, and performance.


### Sources
- https://www.baeldung.com/java-lts-21-new-features
- https://blogs.oracle.com/java/post/the-arrival-of-java-21
- https://developers.redhat.com/articles/2023/09/21/whats-new-developers-jdk-21#virtual_threads
- https://javadzone.com/java-21-features-with-examples/
- https://howtodoinjava.com/java/java-21-new-features/
- https://www.infoworld.com/article/2338097/jdk-21-the-new-features-in-java-21.html
- https://medium.com/@javadzone/java-21-features-with-practical-examples-56172e73b46c
- https://medium.com/@dheerubhadoria/java-21-features-with-example-a348f4c40e99
- https://pretius.com/blog/java-21-features/