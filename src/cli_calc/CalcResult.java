package cli_calc;

import cli_calc.commands.ClearHistCmd;
import cli_calc.commands.Command;
import cli_calc.commands.HistCmd;

/**
 * an abstraction of a resulted computation from the calculator
 * which contains the command and the result of the command
 */
public class CalcResult {
    private Command cmd; // the command which produced this result
    private Double res; // the  result of computation

    /**
     * @param cmd the command issued to the calculator
     * @param res the result of the computation
     */
    public CalcResult(Command cmd, double res) {
        this.cmd = cmd;
        this.res = res;
    }

    /**
     * @return the command which produced this result
     */
    public Command getCmd() {
        return cmd;
    }

    /**
     * @return the result of this computation
     */
    public Double getRes() {
        return res;
    }
    
    /**
     * @return the command, arguments, and resulting computation
     */
    @Override
    public String toString(){
        String args = "";
        for (Double d : cmd.getArgs()) {
            args += d + " ";
        }
        return cmd.getCmd() + " " + args + " = " + res;
    }
}
