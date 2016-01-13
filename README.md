# cli-calc 

## A project for SE-3800 by Evan Sendra and Dan Baumgard

This project is a command line calculator which keeps history and allows substitution of historic computations.

Java version 8 (see pom.xml).
Junit version 4.11 (see pom.xml).

Maven is used to build the project and test it:

Setup the project

    $ mvn package
    
Run the tests

    $ mvn test

Output of successful test command should show:
	
	Tests run: NUMBER, Failures: 0, Errors: 0, Skipped: 0
    
Run the program (after running `mvn package`)

    $ java -cp target/se3800_cli_calc-0.0.1-SNAPSHOT.jar cli_calc.driver.Driver
    
Sample commands:

    Welcome to CLI calc, enter a command like 
    add, sub, mul, div, hist, clearhist, or addsquares.  All commands 
    save hist and clearhist accept a list of integers after the command, so an 
    example command would be '> add 1 2 3'.
    
    Enter 'q' to quit
    
    > add 1 2 3
    6.0
    > div 3 2 1
    1.5
    > add !0 1 !1
    8.5
    > hist
    add 1.0 2.0 3.0 = 6.0
    div 3.0 2.0 1.0 = 1.5
    add 6.0 1.0 1.5 = 8.5
    > clearhist
    > hist
    > q
    
All commands:

	add
	addsquares
	div
	mul
	sub
	hist
	clearhist

A command with an operator of ! followed by an number (zero-based) substitutes that result in the history of computations since beginning of program or running clearhist.

