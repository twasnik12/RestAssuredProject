
Feature: Application login
  
  Scenario: HomePage default login
     Given User is on landing page
    When User Login into application with username and passowrd 
    Then Home page is polpulated
    And card are displayed 

 