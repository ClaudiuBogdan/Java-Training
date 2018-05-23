# Key ideas:
##### Use the **if** statement to implement a **decision**. 
* The **if** statement allows a program to carry out
  different actions depending on the nature of the
  data to be processed.
* When using **multiple if** statements, test **general conditions after more specific
  conditions**.
##### Implement comparisons of numbers and objects.
* Use **relational operators** (< <= > >= == !=) to compare numbers.
* **Tip:** When comparing **floating-point** numbers, don’t test for equality. Instead, check
           whether they are **close enough**.
* Do not use the == operator to **compare strings**. Use the **equals** method instead.         
* The **==** operator tests whether **two object references are
  identical**. To compare the **contents of objects**, you need to
  use the **equals** method.
* The **null** reference refers to **no object**.
##### Design test cases for your programs.
* **Black-box testing** describes a testing method that does **not take the structure of
  the implementation into account**.
* **White-box testing** uses information about the **structure of a program**.
* **Code coverage** is a measure of how many **parts of a program have been tested**.
* **Boundary test cases** are test cases that are at the **boundary of acceptable inputs**.
* **Tip:** It is a good idea to **design test cases before implementing a program**.
* **Logging messages** can be deactivated when testing is complete.
##### Use the Boolean data type to store and combine conditions that can be true or false.
* The **Boolean type** boolean has two values, **false** and **true**.
* Java has **two Boolean operators** that combine conditions: **&&** (and) and **||** (or).
* To **invert** a condition, use the **!** (not) operator.
* The && and || operators are computed using **short-circuit evaluation**: As soon as
the truth value is determined, no further conditions are evaluated.
* De **Morgan’s Law** tells you how to negate && and || conditions.