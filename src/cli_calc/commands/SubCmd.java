package cli_calc.commands;

import cli_calc.CalcResult;

/**
 * subtracts a list of args (integers)
 */
public class SubCmd extends Command {

    /**
     * constructs this command with it's string cmd and args
     * @param args the list of integers to subtract successively
     */
    public SubCmd(String args) {
        super("sub", args);
    }

    /**
     * @return a <tt>CalcResult</tt> representing this difference
     * @throws IllegalArgumentException if the args are invalid for subtraction
     */
    @Override
    public CalcResult calculate() throws IllegalArgumentException {
        // TODO
        return null;
    }
}
