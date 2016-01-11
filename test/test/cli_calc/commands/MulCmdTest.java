package test.cli_calc.commands;

import cli_calc.CalcResult;
import cli_calc.commands.MulCmd;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * test the add command which adds a list of integers passed to it
 */
public class MulCmdTest {

    @Test(expected = IllegalArgumentException.class)
    public void testMulZero() throws Exception {
        MulCmd a = new MulCmd(new ArrayList<>());
        CalcResult r = a.calculate();
        assertEquals(0, r.getRes(), .0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMulOne() throws Exception {
        List<Double> in = new ArrayList<>();
        in.add(1.0);
        MulCmd a = new MulCmd(in);
        assertEquals(1, a.calculate().getRes(), .0001);
    }

    @Test
    public void testMulTwoArgs() throws Exception {
        List<Double> in = new ArrayList<>();
        double first = 54.0;
        double second = 62.3;
        in.add(first);
        in.add(second);
        MulCmd a = new MulCmd(in);
        System.out.println(in);
        CalcResult r = a.calculate();
        assertEquals(first * second, r.getRes(), .0001);
    }

    @Test
    public void testMulNRandomArgs() throws Exception {
        List<Double> in = new ArrayList<>();
        Random r = new Random();
        long nTenToTwenty = Math.round(r.nextDouble() * (20 - 10) + 10);
        double prod = 1;
        for (long i = 0; i < nTenToTwenty; ++i) {
            double nextDoub = r.nextDouble() * 100;
            prod *= nextDoub;
            in.add(nextDoub);
        }

        MulCmd a = new MulCmd(in);

        assertEquals(prod, a.calculate().getRes(), .0001);
    }
}