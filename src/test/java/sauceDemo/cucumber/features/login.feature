Feature: Login to SauceLab
  @Regression @Positive
  Scenario: Success login to SauceLab
    Given SauceLab login page
    When input valid username
    And input valid password
    And click Login button
    Then Dashboard page shown

  @Regression @Negative
  Scenario: Failed login to SauceLab - invalid username
    Given SauceLab login page
    When input invalid username
    And input valid password
    And click Login button
    Then Error message shown

  @Regression @Negative
  Scenario: Failed login to SauceLab - invalid password
    Given SauceLab login page
    When input valid username
    And input invalid password
    And click Login button
    Then Error message shown

  @Regression @Negative
  Scenario:  Failed login to SauceLab - locked out
    Given SauceLab login page
    When input locked username
    And input valid password
    And click Login button
    Then locked out message shown

  @TDD
  Scenario Outline: Login to SauceDemo
    Given SauceLab login page
    When input <username> as username
    And input <password> as password
    And click Login button
    Then verify <state> login result

    Examples:
      | username        | password      | state
      | standard_user   | secret_sauce  | success
      | abc123          | secret_sauce  | failed
      | locked_out_user | secret_sauce  | locked
