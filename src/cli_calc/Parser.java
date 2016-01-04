package cli_calc;

/**
 * parses input from user
 */
public class Parser {
    /**
     * @param in the command from user
     * @return resulting string to be returned to user
     * @throws IllegalArgumentException if <tt>in</tt> was not understood
     */
    public String parseInput(String in) throws IllegalArgumentException {
        // TODO
        return null;
    }

    /**
     * @param res adds the calculated <tt>res</tt>ult to the history of computations
     * @return false if there was an error adding to history
     */
    private boolean addToHist(CalcResult res) {
        // TODO
        return false;
    }

    /**
     * clears the stored history of computations up to this point
     */
    private void clearHist() {
        // TODO
    }

    /**
     * gets the ith <tt>CalcResult</tt> from the history of computations
     * @param i index of result
     * @return a <tt>CalcResult</tt> at this index if it exists
     * @throws IndexOutOfBoundsException if no computation exists at the index i
     */
    private CalcResult getResultFromHist(int i) throws IndexOutOfBoundsException {
        // TODO
        return null;
    }
}
