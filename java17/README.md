# New Features in Java 17

Java 17 was released in September 2021, is a long-term support (LTS) release and brought several important new features 
and enhancements to the library. Some of these are more developer-focused, improving the language and the JDK, while 
others are more internal, enhancing the JVM, security, and performance.

- Text Blocks
- Improved Switch Statements
- ‘record’ Type
- ‘sealed’ Classes
- Pattern Matching with ‘instance of’
- Helpful NullPointerException
- Foreign Function & Memory API (Incubator)
- Vector API (Second Incubator)
- Some more improvements:
  1. Compact Number Formatting Support
  2. Day Period Support Added
  3. Enhanced Pseudo-Random Number Generators


## Text Blocks

Java has introduced text blocks to make the code more readable and to avoid unnecessary string formatting. Now, we can 
place our text in between the triple quotes and have multiple double-quoted strings inside it without having to use 
escape characters.

This makes it very easy to write Json and similar string which would require heavy usage of escape characters. Two new 
escape characters have been introduced for use inside text blocks, ‘\s’ for adding a space and ‘\’ for removing newline. 
Especially useful when writing long SQL statements.


## Improved Switch Statements

Forgetting a single break among multiple lines of switch-case statements is not at all a welcomed guest. Moreover, the 
case-break-case-break pattern doesn’t seem to be a good deal when dealing with many switch cases. Yes, now we don’t have 
to break with the frequent use of break! Java addressed our concern and here we present the new switch statement 
expressions in Java 17. The new switch expressions are less error-prone as it is cleaner and simpler now. The use of 
arrow symbols not only eliminates the fall-through functionality but also makes it more readable and easy to debug.

Switch Expressions will allow you to return values from the switch case and use these return values in assignments, etc. 
Java allows use of operator ->(arrow) instead of : (colon) to denote the return expression. break keyword will not be 
needed when returning using switch in this expression, but default case is required.

In case of multiple operations done inside a switch case, we can have a case block and denote the return value using the 
yield keyword. yield here is a context dependent keyword i.e. you can have a variable name yield somewhere else inside 
the function.

Previously, keeping selector expression as null in switch statement and expression used to throw NullPointerException, 
and we essentially have to throw a Null Pointer Exception to be on a safer side. To resolve this issue, Java 17 has come 
up with a feature where we can put null as a selector expression in switch case expressions.


## ‘record’ Type

Record classes were previewed in Java 14. The complex and ugliest POJO code looks nicer when implemented with Records. A 
record class is a special kind of class in Java that is declared with the record keyword. It is a final class by default 
and implicitly finalizes its components, making it a perfect candidate for representing simple data carriers or data 
transfer objects (DTOs).

Key features:
- Record Classes are Immutable.
- Record implements boiler plate code like equals, hashCode, etc.
- Record comes with canonical constructor which initializes all components.
- You can use nested classes and interfaces inside a record. 
- You can have nested records too, which will implicitly be static. 
- A record can implement interfaces. 
- You can create a generic record class. 
- Records are serializable.

Although we can reduce most of our boilerplate code by using libraries like lombok, we can still reduce it even further 
with the help of records. We can even define method local record objects. The records object automatically provides us 
with getter, equals and hashcode methods for all its fields.

The fields inside the record cannot be changed, and it can only be defined by the arguments given when declaring the 
record as shown above (but we can define static variables). We can also define a custom constructor which can validate 
the fields. It is recommended that we do not override the getters and setters of records which could affects its 
immutability.


## ‘sealed’ Classes

Sealed classes were a preview feature in JDK 15, and now they have come as a full feature in JDK 17. When inheritance was 
introduced, there was a mixed opinion of people as it didn’t restrict the number of implementations. Sealed classes bring 
an end to this as it is a feature with which one can restrict the implementations. To cut to the chase, sealed classes 
give us the privilege of controlling which classes or models can implement or extend that interface or class respectively. 
It represents restricted class hierarchies that provide control over an inheritance. For a sealed class, all direct 
subclasses need to be known at compile-time and third-party clients can’t extend a sealed class in their code. To make a 
Java class, a sealed Java class, add the sealed modifier to its declaration, and keyword permits are placed to indicate 
the classes which are permitted for the given sealed class.

Sealed class will give us more control over which classes are allowed to extend our classes. In Java 11, a class can be 
final or extended. If you want to control which classes can extend your super class, you can put all classes in the same 
package, and you give the super class package visibility. However, it is not possible anymore to access the super class 
from outside the package.

The subclasses of a sealed class can be either final, sealed, or non-sealed:
- Final: Cannot be subclassed further.
- Sealed: Can be subclassed but must also specify its permitted subclasses.
- Non-sealed: Can be subclassed by any class (essentially opting out of the sealing contract).
- Interfaces: Sealed classes can also be interfaces. The same rules apply: you must explicitly specify which interfaces 
or classes are permitted to extend or implement the sealed interface.

Benefits of sealed classes:
- Compiler Enforcement: The Java compiler enforces the rules of sealed classes. If a class is declared to extend a 
sealed class but is not listed in its permitted subclasses, the compiler will reject it.
- Reflection API: Java’s reflection API has been updated to recognize sealed classes and their permitted subclasses.
- Pattern Matching: Sealed classes enhance pattern matching by ensuring that all possible subtypes are covered in a 
switch expression, thus avoiding the need for a default case.


## Pattern Matching with ‘instance of’

In Java 11, we usually use the instance of operator to check whether an object belongs to a certain class. We need to 
explicitly cast the object to that particular class if we want to perform some operation on it once the instance of 
check returns true.


## Helpful NullPointerException

In Java 11 , when we get a NullPointerException, we only get the line number on which the exception occurred, but we 
don’t get the method or variable which resolved to null. With Java 17, the messaging has been improved as the 
NullPointerException message also tells us the exact method invocation which caused the NullPointerException.


## Foreign Function & Memory API (Incubator)

It is part of Java’s effort to evolve the Java foreign function and memory API, which was first introduced in Java 14 as 
an incubator module under JEP 370. The main goal of this API is to provide a pure Java API for calling native code and 
working with native memory, as a more efficient way of working with native functions as opposed to JNI.


## Vector API (Second Incubator)

The Vector API deals with the SIMD (Single Instruction, Multiple Data) type of operation, meaning various sets of 
instructions executed in parallel. It leverages specialized CPU hardware that supports vector instructions and allows 
the execution of such instructions as pipelines. As a result, the new API will enable developers to implement more 
efficient code, leveraging the potential of the underlying hardware.

Everyday use cases for this operation are scientific algebra linear applications, image processing, character processing, 
and any heavy arithmetic application or any application that needs to apply an operation for multiple independent 
operands.


## Compact Number Formatting Support

A factory method is added to NumberFormat class in order to format numbers in compact, human-readable form according to 
the Unicode standard.


## Day Period Support Added

A new pattern “B” is added to DateTime pattern allowing it to specify the time of the day.


## Enhanced Pseudo-Random Number Generators

It provides a new interface type and implementations for pseudorandom number generators to make it easier to use various 
PRNG algorithms and to better support stream-based operations.

JEP 356 provides new interfaces and implementations for Pseudo-Random Number Generators (PRNG). So, it’s easier to use 
different algorithms interchangeably, and it also offers better support for stream-based programming. Legacy random 
classes, such as java.util.Random, SplittableRandom and SecureRandom now extend the new RandomGenerator interface.


### Sources
- https://www.baeldung.com/java-17-new-features
- https://www.geeksforgeeks.org/features-of-java-17/
- https://www.geeksforgeeks.org/jdk-17-new-features-in-java-17/
- https://adevait.com/java/jdk-17-new-features-java-17
- https://medium.com/@vikas.taank_40391/java-17-features-you-must-know-685ead229f16
- https://medium.com/javarevisited/java-17-vs-java-11-exploring-the-latest-features-and-improvements-6d13290e4e1a