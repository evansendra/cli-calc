package test.cli_calc.commands;

import cli_calc.CalcResult;
import cli_calc.commands.DivCmd;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * test the add command which adds a list of integers passed to it
 */
public class DivCmdTest {

    /*
     * shouldn't be able to divide zero arguments
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDivZero() throws Exception {
        DivCmd a = new DivCmd(new ArrayList<>());
        CalcResult r = a.calculate();
    }

    /*
     * shouldn't be able to divide one argument with nothing else provided
     */
    @Test(expected = IllegalArgumentException.class)
    public void testDivOne() throws Exception {
        List<Double> in = new ArrayList<>();
        in.add(1.0);
        DivCmd a = new DivCmd(in);
    }

    @Test
    public void testDivTwoArgs() throws Exception {
        List<Double> in = new ArrayList<>();
        double first = 54.0;
        double second = 62.3;
        in.add(first);
        in.add(second);
        DivCmd a = new DivCmd(in);
        CalcResult r = a.calculate();
        assertEquals(first / second, r.getRes(), .0001);
    }

    @Test
    public void testDivNRandomArgs() throws Exception {
        List<Double> in = new ArrayList<>();
        Random r = new Random();
        long nTenToTwenty = Math.round(r.nextDouble() * (20 - 10) + 10);

        // add the initial num to divide everything else by
        double quot = r.nextDouble() * 100 + 1;
        in.add(quot);

        for (long i = 0; i < nTenToTwenty; ++i) {
            double nextDoub = r.nextDouble() * 100 + 1;
            quot /= nextDoub;
            in.add(nextDoub);
        }

        DivCmd a = new DivCmd(in);

        assertEquals(quot, a.calculate().getRes(), .0001);
    }
}