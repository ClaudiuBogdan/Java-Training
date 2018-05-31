# Key ideas:
##### Describe generic classes and type parameters.
* In Java, generic programming can be achieved with inheritance or with type
  parameters.
*  A generic class has one or more type parameters.
* Type parameters can be instantiated with class or interface types.
* Type parameters make generic code safer and easier to read.

##### Implement generic classes and interfaces.
*  Type variables of a generic class follow the class name and are enclosed in angle
  brackets.
* Use type parameters for the types of generic instance variables, method parameter
  variables, and return values.

##### Implement generic methods.
* A generic method is a method with a type parameter.
* Supply the type parameters of a generic method between the modifiers and the
  method return type.
* When calling a generic method, you need not instantiate the type parameters.

##### Specify constraints on type parameters
* Type parameters can be constrained with bounds.

##### Recognize how erasure of type parameters places limitations on generic programming in Java.
* The virtual machine erases type parameters, replacing them with their bounds
  or Objects.
* You cannot construct objects or arrays of a generic type.