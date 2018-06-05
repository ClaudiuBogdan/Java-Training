# Key ideas:
##### Understand the concept of streams
* A stream is an immutable sequence of values that are processed lazily.
* Lazy processing means to defer operations until they are needed, and to skip
  those that are not needed.

##### Be able to create streams.
* The Stream.of static method and the stream methods of collection classes
  yield streams.

##### Collect results from streams.
* To turn a stream into an array or collection, use the toArray or collect
  methods.

##### Determine how to transform streams into a form from which you can collect results.
*  The map method applies a function to all elements of a stream, yielding
  another stream.
* The filter method yields a stream of all elements fulfilling a condition.

##### Master the syntax of lambda expressions.
* A lambda expression consists of one or more parameter variables, an arrow ->,
  and an expression or block yielding the result.
* A functional interface is an interface with a single abstract method.
* A lambda expression can be converted to an instance of a functional interface.

##### Work with values of the Optional type.
* The Optional class is a wrapper for objects that may or may not
  be present.
*  Use the orElse method to obtain the value of an Optional or, if no
  value is present, an alternative.
  
##### Know the terminal stream operations.
* A terminal operation triggers the lazy operations on a
  stream and yields a non-stream value.
  
##### Work with streams that contain values of primitive types.
* The IntStream.range method yields a stream of consecutive integers.
* The mapToInt method applies an int-valued function to stream elements and yields
  an IntStream.
* Primitive-type streams have methods sum, average, max, and min.

##### Group stream results with common characteristics.
* Using grouping collectors, you can group together elements with the same key.
* A grouping collector can apply another collector to each group.

##### Express common algorithms with stream operations.
* Many common processing tasks that involve sequences of
  values can be carried out easily with streams.
* Streams are not easily applicable to algorithms that compare
  adjacent elements of a sequence.