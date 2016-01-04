package cli_calc.commands;

import cli_calc.CalcResult;

/**
 * divides a list of args (integers)
 */
public class DivCmd extends Command {

    /**
     * constructs this command with it's string cmd and args
     * @param args the list of integers to divide successively
     */
    public DivCmd(String args) {
        super("div", args);
    }

    /**
     * @return a <tt>CalcResult</tt> representing this division
     * @throws IllegalArgumentException if the args are invalid for division
     */
    @Override
    public CalcResult calculate() throws IllegalArgumentException {
        // TODO
        return null;
    }
}
