Feature: LoginFeature
  This feature deals with the login functionality of the application

  Scenario: Login with correct username and password
   Given I navigate to the login page
   When I pass username and password and click login
   Then login should be successful and home page is displayed
