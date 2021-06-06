#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Compose Mail Functionality

  @tag1
  Scenario Outline: Login and Send Email
    Given Open browser and there is a user who do gmail login
    And User login with Email Address "<EmailAddress>" and password "<password>"
    When User sends mail to "jigna210@yahoo.com" with subject "Incubyte" and body "Automation QA test for Incubyte" 
    Then Email sends successfully and email appears in send folder with subject "Incubyte"
    When Click on Log out 
    Then Successfully log out and Close the browser

    Examples: 
      | EmailAddress  | password |
      | name@gmail.com| pass@123 | 

