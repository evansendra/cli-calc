/**
 * @author baumgartd
 * @date 1/1132016
 * This class is used to add the squares of a list of numbers.
 */

package cli_calc.commands;

import cli_calc.CalcResult;

import java.util.List;

/**
 * adds the squares of a list of args (integers)
 */
public class AddSquaresCmd extends Command {

	/**
	 * constructs this command with it's string cmd and args
	 * 
	 * @param args
	 *            the list of integers whose squares to add together
	 */
	public AddSquaresCmd(List<Double> args) {
		super("addsquares", args);
		if (this.getArgs().size() <= 1)
			throw new IllegalArgumentException(
					"Too few arguments to perform computation.");
	}

	/**
	 * @return a <tt>CalcResult</tt> representing this addition of squares
	 * @throws IllegalArgumentException
	 *             if the args are invalid for addition of squares
	 */
	@Override
	public CalcResult calculate() throws IllegalArgumentException {
		double res = 0.0;
		for (int i = 0; i < this.getArgs().size(); i++) {
			res += (Math.pow(this.getArgs().get(i), 2));
		}
		return new CalcResult(this, res);
	}
}
