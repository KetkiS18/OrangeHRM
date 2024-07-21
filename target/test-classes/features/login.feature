
@tag
Feature: Login functionality

  @smoke
  Scenario: Valid user login
    Given User is on the login page
    When User enters valid credentials
    Then User should be redirected to Dashboard
   

  @sanity
  Scenario Outline: Invalid User Login
    Given User is on the login page
    When User enters Invalid credentials
    Then User will get Invalid Credentials message

