package test.cli_calc.commands;

import cli_calc.CalcResult;
import cli_calc.commands.AddSquaresCmd;
import cli_calc.commands.AddSquaresCmd;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;

/**
 * test the add command which adds a list of integers passed to it
 */
public class AddSquaresTest {

    private static int SQUARE_POW = 2;

    @Test(expected = IllegalArgumentException.class)
    public void testAddSquaresZero() throws Exception {
        AddSquaresCmd a = new AddSquaresCmd(new ArrayList<>());
        CalcResult r = a.calculate();
        assertEquals(0, r.getRes(), .0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddSquaresOne() throws Exception {
        List<Double> in = new ArrayList<>();
        in.add(1.0);
        AddSquaresCmd a = new AddSquaresCmd(in);
        assertEquals(1, a.calculate().getRes(), .0001);
    }

    @Test
    public void testAddSquaresTwoArgs() throws Exception {
        List<Double> in = new ArrayList<>();
        double first = 54.0;
        double second = 62.3;

        in.add(first);
        in.add(second);
        AddSquaresCmd a = new AddSquaresCmd(in);
        CalcResult r = a.calculate();
        double sqrSum = Math.pow(first, SQUARE_POW) + Math.pow(second, SQUARE_POW);
        assertEquals(sqrSum, r.getRes(), .0001);
    }

    @Test
    public void testAddSquaresNRandomArgs() throws Exception {
        List<Double> in = new ArrayList<>();
        Random r = new Random();
        long nTenToTwenty = Math.round(r.nextDouble() * (20 - 10) + 10);
        double sum = 0;
        for (long i = 0; i < nTenToTwenty; ++i) {
            double nextDoub = r.nextDouble() * 100;
            sum += Math.pow(nextDoub, SQUARE_POW);
            in.add(nextDoub);
        }

        AddSquaresCmd a = new AddSquaresCmd(in);

        assertEquals(sum, a.calculate().getRes(), .0001);
    }
}