#Author: your.email@your.domain.com
Feature: Login feature of DemoBlaze application

  Scenario: Verify the successful Login of DemoBlaze using valid credentails
    Given User opens the browser
    When user opens the DemoBlaze application URL
    And user clicks on Login link
    And user enters user name as 'bharathedu1' and password '123456'
    And user clicks on Login button
    Then the home page should be displayed with signout link
    And the browser is closed

    Scenario Outline:: Verify the successful Login of DemoBlaze using valid credentails
    Given User opens the browser
    When user opens the DemoBlaze application URL
    And user clicks on Login link
    And user enters user name as '<username>' and password '<password>'
    And user clicks on Login button
    Then the home page should be displayed with signout link
    And the browser is closed
    
    Examples: 
      | username    | password |
      | bharathedu1 |   123456 |
      | bharathedu2 | welcome1 |
      | bharathedu2 | welcome2 |