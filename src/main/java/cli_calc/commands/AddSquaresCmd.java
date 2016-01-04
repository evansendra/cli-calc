package cli_calc.commands;

import cli_calc.CalcResult;

/**
 * adds the squares of a list of args (integers)
 */
public class AddSquaresCmd extends Command {

    /**
     * constructs this command with it's string cmd and args
     * @param args the list of integers whose squares to add together
     */
    public AddSquaresCmd(String args) {
        super("addsquares", args);
    }

    /**
     * @return a <tt>CalcResult</tt> representing this addition of squares
     * @throws IllegalArgumentException if the args are invalid for addition of squares
     */
    @Override
    public CalcResult calculate() throws IllegalArgumentException {
        // TODO
        return null;
    }
}
