package cli_calc.driver;

import java.util.Scanner;

/**
 * drives the whole CLI calculator program
 */
public class Driver {

    /**
     * continuously receives command line input until
     * the command "q" is issued, then we exit the program
     * @param args not expected / not used
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String welcomeMsg = "Welcome to CLI calc, enter a command like " + System.lineSeparator() +
            "add, sub, mul, div, hist, clearhist, or addsquares.  All commands " + System.lineSeparator() +
            "save hist and clearhist accept a list of integers after the command, so an " + System.lineSeparator() +
            "example command would be '> add 1 2 3'." + System.lineSeparator() +
            System.lineSeparator() +
            "Enter 'q' to quit" + System.lineSeparator();
        System.out.println(welcomeMsg);

        for (prompt(); sc.hasNextLine(); prompt()) {
            String line = sc.nextLine().replaceAll(System.lineSeparator(), "");
            if (line.isEmpty()) {
                continue;
            }

            if (line.equalsIgnoreCase("q")) {
                int normalExitCode = 0;
                System.exit(normalExitCode);
            } else {
                // TODO actually process input with parser
                System.out.println(line);
            }
        }

    }

    /**
     * prompts the user for next line of input
     */
    private static void prompt() {
        System.out.print("> ");
    }
}
