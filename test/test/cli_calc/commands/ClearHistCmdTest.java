/**
 * @author baumgartd
 * @date 1/1132016
 * This class tests the ClearHistCmd class.
 */

package test.cli_calc.commands;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import cli_calc.History;
import cli_calc.commands.AddCmd;
import cli_calc.commands.ClearHistCmd;
import cli_calc.commands.Command;

public class ClearHistCmdTest {
	Command clr;
	boolean expected;
	@Before
	public void setup(){
		System.out.println("Setting up..................");
		List<Double>list = new ArrayList<Double>();
		for(double i = 0; i < 4; i++){
			list.add(i);
		}
		for(int i = 0; i < 4; i++){
			History.addToHistory(new AddCmd(list).calculate());
		}
		clr = new ClearHistCmd();
	}
	
	@Test
	public void testClear(){
		expected = true;
		clr.calculate();
		assertEquals(expected, History.getFullHist().isEmpty());
	}
	
	@Test
	public void testClear2(){
		expected = true;
		clr.calculate();
		History.addToHistory(null);
		assertEquals(expected,History.getFullHist().isEmpty());
	}
	
	@Test
	public void testClear3(){
		expected = false;
		clr.calculate();
		List<Double>list = new ArrayList<Double>();
		list.add(1.0);
		list.add(2.0);
		History.addToHistory(new AddCmd(list).calculate());
		assertEquals(expected,History.getFullHist().isEmpty());
	}

}
