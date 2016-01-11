package test.cli_calc.commands;

import cli_calc.CalcResult;
import cli_calc.commands.SubCmd;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * test the add command which adds a list of integers passed to it
 */
public class SubCmdTest {

    @Test(expected = IllegalArgumentException.class)
    public void testSubZero() throws Exception {
        SubCmd a = new SubCmd(new ArrayList<>());
        CalcResult r = a.calculate();
        assertEquals(0, r.getRes(), .0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubOne() throws Exception {
        List<Double> in = new ArrayList<>();
        in.add(1.0);
        SubCmd a = new SubCmd(in);
        assertEquals(1, a.calculate().getRes(), .0001);
    }

    @Test
    public void testSubTwoArgs() throws Exception {
        List<Double> in = new ArrayList<>();
        double first = 54.0;
        double second = 62.3;
        in.add(54.0);
        in.add(62.3);
        SubCmd a = new SubCmd(in);
        CalcResult r = a.calculate();
        assertEquals(first - second, r.getRes(), .0001);
    }

    @Test
    public void testSubNRandomArgs() throws Exception {
        List<Double> in = new ArrayList<>();
        Random r = new Random();
        long nTenToTwenty = Math.round(r.nextDouble() * (20 - 10) + 10);
        double diff = r.nextDouble() * 100;
        in.add(diff);

        for (long i = 0; i < nTenToTwenty; ++i) {
            double nextDoub = r.nextDouble() * 100;
            diff -= nextDoub;
            in.add(nextDoub);
        }

        SubCmd a = new SubCmd(in);

        assertEquals(diff, a.calculate().getRes(), .0001);
    }
}