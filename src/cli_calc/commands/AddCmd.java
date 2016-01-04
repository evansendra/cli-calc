package cli_calc.commands;

import cli_calc.CalcResult;

/**
 * adds a list of args (integers)
 */
public class AddCmd extends Command {

    /**
     * constructs this command with it's string cmd and args
     * @param args the list of integers to add together
     */
    public AddCmd(String args) {
        super("add", args);
    }

    /**
     * @return a <tt>CalcResult</tt> representing this addition
     * @throws IllegalArgumentException if the args are invalid for addition
     */
    @Override
    public CalcResult calculate() throws IllegalArgumentException {
        // TODO
        return null;
    }
}
