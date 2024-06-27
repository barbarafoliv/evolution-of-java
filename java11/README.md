# New Features in Java 11

Oracle released Java 11 in September 2018, only 6 months after its predecessor, version 10. Java 11 is the first 
long-term support (LTS) release after Java 8. Oracle also stopped supporting Java 8 in January 2019. As a consequence, 
a lot of us upgraded to Java 11.

- **Developer Features**
  1. **New String methods**
  2. **New File methods**
  3. **Collection to an Array**
  4. **Not Predicate method**
  5. **Local-Variable syntax for Lambda**
  6. **HTTP Client**
  7. **Nest-Based Access Control**
  8. **Running Java files**

- **Performance Enhancements**
  1. **Dynamic Class-File constants**
  2. **Improved Aarch64 Intrinsics**
  3. **No-Op Garbage Collector**
  4. **Flight Recorder**

- **Removed and Deprecated Modules**
  1. **Removed Java EE and CORBA modules**
  2. **Removed JMC and JavaFX**

- **Miscellaneous Changes**
  1. **ZGC (Experimental)**
  2. **ChaCha20 and Poly1305 Cryptographic Algorithms**


## New String methods

These methods can reduce the amount of boilerplate involved in manipulating string objects, and save us from having to 
import libraries.

- Method **isBlank()**. It checks whether a string is empty or contains only white spaces.
- Method **strip()**. It removes white spaces from both the beginning and the end of a string. This method is similar to 
the trim() method, but it is more powerful because it can handle Unicode white spaces.
- Method **lines()**. It returns a stream of strings, which is a collection of all substrings split by lines.
- Method **repeat(int)** It simply repeats the string that many numbers of times as mentioned in the method in the form 
of an int.


## New File methods

Java 11 strives to make reading and writing of String convenient. It has introduced the following methods for reading 
and writing to/from the files:
- readString()
- writeString()


## Collection to an Array

The java.util.Collection interface contains a new default toArray method which takes an IntFunction argument. This makes 
it easier to create an array of the right type from a collection.


## Not Predicate method

A static not method has been added to the Predicate interface. We can use it to negate an existing predicate, much like 
the negate method. 


## Local-Variable syntax for Lambda

One of the most significant changes introduced in Java 11 is the ability to use the var keyword in lambda expressions. 
This feature allows you to declare lambda parameters using var instead of explicitly declaring their type.

JEP 323, Local-Variable Syntax for Lambda Parameters is the only language feature release in Java 11. In Java 10, Local 
Variable Type Inference was introduced. Thus, we could infer the type of the variable from the RHS -
var list = new ArrayList<String>(); JEP 323 allows var to be used to declare the formal parameters of an implicitly 
typed lambda expression.

But why is this needed when we can just skip the type in the lambda? If you need to apply an annotation just as 
@Nullable, you cannot do that without defining the type. Limitation of this feature - You must specify the type var on 
all parameters or none.


## HTTP Client

Java 11 comprises a new HTTP client. (Since Java 9, this had been available as an ‘incubator’ module, but it has now 
graduated following the finalisation of its API). It contained the client in the java.net.http module/package and 
comprises the following important interfaces and classes:

- HttpClient is the entry point for utilising the API.
- HttpRequest is a request to be sent through the HttpClient.
- HttpResponse is the result of an HttpRequest call.
- WebSocket is the entry point for building up a WebSocket client.

The client is a considerable enhancement over Java’s continuing HTTP client support –  java.net.HttpURLConnection – 
which, owing to the various limitations, was not a feasible choice for production usage. The enhancements include:
- **Easier API and Better Code Readability** – A fluent API ensures constructing requests and processing responses are 
easier to code, simpler to understand, and less verbose. Usage of the Builder pattern rather than setter techniques also 
enhances the client’s thread safety and its requests/responses.
- **Compatible with other contemporary Java APIs** – The client backs using contemporary Java (8+) language features and 
APIs, such as Lambda expressions, Optional, and the standard (java.time) Date and Time API, and so on.
- **Support for Non-blocking I/O** – The client supports executing requests without blocking the current thread through 
the usage of an async API/callbacks, which utilise java.util.concurrent.CompletableFuture
- **Protocol support** – Besides HTTP/1.1, the latest HTTP client also offers support for HTTP/2 (the default, with 
automatic negotiation and fallback to HTTP/1.1) along with WebSocket.


## Nest-Based Access Control

Java supports several classes to be declared in a single source file, like nested classes. However, from the user’s 
perspective, they are regarded to belong to the “same class”. Thus, users assume them to have a shared access regime 
relative to their attributes. To sustain these assumptions, compilers should expand private attribute access to classes 
in the same package by incorporating access bridges. They assembled an invocation of a private member into a call of a 
compiler-generated method (getter) in the target class, which accesses the proposed private member.

For instance, with a NestedClass class, nested within a NestingClass class, which requires accessing one of the private 
attributes of the host class. The compiler splits the two classes and sets up a public access method to nestingInt 
adopted by the NestedClass class.

These bridges undermine the encapsulation (private no longer has the same meaning) and can mislead users and tools. A 
formal idea of a group of nesting class files (or nest), where nest partners share a common access control technique, 
makes it plausible to get the anticipated outcome directly in a simpler, more safe, and more transparent way. To readily 
connect nested classes and hosts in JDK 11, it has incorporated two new attributes to the classes: NestMembers (nest 
members) and NestHost (new host).

Also, they have added 3 methods to java.lang.Class:
- Class getNestHost ()
- Class [] getNestMembers ()
- boolean isNestmateof (Class)


## Running Java files

We can execute the file directly without the need for a separate compilation step. The Java interpreter will compile the 
code and execute the program in one step. Before Java 11, this program would need to be compiled into a class file using 
the javac command and then executed using the java command.


## Dynamic Class-File constants

The Java class-file format now extends support a new constant pool form, CONSTANT_Dynamic. The goal of this JEP is to 
reduce the cost and disruption of developing new forms of materializable class-file constraints, by creating a single 
new constant-pool form that can be parameterized with user-provided behavior.


## Improved Aarch64 Intrinsics

Java 11 optimizes the existing string and array intrinsics on ARM64 or AArch64 processors. Additionally, new intrinsics 
are implemented for sin, cos, and log methods of java.lang.Math. We use an intrinsic function like any other; however, 
the intrinsic function gets handled in a special way by the compiler. It leverages CPU architecture-specific assembly 
code to boost performance.


## No-Op Garbage Collector

A new garbage collector called Epsilon is available for use in Java 11 as an experimental feature.

It’s called a No-Op (no operations) because it allocates memory but does not actually collect any garbage. Thus, Epsilon 
is applicable for simulating out of memory errors.

Unlike the JVM GC which is responsible for allocating memory and releasing it, Epsilon only allocates memory. It 
allocates memory for the following things:
- Performance testing.
- Memory pressure testing.
- VM interface testing.
- Extremely short-lived jobs.
- Last-drop latency improvements.
- Last-drop throughput improvements.

Now Elipson is good only for test environments. It will lead to OutOfMemoryError in production and crash the 
applications. The benefit of Elipson is no memory clearance overhead.


## Flight Recorder

Flight Recorder which earlier used to be a commercial add-on in Oracle JDK is now open-sourced since Oracle JDK is 
itself not free anymore. JFR is a profiling tool used to gather diagnostics and profiling data from a running Java 
application. Its performance overhead is negligible and that’s usually below 1%. Hence, it can be used in production 
applications.


## Removed Java EE and CORBA modules

Standalone versions of the Java EE technologies are available on third-party sites; therefore, there is no need for Java 
SE to include them. The modules were already deprecated in Java 9. They are now completely removed. Following packages 
are removed: java.xml.ws, java.xml.bind, java.activation, java.xml.ws.annotation, java.corba, java.transaction, 
java.se.ee, jdk.xml.ws, jdk.xml.bind.


## Removed JMC and JavaFX

JDK Mission Control (JMC) is no longer included in the JDK. A standalone version of JMC is now available as a separate 
download. The same is true for JavaFX modules; JavaFX will be available as a separate set of modules outside the JDK.


## ZGC (Experimental)

ZGC (Z Garbage Collector) is an experimental feature. It is a scalable, low-latency garbage collector designed to work 
with large heaps. The goal of ZGC is to provide consistent pause times regardless of the heap size. Before ZGC, the 
default GC in Java was the G1 garbage collector, which could lead to unpredictable pause times and was not designed to 
work with very large heaps. ZGC is a concurrent garbage collector, which means that it can run concurrently with the 
application threads. This allows the garbage collector to do its work without stopping the application, which reduces 
pause times. ZGC also uses a compacting algorithm, which moves live objects to contiguous memory blocks, reducing heap 
fragmentation.


## ChaCha20 and Poly1305 Cryptographic Algorithms

These algorithms are designed to be fast, secure, and resistant to side-channel attacks. ChaCha20 is a stream cipher, 
meaning it encrypts data one byte at a time. It was designed by Daniel J. Bernstein as a faster and more secure 
alternative to other stream ciphers like RC4. It is widely used in various applications including TLS, SSH, and VPNs.

Poly1305, on the other hand, is a message authentication code (MAC) algorithm. It is used to provide authenticity and 
integrity for data, meaning that it can detect any unauthorized changes to the data. It was also designed by Daniel J. 
Bernstein as a faster and more secure alternative to other MAC algorithms like HMAC.

When used together, ChaCha20 and Poly1305 provide what is called an “authenticated encryption with associated data” 
(AEAD) scheme. This means that they provide both encryption and authentication for data, as well as the ability to 
include additional metadata (known as associated data) that is authenticated but not encrypted.


### Sources:
- https://www.baeldung.com/java-11-new-features
- https://www.geeksforgeeks.org/java-11-features-and-comparison/
- https://www.digitalocean.com/community/tutorials/java-11-features
- https://medium.com/@himani.prasad016/java-11-features-164c2094e868
- https://www.interviewbit.com/blog/java-11-features/