package cli_calc.commands;

import cli_calc.CalcResult;
import java.util.List;
/**
 * subtracts a list of args (integers)
 */
public class SubCmd extends Command {

    /**
     * constructs this command with it's string cmd and args
     * @param args the list of integers to subtract successively
     */
    public SubCmd(List<Double> args) {
        super("sub", args);
    }

    /**
     * @return a <tt>CalcResult</tt> representing this difference
     * @throws IllegalArgumentException if the args are invalid for subtraction
     */
    @Override
    public CalcResult calculate() throws IllegalArgumentException {
        double res = this.getArgs().get(0);
        for(int i = 1; i < this.getArgs().size(); i++){
        	res -= this.getArgs().get(i);
        }
        return new CalcResult(this,res);
    }   
}
