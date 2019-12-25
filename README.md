# Calculator
Objective Oriented Programming Homework.

A stack calculator that uses a standard input stream to read commands.
<br>The following set of commands is implemented:
<br>• push - put a number on the stack.
<br>• pop - remove a number from the stack.
<br>• +, -, *, /, sqrt - arithmetic operations.
One or two top elements of the stack are used, removing them from the stack and putting the result back.
<br>• print - print the top element of the stack (without deleting).
<br>• define - set the value of the parameter. In the future, everywhere use instead of the parameter this value.
<br>• exp - set an arbitrary expression. The expression is translated into the reverse Polish entry, 
a list of commands is created by writing, then the commands are transferred for execution.

<br>Implemented a set of tests covering the functionality of the calculator.
<br>Implemented logging of the calculator.

<br>Creation of teams implemented through the design template "factory method".
<br>For execution, the teams are given a general execution context containing the execution stack and a container of named parameters.
<br>A hierarchy of exceptions that can generate commands during execution has been developed.
