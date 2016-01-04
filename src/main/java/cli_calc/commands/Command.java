package cli_calc.commands;

import cli_calc.CalcResult;

/**
 * a command the for which calculator knows how to calculate result
 */
public abstract class Command {

    private String cmd; // the string command which invokes this <tt>Command</tt>
    private String args; // the args to be applied to this computation, may be null

    /**
     * @param cmd the command to be input on the command line to invoke this command
     * @param args (optional) the args to be applied to this command
     */
    public Command(String cmd, String args) {
        this.cmd = cmd;
        this.args = args;
    }

    /**
     * calculates the result of this calculation on these args
     * @return a <tt>CalcResult</tt> which represents this calculation
     * @throws IllegalArgumentException if the arguments applied to this command were illegal
     */
    public abstract CalcResult calculate() throws IllegalArgumentException;

    /**
     * @return the string command which invokes the instance
     */
    public String getCmd() {
        return cmd;
    }
}
