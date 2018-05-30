# Key ideas:
##### Describe the implementation and efficiency of linked list operations.
* A linked list object holds a reference to the first node object, and each node holds
  a reference to the next node.
* When adding or removing the first element, the reference to the first node must
  be updated.
* A list iterator object has a reference to the last visited node.
* To advance an iterator, update the position and remember the old position for the
  remove method.
*  In a doubly-linked list, accessing an element is an O(n) operation; adding and
  removing an element is O(1)
  
##### Understand the implementation and efficiency of array list operations.
* Getting or setting an array list element is an O(1) operation.
* Inserting or removing an array list element is an O(n) operation.
* Adding or removing the last element in an array list takes amortized O(1) time.

##### Compare different implementations of stacks and queues.
* A stack can be implemented as a linked list, adding and removing elements at
  the front.
* When implementing a stack as an array list, add and remove elements at the back.
* A queue can be implemented as a linked list, adding elements at the back and
  removing them at the front.
* In a circular array implementation of a queue, element locations wrap from the
  end of the array to the beginning.
  
##### Understand the implementation of hash tables and the efficiencies of its operations.
* A good hash function minimizes collisions—identical hash codes for different
  objects.
* A hash table uses the hash code to determine where to store each element.
* A hash table can be implemented as an array of buckets—sequences of nodes that
  hold elements with the same hash code.
* If there are no or only a few collisions, then adding, locating, and removing hash
  table elements takes constant or O(1) time.