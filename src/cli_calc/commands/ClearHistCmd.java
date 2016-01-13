/**
 * @author sendrae
 */

package cli_calc.commands;

import cli_calc.CalcResult;
import cli_calc.History;

/**
 * clears the history of commands
 */
public class ClearHistCmd extends Command {

    /**
     * constructs this command with it's string cmd
     */
    public ClearHistCmd() {
        super("clearhist", null);
    }

    /**
     * @return a <tt>CalcResult</tt> representing this printing of history
     * @throws IllegalArgumentException if the args are invalid for addition
     */
    @Override
    public CalcResult calculate() throws IllegalArgumentException {
        History.clearHistory();
        return new CalcResult(this, 1);
    }
}
