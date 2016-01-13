/**
 * @author baumgartd
 * @date 1/1132016
 * This class is used add a list of numbers together.
 */

package cli_calc.commands;

import cli_calc.CalcResult;

import java.util.List;

/**
 * adds a list of args (integers)
 */
public class AddCmd extends Command {

	/**
	 * constructs this command with it's string cmd and args
	 * 
	 * @param args
	 *            the list of integers to add together
	 */
	public AddCmd(List<Double> args) {
		super("add", args);
		if (this.getArgs().size() <= 1)
			throw new IllegalArgumentException("Too few arguments to perform computation.");
	}

	/**
	 * @return a <tt>CalcResult</tt> representing this addition
	 * @throws IllegalArgumentException
	 *             if the args are invalid for addition
	 */
	@Override
	public CalcResult calculate() throws IllegalArgumentException {
		double res = 0.0;
		for (Double d : this.getArgs()) {
			res += d;
		}
		return new CalcResult(this, res);
	}
}
