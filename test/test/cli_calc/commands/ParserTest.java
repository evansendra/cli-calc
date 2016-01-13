/**
 * @author baumgartd
 * @date 1/1132016
 * This class tests the Parser class functionality.
 */

package test.cli_calc.commands;

import cli_calc.commands.*;

import org.junit.Test;

import java.util.List;
import java.util.ArrayList;

import cli_calc.History;
import cli_calc.Parser;
import static org.junit.Assert.*;

public class ParserTest {

	/*******************************Test Suite******************************************************/
	@Test
	public void testparseInputToAddCommand(){
		String validInput = "add 1 2 3";
		Command cmd = Parser.parseInputToCommand(validInput);
		assertEquals(AddCmd.class, cmd.getClass());
	}

	@Test
	public void testparseInputToAddSquaresCommand(){
		String validInput = "addsquares 1 2 3";
		Command cmd = Parser.parseInputToCommand(validInput);
		assertEquals(AddSquaresCmd.class, cmd.getClass());
	}

	@Test
	public void testparseInputToClearHistCommand(){
		String validInput = "clearhist";
		Command cmd = Parser.parseInputToCommand(validInput);
		assertEquals(ClearHistCmd.class, cmd.getClass());
	}

	@Test
	public void testparseInputToDivCommand(){
		String validInput = "div 1 2 3";
		Command cmd = Parser.parseInputToCommand(validInput);
		assertEquals(DivCmd.class, cmd.getClass());
	}

	@Test
	public void testparseInputToHistCommand(){
		String validInput = "hist";
		Command cmd = Parser.parseInputToCommand(validInput);
		assertEquals(HistCmd.class, cmd.getClass());
	}

	@Test
	public void testparseInputToMulCommand(){
		String validInput = "mul 1 2 3";
		Command cmd = Parser.parseInputToCommand(validInput);
		assertEquals(MulCmd.class, cmd.getClass());
	}

	@Test
	public void testparseInputToSubCommand(){
		String validInput = "sub 1 2 3";
		Command cmd = Parser.parseInputToCommand(validInput);
		assertEquals(SubCmd.class, cmd.getClass());
	}



	@Test(expected = IllegalArgumentException.class)
	public void testparseInputToCommand2() throws Exception{
		String invalidInput = "1 + 2 + 3";
		Parser.parseInputToCommand(invalidInput);
		fail();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testparseInputToCommand3() throws Exception{
		String invalidInput = "add one two three";
		Parser.parseInputToCommand(invalidInput);
		fail();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testparseInputToCommand4() throws Exception{
		String invalidInput = "add one 2 three";
		Parser.parseInputToCommand(invalidInput);
		fail();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testparseInputToCommand5() throws Exception{
		String invalidInput = "add one + two";
		Parser.parseInputToCommand(invalidInput);
		fail();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testparseInputToCommand6() throws Exception{
		String invalidInput = "add ";
		Parser.parseInputToCommand(invalidInput);
		fail();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testparseInputToCommand7() throws Exception{
		String invalidInput = "add";
		Parser.parseInputToCommand(invalidInput);
		fail();
	}

	@Test
	public void testparseInputToCommand8(){
		String validInput = "sub 1 2 3";
		Command output = Parser.parseInputToCommand(validInput);
		assertEquals(SubCmd.class,output.getClass());
	}

	@Test
	public void testparseInputToCommand9(){
		String validInput = "mul 1 2 3 4";
		Command output = Parser.parseInputToCommand(validInput);
		assertEquals(MulCmd.class,output.getClass());
	}

	@Test
	public void testparseInputToCommand10(){
		String validInput = "div 1 2 3";
		Command output = Parser.parseInputToCommand(validInput);
		assertEquals(DivCmd.class,output.getClass());
	}

	@Test
	public void testparseInputToCommand11(){
		History.clearHistory();
		String validInput = "add 1 !1";
		/*
		 * we expect there to be an error because the history logging is done by
		 * the driver and therefore the parser will have no way of knowing if a
		 * historic value was computed on its own
		 */
		try {
			Command output = Parser.parseInputToCommand(validInput);
			fail();
		} catch (IllegalArgumentException e) {
			assertEquals("The index 1 has no associated history", e.getMessage());
		}
	}

	@Test(expected = IllegalArgumentException.class)
	public void testparseInputToCommand12(){
		String invalidInput = "add ! ! !";
		Parser.parseInputToCommand(invalidInput);
		fail();
	}
	
	@Test
	public void testParseInputToCommand13(){
		List<Double>list = new ArrayList<Double>();
		list.add(1.0);
		list.add(2.0);
		String vaildInput = "add 1 !0 2 3";
		History.addToHistory(new AddCmd(list).calculate());
		Command output = Parser.parseInputToCommand(vaildInput);
		assertEquals(AddCmd.class, output.getClass());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParseInputCommand14(){
		String invalidInput = "!2 1 2 3";
		Parser.parseInputToCommand(invalidInput);
		fail();
	}
}
