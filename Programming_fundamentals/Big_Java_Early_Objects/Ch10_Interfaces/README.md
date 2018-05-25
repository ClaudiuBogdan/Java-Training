# Key ideas:
##### Uses interfaces to make a service available to multiple classes.
* A Java interface tupe declares the methods that can be applied to a variable of that type.
* Use the implements reserved word to indicate that a class implements an interface type.
* Use interface type to make the code more reusable.

##### Describe how to convert between class and interface types.
* You can convert from a class type to an interface type, provided
that the class implements the interface.
* Method calls on an interface reference are polymorphic. The 
appropriate method is called at runtime.
* You need a cast to convert from an interface type to a class type.

##### Use the Comparable interface from the Java library.
* Implement the **Comparable** interface so that the object of your
class can be compared, for example, in a short method.

##### Describe how to use interface types for providing callbacks.
* A **callback** is a mechanism for specifying code that 
is executed at a later time.

##### Inner class.
* Inner classes are commonly used for utility classes that should
not be visible elsewhere in the program.
