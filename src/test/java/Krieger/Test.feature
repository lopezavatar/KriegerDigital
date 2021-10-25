Feature: Check Subscription

  Background:
    Given "Chrome" browser is opened
    And I navigate to the login page
    And Cookies are accepted

    Scenario: A confirmation message appears after inputting and submitting mail
      Given I can see a newsletter subscription input
      When I enter my email in the input field
      And I press the "Absenden" button
      Then I can see a confirmation message

