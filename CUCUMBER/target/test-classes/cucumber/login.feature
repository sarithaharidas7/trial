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
Feature:  user verification using valid credential

		Background: 
		Given  I landed on URL 
  @tag1
  Scenario Outline: User login verification using valid credentials
    
    Given I waited for the page to load completely load
    When I have entered Username <name> and password <pwd>
    And I click on  the submit button
    Then I should redirect to homepage
    And  I verify the "Logged In Successfully" message in screen

    Examples: 
      | name  	| 	pwd 				| 
      | student |  Password123  | 
