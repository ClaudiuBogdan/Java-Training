# Key ideas:
##### Develop programs that read and write files.
* Use Scanner class for reading text files.
* Use PrintWriter class for writing text files. Use it in combination with: print/println/printf methods.
* Close all files when you are done processing them.

##### Be able to process text in files.
* The next method reads a string that is delimited by a white space.
* The Character class has methods for classifying characters.
* The nextLine method reads an entire line.
* If a string contains the digits of a number, you use the Integer.parseInt or
Double.parseDouble method to obtain the number value.

##### Process the command line argument of a program.
* Programs that starts from the command line receive the command line arguments
in the main method.

##### Use exception handling to transfer control from an error location to an error handler.
* To signal and exeption condition, use a throw statement to throw an exception object.
* When you throw an exception, processing continues in an exception handler.
* Place the statements that can cause an exception inside a try block, and the handler inside a catch clause.
* Checked exceptions are due to external circumstances that the
  programmer cannot prevent. The compiler checks that your
  program handles these exceptions.
* Add a throws clause to a method that can throw a checked exception.
* The try-with-resources statement ensures that a resource is closed when the
  statement ends normally or due to an exception.
* To describe an error condition, provide a subclass of an existing
  exception class.
* Throw an exception as soon as a problem is detected. Catch it
  only when the problem can be handled.

##### Use exception handling in a program that processes input.
*  When designing a program, ask yourself what kinds of exceptions can occur.
* For each exception, you need to decide which part of your program can competently handle it.