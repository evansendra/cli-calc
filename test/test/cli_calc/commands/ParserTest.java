package test.cli_calc.commands;

import org.junit.Test;

import cli_calc.Parser;
import static org.junit.Assert.*;

public class ParserTest {

	/*******************************Test Suite******************************************************/
	@Test
	public void testParseInput(){
		Parser parser = new Parser();
		String validInput = "add 1 2 3";
		String output = parser.parseInput(validInput);
		assertEquals(validInput,output);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParseInput2() throws Exception{
		Parser parser = new Parser();
		String invalidInput = "1 + 2 + 3";
		parser.parseInput(invalidInput);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParseInput3() throws Exception{
		Parser parser = new Parser();
		String invalidInput = "add one two three";
		parser.parseInput(invalidInput);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParseInput4() throws Exception{
		Parser parser = new Parser();
		String invalidInput = "add one 2 three";
		parser.parseInput(invalidInput);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParseInput5() throws Exception{
		Parser parser = new Parser();
		String invalidInput = "add one + two";
		parser.parseInput(invalidInput);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParseInput6() throws Exception{
		Parser parser = new Parser();
		String invalidInput = "add ";
		parser.parseInput(invalidInput);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testParseInput7() throws Exception{
		Parser parser = new Parser();
		String invalidInput = "add";
		parser.parseInput(invalidInput);
	}
	
	@Test
	public void testParseInput8(){
		Parser parser = new Parser();
		String validInput = "sub 1 2 3";
		String output = parser.parseInput(validInput);
		assertEquals(validInput,output);
	}
	@Test
	public void testParseInput9(){
		Parser parser = new Parser();
		String validInput = "mul 1 2 3";
		String output = parser.parseInput(validInput);
		assertEquals(validInput,output);
	}
	
	@Test
	public void testParseInput10(){
		Parser parser = new Parser();
		String validInput = "div 1 2 3";
		String output = parser.parseInput(validInput);
		assertEquals(validInput,output);
	}
}
