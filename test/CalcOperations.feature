#
# checkout.feature: Cucumber script for calculator
#

Feature: Using the calculator to do math operations

  Scenario Outline: performing math on a list of arguments
    Given I have doubles <a>, <b>, <c>
    When I perform <operation> on the args
    Then the calculation result should be <result>
    Examples:
      | a | b | c | operation | result |
      | 5.0 | 5.0 | 5.0 | add | 15.0 |
      | 7.0 | 3.0 | 1.0 | sub | 3.0  |
      | 5.0 | 4.0 | 3.0 | mul | 60.0 |
      | 5.0 | 4.0 | 3.0 | div | 0.41666 |
      | 3.0 | 4.0 | 5.0 | addsquares | 50.0 |
