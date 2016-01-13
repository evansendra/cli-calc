/**
 * @author sendrae
 */
package cli_calc;

import cli_calc.commands.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

enum OperatorType {
    ADD,
    ADDSQUARES,
    DIV,
    MUL,
    SUB
}

/**
 * parses input from user
 */
public class Parser {
    /**
     * @param in the command from user
     * @return the command to be executed by the calculator
     * @throws IllegalArgumentException if <tt>in</tt> was not understood
     */
    public static Command parseInputToCommand(String in) throws IllegalArgumentException {
        String[] tok = in.split(" ", 2);
        if (tok.length < 1) {
            throw new IllegalArgumentException("Not enough arguments provided in command.");
        }

        Command output;
        switch (tok[0].toLowerCase()) {
            case "add":
                output = parseMathComputation(tok, OperatorType.ADD);
                break;
            case "addsquares":
                output = parseMathComputation(tok, OperatorType.ADDSQUARES);
                break;
            case "clearhist":
                output = new ClearHistCmd();
                break;
            case "div":
                output = parseMathComputation(tok, OperatorType.DIV);
                break;
            case "hist":
                output = new HistCmd();
                break;
            case "mul":
                output = parseMathComputation(tok, OperatorType.MUL);
                break;
            case "sub":
                output = parseMathComputation(tok, OperatorType.SUB);
                break;
            default:
                throw new IllegalArgumentException(tok[0] + " not recognized as a command");
        }
        if (output == null) {
            throw new IllegalArgumentException("Something went wrong here.");
        }
        return output;
    }

    private static Command parseMathComputation(String[] tokenizedInput, OperatorType t) {
        // take all arguments after the operator command
        String[] inArgs = Arrays.copyOfRange(tokenizedInput, 1, tokenizedInput.length);

        if (inArgs.length < 1) {
            throw new IllegalArgumentException("Not enough arguments provided in command.");
        }

        String[] tok = inArgs[0].split(" ");
        List<Double> l = new ArrayList<>();
        for (String arg: tok) {
            l.add(evaluateArgument(arg));
        }

        Command retCmd;
        switch (t) {
            case ADD:
                retCmd = new AddCmd(l);
                break;
            case ADDSQUARES:
                retCmd = new AddSquaresCmd(l);
                break;
            case DIV:
                retCmd = new DivCmd(l);
                break;
            case MUL:
                retCmd = new MulCmd(l);
                break;
            case SUB:
                retCmd = new SubCmd(l);
                break;
            default:
                throw new IllegalArgumentException("Something went wrong here.");
        }
        return retCmd;
    }

    /**
     * if in just a number, returns the number itself
     * if in is meant to retrieve a historical value (e.g. "!3"), gets the historical value at
     * that index, if it exists
     */
    private static Double evaluateArgument(String argStr) throws IllegalArgumentException {
        Double resValue;
        if (argStr.contains("!")) {
            String placeInHist;
            try {
                placeInHist = argStr.substring(1);
            } catch (StringIndexOutOfBoundsException e) {
                throw new IllegalArgumentException("! argument needs integer to retrieve " +
                    "a result from the history");
            }

            int histIdx = Integer.parseInt(placeInHist);
            try {
                resValue = History.getResult(histIdx).getRes();
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("The index " + Integer.toString(histIdx) +
                    " has no associated history");
            }
        } else {
            try {
                resValue = Double.parseDouble(argStr.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Can't compute: non numerical argument " + argStr);
            }
        }
        return resValue;
    }
}
