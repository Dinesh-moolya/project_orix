@test
Feature: Login Functionality


  Scenario Outline:  Verify user is able to Login up with a valid phone number
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<Mobile_Number>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<User_Name>"

    Examples:
      | Mobile_Number | otp    | User_Name |
      | 9999999999    | 123123 | Anil      |


  Scenario Outline: Verify the user is able to select the desired city under Daily Rentals Section
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<Mobile_Number>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<User_Name>"
    And User clicks on location button and selects "<city>" under popular city section

    Examples:
      | Mobile_Number | otp    | User_Name | city      |
      | 9999999999    | 123123 | Anil      | Bengaluru |


  Scenario Outline:  Verify Home page urls
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<Mobile_Number>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<User_Name>"
    Then User click on FAQS link and verify the page
    And User click on ContactUs link and verify the page
    And User click on AboutUs and verify the page
    And User click on fleet and verify the page
    And User click on deals and verify the page


    Examples:
      | Mobile_Number | otp    | User_Name |
      | 9999999999    | 123123 | Anil      |