/**
 * @author baumgartd
 * @date 1/1132016
 * This class is used to substitute the value of a previous result into a current input argument.
 */

package cli_calc.commands;

import java.util.List;

import cli_calc.CalcResult;
import cli_calc.History;

public class SubValueCmd extends Command{

	/**
	 * The constructor for a SubValueCmd class.
	 * @param args
	 */
	public SubValueCmd(List<Double> args) {
		super("SubValueCmd", args);
	}

	/**
	 * Returns the result from history using the index passed in the list when creating the object.
	 * @return - CalcResult
	 */
	@Override
	public CalcResult calculate() throws IllegalArgumentException {
		Double d = this.getArgs().get(0);
		int index = d.intValue();
		return History.getResult(index);
	}

}
