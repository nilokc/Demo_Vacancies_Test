@regression
Feature: I access the Veeam Vacancy Page

  Background:
    Given I access the veeam career page
    When The URL is mapped to 'cz.careers.veeam'
    And Disable Cookie PopUp
    Then Terminate test case

  @test1
  Scenario: Validate Successful Veeam URL
    And Click on All Departments combobox and check Research & Development
    And Click on All languages combobox and check English
    And I find the open vacancies and count them
  @test2
  Scenario: Validate Number of Veeam Jobs with -Vacancies Open Data
    And Click on All Departments combobox and check Research & Development
    And Click on All languages combobox and check English
    And I count open vacancies and verify with number on carrier page
  @test3
  Scenario: Validate Number of Veeam Jobs with Random filter inputs
    And Click All Departments combobox and pick any department
    And I count open vacancies and verify with number on carrier page

