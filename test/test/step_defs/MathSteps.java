package test.step_defs;

import cli_calc.Parser;
import cli_calc.commands.Command;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

public class MathSteps {

    Command c;
    List<Double> args;

    @Given("^I have doubles (\\d+\\.\\d+), (\\d+\\.\\d+), (\\d+\\.\\d+)$")
    public void i_have_doubles(double a, double b, double c) throws Throwable {
        args = new ArrayList<>();
        args.add(a);
        args.add(b);
        args.add(c);
    }

    @When("^I perform (\\w+) on the args$")
    public void doSomeOperation(String operation) throws Throwable {
        String input = operation + " ";
        for(Double d: args) {
            input += Double.toString(d) + " ";
        }
        c = Parser.parseInputToCommand(input);
    }

    @Then("^the calculation result should be ([\\d\\.]+)$")
    public void theCalculationReusltShouldBeResult(double result) throws Throwable {
        assertEquals(result, c.calculate().getRes(), 0.001);
    }


}
