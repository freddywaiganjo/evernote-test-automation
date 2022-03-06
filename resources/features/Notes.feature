@Notes @testAll
Feature: Write Notes

  @writeNote
  Scenario: Login and write a note followed by a logout
    Given i have logged in to Evernote portal with username "alexiwaiganjo@gmail.com" and  password "Password1*"
    Then i click on create new note
    Then i write a note

  @openCreatedNote
  Scenario: Login again and make sure you open the note create in step
    Given i have logged in to Evernote portal with username "alexiwaiganjo@gmail.com" and  password "Password1*"
    Then i click on open test note
    And i confirm notes are visible
   Then i should be able to logout
