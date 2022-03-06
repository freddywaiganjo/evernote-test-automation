@Login @testAll
Feature: Login

  @Unsuccessful
  Scenario: Unsuccessful login using email
    Given i login to Evernote portal with "alexiwaiganjo@gmail.com" a valid email
    Then i enter "WrongPassword" an invalid password
    Then  i should get invalid login credentials

  @Successful
  Scenario: Successful login using email
    Given i login to Evernote portal with "alexiwaiganjo@gmail.com" a valid email
    Then i enter "Password1*" a valid password
    Then  i should be redirected to the dashboard