# Key ideas:
##### Use arrays for collecting values.
* An **array** collects a sequence of **values of the same type**.
* Individual **elements** in an array are **accessed by an integer index i**, using the
  notation array[i].
* An array element can be used like any variable.
* An array index must be at least zero and less than the size of the array.
* A **bounds error**, which occurs if you supply an **invalid array index**, can cause your
 program to terminate.
* Use the expression **array.length** to find the **number of elements** in an array.
* An **array reference** specifies the **location of an array** (in memory). Copying the reference yields
  a second reference to the same array.
* Arrays can occur as method arguments and return values.

##### Know and use common array algorithms.
* When separating elements, don’t place a separator before the first element.
* A **linear search** inspects elements in sequence until a match is found.
* Before **inserting an element**, move elements to the end of the array starting with
  the last one.
* Use a **temporary variable** when swapping two elements.
* Use the **Arrays.copyOf** method to copy the elements of an array into a new array.

##### Use array lists for managing collections whose size can change.
* An **array list** stores a sequence of values whose **size can change**.
* The **ArrayList** class is a **generic class**: ArrayList<Type> collects
  elements of the specified type.
* Use the **size method** to obtain the current **size of an array** list.
* Use the **get and set methods** to **access an array list element at a given index.**
Use the **add and remove methods** to add and remove array list elements.
* To collect numbers in array lists, you must use **wrapper classes**.