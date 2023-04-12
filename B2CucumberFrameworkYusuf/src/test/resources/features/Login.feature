Feature: Login functionality

  @LoginA
  Scenario: login with true credentials 01
    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  Login page should be visible

    When  user fill the login form with the following data
      | username | deneme@deneme.com |
      | password | deneme            |
    And   user clicks Login button
    Then  login should be successfull

  @LoginB
  Scenario: login with true credentials 02
    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  Login page should be visible

    When  user fill the login form with the following data
      | username | deneme@deneme.com |
      | password | deneme            |
    And   user clicks Login button
    And   user clicks on Browser back button
    Then  user should not logged out

  @LoginC
  Scenario: login with true credentials 03
    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  Login page should be visible

    When  user fill the login form with the following data
      | username | deneme@deneme.com |
      | password | deneme            |
    And   user clicks Login button
    And   Click on My Account Dropmenu and select Logout option
    And   user clicks on Browser back button
    Then  user should not get logged in again

