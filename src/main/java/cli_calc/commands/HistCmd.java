package cli_calc.commands;

import cli_calc.CalcResult;

/**
 * shows the history of commands
 */
public class HistCmd extends Command {

    /**
     * constructs this command with it's string cmd
     */
    public HistCmd() {
        super("hist", null);
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
