package test.cli_calc;

import cli_calc.CalcResult;
import cli_calc.History;
import cli_calc.commands.AddCmd;
import cli_calc.commands.Command;
import cli_calc.commands.DivCmd;
import cli_calc.commands.SubCmd;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HistoryTest {



    // will hold some numbers we can play with in commands
    private static List<Double> TEST_NUMBERS =
        new ArrayList<>();

    // pre computed sum of test nums 10 .. 0
    private static Double SUM_TEST_NUMS = 55.0;


    @BeforeClass
    public static void setUpTestNumbers() {
        int limit = 10;
        for (int i = limit; i >= 1; --i) {
            TEST_NUMBERS.add((double)(i)); // 10 9 8 7 ... 0
        }
        History.clearHistory();
    }

    @After
    public void clearHist() {
        History.clearHistory();
    }

    @Test
    public void testClearHistorySingleton() throws Exception {
        // test this here, because otherwise this will cause other tests to fail
        int oldHistSize = History.getFullHist().size();
        History.clearHistory();
        if (oldHistSize != 0) {
            assertNotEquals(oldHistSize, History.getFullHist().size());
        }
    }

    @Test
    public void testGetFullEmptyHistory() throws Exception {
        assertTrue(History.getFullHist().isEmpty());
    }

    @Test
    public void testAddToHistory() throws Exception {
        Command a = new AddCmd(TEST_NUMBERS);
        for (int i = 1; i <= 10; ++i) {
            History.addToHistory(a.calculate());
            assertEquals(i, History.getFullHist().size());
        }
    }

    @Test
    public void testGetFullHist() throws Exception {
        Command a = new AddCmd(TEST_NUMBERS);
        Command s = new SubCmd(TEST_NUMBERS);
        Command d = new DivCmd(TEST_NUMBERS);

        CalcResult r1 = a.calculate();
        History.addToHistory(r1);
        assertEquals(1, History.getFullHist().size());
        assertEquals(r1.toString(), History.getFullHist().get(0).toString());

        CalcResult r2 = s.calculate();
        History.addToHistory(r2);
        assertEquals(2, History.getFullHist().size());
        assertEquals(r2.toString(), History.getFullHist().get(1).toString());

        CalcResult r3 = d.calculate();
        History.addToHistory(r3);
        assertEquals(3, History.getFullHist().size());
        assertEquals(r3.toString(), History.getFullHist().get(2).toString());
    }

    @Test
    public void testGetResult() throws Exception {
        List<Double> sumAtI = new ArrayList<>();
        for (int i = 0; i < 10; ++i) {
            ArrayList<Double> arr = new ArrayList<>();
            arr.add(0.0);
            arr.add((double)i);
            sumAtI.add((double)i);

            Command a = new AddCmd(arr);
            History.addToHistory(a.calculate());
        }

        for (int i = 0; i < 10; ++i) {
            assertEquals(sumAtI.get(i), History.getResult(i).getRes(), .0001);
        }
    }
}