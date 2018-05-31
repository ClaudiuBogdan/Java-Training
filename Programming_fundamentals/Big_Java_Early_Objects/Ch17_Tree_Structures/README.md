# Key ideas
##### Describe and implement general trees.
* A tree is composed of nodes, each of which can have child nodes.
* The root is the node with no parent. A leaf is a node with no children.
* A tree class uses a node class to represent nodes and has an instance variable for
  the root node.
* Many tree properties are computed with recursive methods.

##### Describe binary trees and their applications.
* A binary tree consists of nodes, each of which has at most two child nodes.
* In a Huffman tree, the left and right turns on the paths to the leaves describe
  binary encodings.
* An expression tree shows the order of evaluation in an arithmetic expression.
* In a balanced tree, all paths from the root to the leaves have approximately the
  same length.

##### Explain the implementation of a binary search tree and its performance characteristics.
* All nodes in a binary search tree fulfill the property that the descendants to the
  left have smaller data values than the node data value, and the descendants to the
  right have larger data values.
* To insert a value into a binary search tree, keep comparing the value with the node
  data and follow the nodes to the left or right, until reaching a null node.
*  When removing a node with only one child from a binary search tree, the child
  replaces the node to be removed.
* When removing a node with two children from a binary search tree, replace it
  with the smallest node of the right subtree.
* In a balanced tree, all paths from the root to the leaves have about the same length.
*  If a binary search tree is balanced, then adding, locating, or removing an element
  takes O(log(n)) time.

##### Describe preorder, inorder, and postorder tree traversal.
*  To visit all elements in a tree, visit the root and recursively visit the subtrees.
* We distinguish between preorder, inorder, and postorder traversal.
* Postorder traversal of an expression tree yields the instructions for evaluating the
  expression on a stack-based calculator.
* Depth-first search uses a stack to track the nodes that it still needs to visit.
* Breadth-first search first visits all nodes on the same level before visiting the
  children.

##### Describe how red-black trees provide guaranteed O(log(n)) operations.
* In a red-black tree, node coloring rules ensure that the tree is balanced.
* To rebalance a red-black tree after inserting an element, fix all double-red
  violations.
* Before removing a node in a red-black tree, turn it red and fix any double-black
  and double-red violations.
* Adding or removing an element in a red-black tree is an O(log(n)) operation.

##### Describe the heap data structure and the efficiency of its operations.
*  A heap is an almost completely filled tree in which the value of any node is less
  than or equal to the values of its descendants.
* Inserting or removing a heap element is an O(log(n)) operation.
* The regular layout of a heap makes it possible to store heap nodes efficiently in
  an array.
  
##### Describe the heapsort algorithm and its run-time performance.
* The heapsort algorithm is based on inserting elements into a heap and removing
  them in sorted order.
* Heapsort is an O(n log(n)) algorithm.