@test
Feature: MyProfile Functionality


  Scenario Outline: Verify the cancelled trip in Booking > MyProfile
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    Then User goes to my profile page and click Booking button
    And User clicked on cancel status
    Then User verifies the cancelled list

    Examples:
      | mobileNumber | otp    | userName |
      | 9999999999    | 123123 | Anil      |


  Scenario Outline: Verify the completed trip in Booking > MyProfile
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    Then User goes to my profile page and click Booking button
    And User clicked on completed status
    Then User verifies the completed list

    Examples:
      | mobileNumber | otp    | userName |
      | 9999999999    | 123123 | Anil      |


  Scenario Outline: Verify Update my profile
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    Then User lands in My Profile
    Then User edits and save the profiles
    Then User verify the update successfully message

    Examples:
      | mobileNumber | otp    | userName |
      | 9999999999    | 123123 | Anil      |


  Scenario Outline: Verify the Documents upload in MyProfile
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    Then User lands in My Profile
    Then User click on Document button
    And User uploads Pan Card
    And User upload and verifies Aadhaar Front and Aadhaar Back files
    And User upload and verifies Driving licence Front and Driving licence Back

    Examples:
      | mobileNumber | otp    | userName |
      | 9999999999   | 123123 | Anil     |