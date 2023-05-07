@test1
Feature: I access the Veeam Vacancy Page

  Background:
    Given I access the veeam career page
    When The URL is mapped to 'cz.careers.veeam'
    And Disable Cookie PopUp
    And Click on All Departments combobox and check Research & Development
    And Click on All languages combobox and check English


  Scenario: Validate Successful Veeam URL
    And I find the open vacancies and count them
    Then Terminate test case

  Scenario: Validate Number of Veeam Jobs with -Vacancies Open Data
    And I count open vacancies and verify with number on carrier page
    Then Terminate test case