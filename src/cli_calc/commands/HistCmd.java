/**
 * @author sendrae
 */

package cli_calc.commands;

import cli_calc.CalcResult;
import cli_calc.History;

import java.util.List;

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
        List<CalcResult> hist = History.getFullHist();
        for (CalcResult res: hist) {
            System.out.println(res.toString());
        }
        return new CalcResult(this, 1);
    }
}
