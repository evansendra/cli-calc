/**
 * @author baumgartd
 * @date 1/1132016
 * This class tests the HistCmd class.
 */

package test.cli_calc.commands;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import cli_calc.History;
import cli_calc.commands.AddCmd;
import cli_calc.commands.Command;
import cli_calc.commands.HistCmd;
import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class HistCmdTest {

    private ByteArrayOutputStream sysout;
    private ByteArrayOutputStream syserr;
    private ByteArrayInputStream sysin;
    private Command hist;
    
    @Before
    public void setUp() throws Exception {
        History.clearHistory();
    	List<Double>list = new ArrayList<Double>();
    	for(double i = 1; i < 3; i++){
			list.add(i);
		}
		
    	Command add = new AddCmd(list);
    	hist = new HistCmd();
    	
        History.addToHistory(add.calculate());


        sysout = new ByteArrayOutputStream();
        syserr = new ByteArrayOutputStream();

        System.setOut(new PrintStream(sysout, true, "UTF8"));
        System.setErr(new PrintStream(syserr, true, "UTF8"));
    }

    @After
    public void teardown() throws Exception {
        History.clearHistory();
        System.setIn(System.in);
        System.setOut(System.out);
        System.setErr(System.err);
    }

    @Test
    public void testHistCmd() throws Exception {
        sysin = new ByteArrayInputStream("exit".getBytes("UTF8"));
        System.setIn(sysin);

        HistCmd h = new HistCmd();
        h.calculate();

        String console = sysout.toString();
        String newLine = System.getProperty("line.separator");
        String expected = "add 1.0 2.0 = 3.0" + newLine;
        assertEquals(expected, console);

    }
}
