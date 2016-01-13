/**
 * @author baumgartd
 * @date 1/1132016
 * This class is used to multiply a list of numbers.
 */

package cli_calc.commands;

import cli_calc.CalcResult;

import java.util.List;

/**
 * multiplies a list of args (integers)
 */
public class MulCmd extends Command {

	/**
	 * constructs this command with it's string cmd and args
	 * 
	 * @param args
	 *            the list of integers to multiply together
	 */
	public MulCmd(List<Double> args) {
		super("mul", args);
		if (this.getArgs().size() <= 1)
			throw new IllegalArgumentException(
					"Too few arguments to perform computation.");
	}

	/**
	 * @return a <tt>CalcResult</tt> representing this multiplication
	 * @throws IllegalArgumentException
	 *             if the args are invalid for multiplication
	 */
	@Override
	public CalcResult calculate() throws IllegalArgumentException {

		double res = this.getArgs().get(0);
		for (int i = 1; i < this.getArgs().size(); i++) {
			res *= this.getArgs().get(i);
		}
		return new CalcResult(this, res);
	}
}
