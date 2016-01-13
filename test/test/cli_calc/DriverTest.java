package test.cli_calc;

import cli_calc.History;
import cli_calc.driver.Driver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class DriverTest {
    @Before
    public void setUp() {
        History.clearHistory();
    }

    @After
    public void after() {
        History.clearHistory();
    }

    @Test
    public void testMain() throws Exception {
        String commands = "add 1 2 3" + System.lineSeparator() +
            "hist" + System.lineSeparator() +
            "div 6 !0" + System.lineSeparator() +
            "q" + System.lineSeparator();
        String expectOutput = "6.0" + System.lineSeparator() +
            "add 1.0 2.0 3.0 = 6.0" + System.lineSeparator() +
            "1.0" + System.lineSeparator();

        ByteArrayInputStream sysin = new ByteArrayInputStream(
            commands.getBytes("UTF8"));
        ByteArrayOutputStream sysout = new ByteArrayOutputStream();
        ByteArrayOutputStream syserr = new ByteArrayOutputStream();

        System.setOut(new PrintStream(sysout, true, "UTF8"));
        System.setErr(new PrintStream(syserr, true, "UTF8"));

        System.setIn(sysin);
        Driver.main(new String[]{"test"});

        assertEquals(expectOutput, sysout.toString());
        assertEquals("", syserr.toString());

        System.setIn(System.in);
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void testIsTestRun() throws Exception {
        assertEquals(false, Driver.isTestRun(new String[]{"foo", "bar"}));
        assertEquals(true, Driver.isTestRun(new String[]{"test", "bar"}));
        assertEquals(true, Driver.isTestRun(new String[]{"test"}));
    }
}