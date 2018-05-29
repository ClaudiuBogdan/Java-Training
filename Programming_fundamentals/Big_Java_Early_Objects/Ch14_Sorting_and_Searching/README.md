# Key ideas:
##### Describe the selection sort algorithm.
* The selection sort algorithm sorts an array by repeatedly finding the smallest
  element of the unsorted tail region and moving it to the front.

##### Measure the running time of a method.
*  To measure the running time of a method, get the current time immediately before
  and after the method call.
  
##### Use the big-Oh notation to describe the running time of an algorithm.
* Computer scientists use the big-Oh notation to describe the
  growth rate of a function.
* Selection sort is an O(n^2) algorithm. Doubling the data set means a
  fourfold increase in processing time.
* Insertion sort is an O(n^2) algorithm.

##### Describe the merge sort algorithm.
* The merge sort algorithm sorts an array by cutting the array in half, recursively
  sorting each half, and then merging the sorted halves.
  
##### Contrast the running times of the merge sort and selection sort algorithms
* Merge sort is an O(n * log(n)) algorithm. The n * log(n) function grows much more
  slowly than n^2.

##### Describe the running times of the linear search algorithm and the binary search algorithm.
* A linear search examines all values in an array until it finds a match or reaches
  the end.
* A linear search locates a value in an array in O(n) steps.
* A binary search locates a value in a sorted array by determining whether the value
  occurs in the first or second half, then repeating the search in one of the halves.
* A binary search locates a value in a sorted array in O(log(n)) steps.

##### Practice developing big-Oh estimates of algorithms.
* A loop with n iterations has O(n) running time if each
  step consists of a fixed number of actions.
* A loop with n iterations has O(n^2) running time if each
  step takes O(n) time.
* The big-Oh running time for doing several steps in a row is the largest of the
  big-Oh times for each step.
* A loop with n iterations has O(n^2) running time if the ith step takes O(i) time.
* An algorithm that cuts the size of work in half in each step runs in O(log(n)) time.

##### Use the Java library methods for sorting and searching data.
* The Arrays class implements a sorting method that you should use for your Java
  programs.
* The Collections class contains a sort method that can sort array lists.
* The sort method of the Arrays class sorts objects of classes that implement the
  Comparable interface.