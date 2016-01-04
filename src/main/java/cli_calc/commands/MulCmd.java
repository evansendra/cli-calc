package cli_calc.commands;

import cli_calc.CalcResult;

/**
 * multiplies a list of args (integers)
 */
public class MulCmd extends Command {

    /**
     * constructs this command with it's string cmd and args
     * @param args the list of integers to multiply together
     */
    public MulCmd(String args) {
        super("mul", args);
    }

    /**
     * @return a <tt>CalcResult</tt> representing this multiplication
     * @throws IllegalArgumentException if the args are invalid for multiplication
     */
    @Override
    public CalcResult calculate() throws IllegalArgumentException {
        // TODO
        return null;
    }
}
