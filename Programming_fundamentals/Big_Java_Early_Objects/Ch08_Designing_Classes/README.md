# Key ideas:
##### Find clases that are apropriate for solving a programming problem.
* A class should represent a single concept from a problem domain, such as mathematic, business or science

##### Design methods that are cohesive, consistent and minimize side effects.
 * **Cohesive**: The public interface of a class is cohesive if all of its futures are related to the concept that the class represent.
 * **Dependency**: A class depends on another class if its methods uses that class in any way.
 * **Immutability**: An immutable class has no mutator methods.
 * References to objects of immutable class can be safely shared.
 * **Side effects**: A side effect of a method is any externally observable data modification.
 * When design method, minimize side effects.
 * In Java, a method can never change the content of a variable that is passed as an argument to that method.
 * In Java, a method can change the state of an object reference argument, but it cannot replace the object reference with another.

##### Use patterns to design the data representation of an object.
* An instance variable for the total is updated in methods that increases or decreases the total amount.
* A counter that counts events is incremented in methods that corresponds to that event.
* An object can collect other objects in an array or array list.
* An object can be accessed with a getter method and changed with a setter method.
*  If your object can have one of several states that affect the
  behavior, supply an instance variable for the current state.
* To model a moving object, you need to store and update its
  position.
  
##### Understand the behavior of static variables and static methods.
* A static variable belongs to the class, not to any object of the class.
* A static method is not invoked on an object.

##### Design programs that carry out complex tasks.
* When developing a solution to a complex problem, first solve a simpler task.
* Make a plan consisting of a series of tasks, each a simple extension of the previous
  one, and ending with the original problem.

##### Use packages to organize sets of related classes.
* A package is a set of related classes.
* The import directive lets you refer to a class of a package by its class name, without
  the package prefix.
* An instance variable or method that is not declared as
  public or private can be accessed by all classes in the same
  package, which is usually not desirable.
