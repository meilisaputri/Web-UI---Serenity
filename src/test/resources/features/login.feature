@all-login
Feature: Login

  Background:
    Given visitor open the website

  @positive-login
  Scenario Outline: Visitor login successfully
    When visitor click on user icon element
    And visitor input username "<username>"
    And visitor input password "<password>"
    And visitor click on login button
    Then visitor logged in successfully

    Examples:
      | username                 | password   |
      | cacacompany14@gmail.com  | Caca12345# |



  @negative-login
  Scenario Outline: Visitor login unsuccessfully
    When visitor click on user icon element
    And visitor input username "<username>"
    And visitor input password "<password>"
    And visitor click on login button
    Then visitor direct to homepage and should see login error message

    Examples:
      | username                 | password  | note                     |
      | cacacompany14@gmail.com  | Caca11111 | invalid email & password |
      |                          | Caca123   | without email            |
      | caca14@mail.com          |           | without password         |