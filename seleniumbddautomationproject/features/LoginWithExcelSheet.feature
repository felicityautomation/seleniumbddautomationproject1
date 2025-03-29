#Author: your.email@your.domain.com
Feature: Login feature of DemoBlaze application

  @positive @sanity
  Scenario: Verify the successful Login of DemoBlaze using valid credentails
    Given User opens the browser
    When user opens the DemoBlaze application URL
    And user clicks on Login link
    And user enters user name and password from the excel 'testdata/mydata.xlsx' and sheet 'credentails'
    And user clicks on Login button
    Then the home page should be displayed with signout link
    And the browser is closed

  @negetive @sanity
  Scenario: Verify the Login of DemoBlaze using invalid credentails
    Given User opens the browser
    When user opens the DemoBlaze application URL
    And user clicks on Login link
    And user enters user name as 'bharathedu1' and password '308049'
    And user clicks on Login button
    Then Alert message should be displayed with error message
    And the browser is closed
