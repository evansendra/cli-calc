package cli_calc.driver;

import cli_calc.CalcResult;
import cli_calc.History;
import cli_calc.Parser;
import cli_calc.commands.ClearHistCmd;
import cli_calc.commands.Command;
import cli_calc.commands.HistCmd;

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
                Command c;
                try {
                    c = Parser.parseInputToCommand(line);
                    CalcResult res = c.calculate();
                    History.addToHistory(res);
                    if (!c.getCmd().equals("hist") &&
                        !c.getCmd().equals("clearhist")) {
                        System.out.println(res.getRes());
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
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
