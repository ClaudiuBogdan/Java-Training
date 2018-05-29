# Key ideas:
##### Understand the control flow in a recursive computation.
* A recursive computation solves a problem by using the
  solution to the same problem with simpler inputs.
* For a recursion to terminate, there must be special cases for
  the simplest values.

##### Identify recursive helper methods for solving a problem.
* Sometimes it is easier to find a recursive solution if you make a slight change to
  the original problem.

##### Contrast the efficiency of recursive and non-recursive algorithms.
* Occasionally, a recursive solution is much slower than its iterative counterpart.
  However, in most cases, the recursive solution is only slightly slower.
* In many cases, a recursive solution is easier to understand and implement correctly than an iterative solution.

##### Review a complex recursion example that cannot be solved with a simple loop.
* The permutations of a string can be obtained more naturally through
  recursion than with a loop.

##### Recognize the phenomenon of mutual recursion in an expression evaluator.
*  In a mutual recursion, a set of cooperating methods calls each other repeatedly

##### Use backtracking to solve problems that require trying out multiple paths.
* Backtracking examines partial solutions, abandoning
  unsuitable ones and returning to consider other candidates.