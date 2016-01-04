package cli_calc;

import cli_calc.commands.Command;

/**
 * an abstraction of a resulted computation from the calculator
 * which contains the command and the result of the command
 */
public class CalcResult {
    private Command cmd; // the command which produced this result
    private String res; // the string result of computation

    /**
     * @param cmd the command issued to the calculator
     * @param res the result of the computation
     */
    public CalcResult(Command cmd, String res) {
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
    public String getRes() {
        return res;
    }
}
