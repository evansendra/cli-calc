package cli_calc.commands;

import cli_calc.CalcResult;
import java.util.List;
/**
 * divides a list of args (integers)
 */
public class DivCmd extends Command {

    /**
     * constructs this command with it's string cmd and args
     * @param args the list of integers to divide successively
     */
    public DivCmd(List<Double> args) {
        super("div", args);
    }

    /**
     * @return a <tt>CalcResult</tt> representing this division
     * @throws IllegalArgumentException if the args are invalid for division
     */
    @Override
    public CalcResult calculate() throws IllegalArgumentException {
        double res = this.getArgs().get(0);
        for(int i = 0; i < this.getArgs().size(); i++){
        	res /= this.getArgs().get(i);
        }
        return new CalcResult(this,res);
    }
}
