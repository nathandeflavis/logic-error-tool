# logic-error-tool
A tool to detect and correct logic errors in models of computer programs.

# What does the project do?
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

# Why is the project useful?
Software is commonly plagued by logic errors, which cause it to behave incorrectly. These errors may not be recognised as such until long after the software is first released. Compared to detection, there has been relatively little use of tools to correct logic errors.

This field is important because defects in mission-critical software can spell disaster, like the Ariane 5 incident (Garfinkel 2005). Correct logic is arguably more of a priority than correct syntax because syntax errors are more likely to be addressed than logic errors.

Both source code compilers and Integrated Development Environments (IDEs) tend to ignore logic errors, which may not manifest themselves until runtime. Even with methods to trace the source of a logic error, the process of manually detecting logic errors is time-consuming for the programmer and prone to human error.

LET can statically analyse a model of a computer program to determine whether it would behave as expected without needing to run it. By implementing an adjustment in the event of a logic error, the program would at least be more likely to behave as expected.

LET has been effective for simple program models. It is most useful for novice programmers, who when encountering a logic error may not know how to recover from it. These users would benefit from the guidance provided by the system.

Overall, the project has been a valuable learning experience in developing research skills, managing time more effectively and thinking laterally to solve problems.

# How can users can get started with the project?
Please see the 'Overview of software' and 'Using software' sections of [the User Guide](https://github.com/nathandeflavis/logic-error-tool/wiki/User-Guide).

# Where can users can get help with the project?
Please go to [this repository's 'Wiki' tab](https://github.com/nathandeflavis/logic-error-tool/wiki).

# Who maintains and contributes to the project?
@nathandeflavis

README adapted from [GitHub Docs](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes).

# Reference list
Garfinkel, S 2005, *History’s Worst Software Bugs*, viewed 29 January 2019, https://www.wired.com/2005/11/historys-worst-software-bugs/?currentPage=all
