# Key ideas:
##### Explain the notions of inheritance, superclass, and subclass.
* A subclass inherits data and behavior from a
  superclass.
*  You can always use a subclass object in place of a superclass object.

##### Implement subclasses in Java.
* A subclass inherits all methods that it does not
  override.
* A subclass can override a superclass method by
  providing a new implementation.
* The **extends** reserved word indicates that a class
  inherits from a superclass.
  
##### Implement methods that override methods from a superclass.
* An **overriding method** can extend or replace the functionality of the superclass
  method.
* Use the reserved word **super** to call a superclass method.
* Unless specified otherwise, the subclass constructor calls the superclass constructor with no arguments.
* To call a superclass constructor, use the super reserved word in the first statement
  of the subclass constructor.
* The constructor of a subclass can pass arguments to a superclass constructor,
  using the reserved word super.
  
##### Use polymorphism for processing objects of related types.
* A subclass reference can be used when a superclass reference is expected.
* When the virtual machine calls an instance method, it locates the method of
  the implicit parameter’s class. This is called **dynamic method lookup.**
* **Polymorphism** (“having multiple forms”) allows us to manipulate objects
  that share a set of tasks, even though the tasks are executed in different ways.

##### Work with the Object class and its methods.
* Override the **toString** method to yield a string that describes the object’s state.
* The **equals** method checks whether two objects have the same contents.
* If you know that an object belongs to a given class, use a **cast** to convert the type.
* The **instanceof** operator tests whether an object belongs to a particular type.