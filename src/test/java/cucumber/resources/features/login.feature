Feature: Login to SauceLab
  Scenario: Success login to SauceLab
    Given SauceLab login page
    Then input valid email
    And input valid password
    And click Login button
    Then Dashboard page shown

  Scenario: Failed login to SauceLab - invalid username
    Given SauceLab login page
    Then input invalid email
    And input valid password
    And click Login button
    Then Error message shown

  Scenario: Failed login to SauceLab - invalid password
    Given SauceLab login page
    Then input valid email
    And input invalid password
    And click Login button
    Then Error message shown
