# logic-error-tool
A tool to detect and correct logic errors in models of computer programs

The key deliverable of my independent Final Year Project at University of London was LogicErrorTool (LET), a Java Swing application with GUI forms for different types of logic error. Via a form, the end user specifies a model of a computer program. LET checks the model for logic error, and suggests one or more corrections. The end user can select a correction for LET to implement. I followed Agile evolutionary prototyping.

LET supports the following types of logic error:
- **Infinite loop/recursion, count-controlled by a variable whose runtime values form an arithmetic/geometric sequence.** LET uses a form of static code analysis, where it infers the finiteness of a loop/recursive method from its parameters without needing to run it.

![The end user inputs a loop.](https://github.com/nathandeflavis/logic-error-tool/assets/92447278/cdfbf4c8-e269-455a-9276-bb7fdee38ec4)

![LET finds an infinite loop error and suggests corrections.](https://github.com/nathandeflavis/logic-error-tool/assets/92447278/2b58e86b-94b7-4732-9d84-72b5445848fa)

- **Omission of necessary parentheses in arithmetic expressions.** LET compares an expected arithmetic expression with one that represents a given sequence of arithmetic-related instructions.

![The end user inputs instructions and the arithmetic expression they expect to represent the instructions.](https://github.com/nathandeflavis/logic-error-tool/assets/92447278/a2cbd71b-44f1-4eff-a381-93151672af2f)

![LET finds an arithmetic expression error and suggests a correction.](https://github.com/nathandeflavis/logic-error-tool/assets/92447278/c340f965-e8ef-493c-a089-f968b53d32ed)

- **Off-by-one error.** LET determines whether an expected range of positions in an array corresponds to the range of indices at which a given loop would access an array if run. The position range is 1-based, and the index range 0-based.

![The end user inputs an array position range and a loop they expect to traverse the array at the corresponding index range.](https://github.com/nathandeflavis/logic-error-tool/assets/92447278/d03838fd-d1c2-4b26-9a9d-5a1aa0907e20)

![LET finds an error that is likely off-by-one and suggests corrections.](https://github.com/nathandeflavis/logic-error-tool/assets/92447278/05edf9f1-002d-47f6-80ec-6136a98dfc95)

- **Null dereferencing of a string instance (instance in Java) variable uninitialised by a constructor.** The end user specifies a set of instance variables uninitialised outside of constructors, a set of constructors, and a sequence of variable initialisations for each constructor. LET then determines whether within each constructor, all variables are initialised.

![The end user inputs string instance variables, constructors, and initialisations.](https://github.com/nathandeflavis/logic-error-tool/assets/92447278/c3d61366-c577-464b-91f1-396ddc741f5f)

![LET finds a null pointer error and suggests a correction.](https://github.com/nathandeflavis/logic-error-tool/assets/92447278/9ba3d5d3-928a-49ab-96c4-a212fc88ba9d)

I would have liked the project to be broader in scope. However, I was pleased with what I managed to achieve in the time available.

# User guide
The structure of this guide was adapted from Dawson (2015, pp. 233-234).

## Overview of software
This software detects and corrects logic errors in models of object-oriented programs. It is intended especially for Java developers but may benefit developers programming in other languages.
## Minimum hardware requirements
Storage requirements may vary but at least 128MB of available RAM and 2MB of available hard drive capacity are recommended. A Java-compatible desktop operating system is required.
## Installing software
Only the Java Runtime Environment (JRE) (version 8 or later) needs to be installed to run the software. The JRE is downloadable from https://www.java.com/inc/BrowserRedirect1.jsp?locale=en.
## Starting software
To start the software:
- Navigate to the directory ‘NathanDeFlavis_120322787_CO3320_AdditionalMaterial’ > ‘LogicErrorTool’ > ‘dist’ and double-click the ‘LogicErrorTool.jar’ file.
- Alternatively, the software can be run at the command line. The ‘README.txt’ file, in the same directory, explains how to do this.

## Using software
### Infinite loop/recursion error
1. Enter integer values for ‘a’, ‘b’, and ‘d’ / ‘r’.
2. Select a relation operator for ‘R’.
3. Select an arithmetic operator between ‘i’ and ‘d’ / ‘r’.
4. Click ‘Check’.

If loop/recursion is finite:
5. Click ‘OK’.

If loop/recursion is infinite:
5. Select a correction.
6. Click ‘Change’.

### Arithmetic expression error
1. Add instructions as follows:
a. Select an operation under ‘Operation’. NB: The ‘RESULT’ variable refers to
the result of the last instruction. The ‘STORE’ operation temporarily stores a
copy of ‘RESULT’ in the ‘STORAGE’ variable.
b. Enter expressions for ‘a’ and ‘b’.
c. Click ‘Add’.
2. Enter an arithmetic expression that the instructions are expected to generate.
3. Click ‘Check’.

If the arithmetic expression is correct:
4. Click ‘OK’.

If the arithmetic expression is incorrect:
4. Click ‘Yes’.

### Off-by-one error
1. Enter values for ‘Start position’, ‘End position’, ‘a’, and ‘b’.
2. Select a relational operator for ‘R’.
3. Select a value for ‘d’.
4. Click ‘Check’.

If the loop is correct:
5. Click ‘OK’.

If the loop is incorrect:
5. Select a correction.
6. Click ‘Change’.

### Null pointer error
1. Add variables as follows:
a. Enter a value for ‘Name’.
b. Click ‘Add’ under ‘Name’.
2. To add constructors other than the default constructor, click ‘Add’ under
‘Constructors’.
3. Add initialisations of a variable in a constructor as follows:
a. Select a variable.
b. Select a constructor.
c. Enter a value for ‘Selected variable: Value’. d. Click ‘Add’ below ‘Selected variable: Value’.
4. Click ‘Check’.

If there is no null pointer error:
5. Click ‘OK’.

If there is a null pointer error:
5. Click ‘Yes’.

## Ending and uninstalling software
To stop running the software, close the ‘LogicErrorTool’ window.
Only the JRE can be uninstalled. To uninstall the JRE, see https://www.java.com/en/uninstall/.

# Reference list
Dawson, C 2015, *Projects in Computing and Information Systems: A Student's Guide*, 3rd edn, Pearson Education Ltd, Harlow
