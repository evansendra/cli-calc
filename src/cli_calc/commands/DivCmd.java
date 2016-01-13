/**
 * @author baumgartd
 * @date 1/1132016
 * This class is used to divide a list of numbers.
 */

package cli_calc.commands;

import cli_calc.CalcResult;

import java.util.List;

/**
 * divides a list of args (integers)
 */
public class DivCmd extends Command {

	/**
	 * constructs this command with it's string cmd and args
	 * 
	 * @param args
	 *            the list of integers to divide successively
	 */
	public DivCmd(List<Double> args) {
		super("div", args);
		if (args.size() < 2)
			throw new IllegalArgumentException(
					"Too few arguments to perform computation.");
	}

	/**
	 * @return a <tt>CalcResult</tt> representing this division
	 * @throws IllegalArgumentException
	 *             if the args are invalid for division
	 */
	@Override
	public CalcResult calculate() throws IllegalArgumentException {
		
		double res = this.getArgs().get(0);
		for (int i = 1; i < this.getArgs().size(); i++) {
			if (this.getArgs().get(i) == 0)
				throw new IllegalArgumentException("Can't divide by zero");
			res /= this.getArgs().get(i);
		}
		return new CalcResult(this, res);
	}
}
