
@test
Feature: DailyRental Functionality


  Scenario Outline: Verify booking through Daily Rental for 300 Kms/Day by selecting "Doorstep" delivery and verifying the "Total Amount"
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    And User clicks on location button and selects "<city>" under popular city section
    And User selects From date and To Date along with from time "<pickupTime>" and to time "<returnTime>"
    And User click on search button
    Then User selects the car
    Then User selects the "<pickupLocation>" and enter the pickup address "<pickupAddress>"
    And User selects the "<dropLocation>" and enters the drop address "<dropAddress>"
    Then User verifies the Total charges
    Then User click on Proceed Button
    Then User verifies the "<firstname>" "<lastname>" "<gender>" and "<DOB>"
    Then User click Next button
    And User verifies the pan number "<panNumber>"
    And User edits and verifies the address "<addressType>" "<state>" "<pinCode>" "<address>"
    Then User click proceed to check out button
    Then User clicks on Agree & Proceed
    And User verifies the Choose the payment Title "<title>"
    And User Verifies the "<pickupTime>" "<returnTime>" "<city>" and car name in Daily Rentals
    Then User verifies the Total amount
    And User enter "<Card_name>" "<Card_number>" "<Exp_number>" "<Exp_year>"
    Then User click on success button
    Then User verifies "<mobileNumber>" , Payment successfully message , amount and BookingId
    Then User goes to my profile page and click Booking button
    And User click on Upcoming filter and click on View details
    Then User click on cancels the booking by click on cancel button
    And User click on logout and verifies navigate to Login page

    Examples:
      | mobileNumber | otp    | userName | city   | pickupLocation                      | pickupAddress   | dropLocation                        | dropAddress          | pickupTime | returnTime | firstname | lastname | gender | DOB        | panNumber | addressType | state     | pinCode | address  | title                 | Card_name | Card_number     | Exp_number | Exp_year |
      | 9999999999   | 123123 | Anil     | Delhi  | At my Address(Outside city Limiits) | Demo pickup Loc | At my Address(Outside city Limiits) | Demo test DropOf Loc | 5:00:PM    | 7:00:PM    | anil      | nagaraja | Male   | 08/03/1994 | BYHPA5614C | Permanent   | Karnataka | 560100  | Banglore | Choose payment method | Anil      | 371449635398431 | 12         | 26       |


  Scenario Outline: Verify booking through Daily Rental for "Unlimited" by selecting "Nearby Location" and verifying the "Total Amount" accordingly.
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    And User clicks on location button and selects "<city>" under popular city section
    And User selects From date and To Date along with from time "<pickupTime>" and to time "<returnTime>"
    And User click on search button
    Then User click on UnlimitedKms option
    Then User selects the car
    Then User selects the "<pickupLocation>" and verifies the pickup "<pickupAddress>"
    And User selects the "<dropLocation>" and verifies the drop "<dropAddress>"
    Then User verifies the Total charges
    Then User click on Proceed Button
    Then User verifies the "<firstname>" "<lastname>" "<gender>" and "<DOB>"
    Then User click Next button
    And User verifies the pan number "<panNumber>"
    And User edits and verifies the address "<addressType>" "<state>" "<pinCode>" "<address>"
    Then User click proceed to check out button
    Then User clicks on Agree & Proceed
    And User verifies the Choose the payment Title "<title>"
    And User Verifies the "<pickupTime>" "<returnTime>" "<city>" and car name in Daily Rentals
    Then User verifies the Total amount
    And User enter "<Card_name>" "<Card_number>" "<Exp_number>" "<Exp_year>"
    Then User click on success button
    Then User verifies "<mobileNumber>" , Payment successfully message , amount and BookingId
    Then User goes to my profile page and click Booking button
    And User click on Upcoming filter and click on View details
    Then User click on cancels the booking by click on cancel button
    And User click on logout and verifies navigate to Login page

    Examples:
      | mobileNumber | otp    | userName  | city   | pickupLocation | pickupAddress                      | dropLocation | dropAddress                        | pickupTime | returnTime | firstname | lastname | gender | DOB        | panNumber  | addressType | state     | pinCode | address  | title                 | Card_name | Card_number     | Exp_number | Exp_year |
      | 9999999999   | 123123 | Anil      | Delhi  | ICL           | AT MY ADDRESS (INSIDE CITY LIMITS) | ICL          | AT MY ADDRESS (INSIDE CITY LIMITS) | 10:00:AM    | 5:00:PM    | anil      | nagaraja | Male   | 08/03/1994 | BYHPA5614C | Permanent   | Karnataka | 560100  | Banglore | Choose payment method | Anil      | 371449635398431 | 12         | 26       |


  Scenario Outline: Verify booking through Daily Rental for "120Kms/PerDay" by selecting "Nearby Location" and verifying the "Total Amount" accordingly.
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    And User clicks on location button and selects "<city>" under popular city section
    And User selects From date and To Date along with from time "<pickupTime>" and to time "<returnTime>"
    And User click on search button
    Then User click on 120KmsPerDay option
    Then User selects the car
    Then User selects the "<pickupLocation>" and verifies the pickup "<pickupAddress>"
    And User selects the "<dropLocation>" and verifies the drop "<dropAddress>"
    Then User verifies the Total charges
    Then User click on Proceed Button
    Then User verifies the "<firstname>" "<lastname>" "<gender>" and "<DOB>"
    Then User click Next button
    And User verifies the pan number "<panNumber>"
    And User edits and verifies the address "<addressType>" "<state>" "<pinCode>" "<address>"
    Then User click proceed to check out button
    Then User clicks on Agree & Proceed
    And User verifies the Choose the payment Title "<title>"
    And User Verifies the "<pickupTime>" "<returnTime>" "<city>" and car name in Daily Rentals
    Then User verifies the Total amount
    And User enter "<Card_name>" "<Card_number>" "<Exp_number>" "<Exp_year>"
    Then User click on success button
    Then User verifies "<mobileNumber>" , Payment successfully message , amount and BookingId
    Then User goes to my profile page and click Booking button
    And User click on Upcoming filter and click on View details
    Then User click on cancels the booking by click on cancel button
    And User click on logout and verifies navigate to Login page

    Examples:
      | mobileNumber | otp    | userName | city   | pickupLocation | pickupAddress                      | dropLocation | dropAddress                        | pickupTime | returnTime | firstname | lastname | gender | DOB        | panNumber  | addressType | state     | pinCode | address  | title                 | Card_name | Card_number     | Exp_number | Exp_year |
      | 9999999999   | 123123 | Anil     | Delhi  | ICL           | AT MY ADDRESS (INSIDE CITY LIMITS) | ICL          | AT MY ADDRESS (INSIDE CITY LIMITS) | 10:00:AM    | 5:00:PM    | anil      | nagaraja | Male   | 08/03/1994 | BYHPA5614C | Permanent   | Karnataka | 560100  | Banglore | Choose payment method | Anil      | 371449635398431 | 12         | 26       |


  Scenario Outline: Verify booking through Daily rental bookings by applying luggage carrier and promo code,
  and verify the discount in total amount.
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    And User clicks on location button and selects "<city>" under popular city section
    And User selects From date and To Date along with from time "<pickupTime>" and to time "<returnTime>"
    And User click on search button
    Then User click on 120KmsPerDay option
    Then User selects the car
    Then User selects the "<pickupLocation>" and verifies the pickup "<pickupAddress>"
    And User selects the "<dropLocation>" and verifies the drop "<dropAddress>"
    Then User select the "<promoCode>"
    Then User click on Luggage and Trip Protection plan check box
    Then User verifies the Total charges
    Then User click on Proceed Button
    Then User verifies the "<firstname>" "<lastname>" "<gender>" and "<DOB>"
    Then User click Next button
    And User verifies the pan number "<panNumber>"
    And User edits and verifies the address "<addressType>" "<state>" "<pinCode>" "<address>"
    Then User click proceed to check out button
    Then User clicks on Agree & Proceed
    And User verifies the Choose the payment Title "<title>"
    And User Verifies the "<pickupTime>" "<returnTime>" "<city>" and car name in Daily Rentals
    Then User verifies the Total amount
    And User enter "<Card_name>" "<Card_number>" "<Exp_number>" "<Exp_year>"
    Then User click on success button
    Then User verifies "<mobileNumber>" , Payment successfully message , amount and BookingId
    Then User goes to my profile page and click Booking button
    And User click on Upcoming filter and click on View details
    Then User click on cancels the booking by click on cancel button
    And User click on logout and verifies navigate to Login page

    Examples:
      | mobileNumber | otp    | userName | city   | promoCode | pickupLocation | pickupAddress                                       | dropLocation | dropAddress                                         | pickupTime | returnTime | firstname | lastname | gender | DOB        | panNumber  | addressType | state     | pinCode | address  | title                 | Card_name | Card_number     | Exp_number | Exp_year |
      | 9999999999   | 123123 | Anil      | Delhi | DRIVE4000 | MOTI NAGAR    | Plot no. 11 A Shivaji Marg, Moti Nagar, New  Delhi. | MOTI NAGAR   | Plot no. 11 A Shivaji Marg, Moti Nagar, New  Delhi. | 10:00:AM   | 3:00:PM    | anil      | nagaraja | Male   | 08/03/1994 | BYHPA5614C | Permanent   | Karnataka | 560100  | Banglore | Choose payment method | Anil      | 371449635398431 | 12         | 26       |


  Scenario Outline: Verify booking through Daily rental bookings by using modify search
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    And User clicks on location button and selects "<city>" under popular city section
    And User selects From date and To Date along with from time "<pickupTime>" and to time "<returnTime>"
    And User click on search button
    And User enter the modifies city "<ModifiedCity>"
    And User enters the modified pickup date "<ModifiedPickUpDate>" "<ModifiedPickUpTime>" "<From_Date>" and dropof date "<ModifiedDropOfDate>" "<ModifiedDropOdTime>" "<To_Date>"
    Then User click on Modify search button
    Then User click on 120KmsPerDay option
    Then User selects the car
    Then User selects the "<pickupLocation>" and verifies the pickup "<pickupAddress>"
    And User selects the "<dropLocation>" and verifies the drop "<dropAddress>"
    Then User verifies the Total charges
    Then User click on Proceed Button
    Then User verifies the "<firstname>" "<lastname>" "<gender>" and "<DOB>"
    Then User click Next button
    And User verifies the pan number "<panNumber>"
    And User edits and verifies the address "<addressType>" "<state>" "<pinCode>" "<address>"
    Then User click proceed to check out button
    Then User clicks on Agree & Proceed
    And User verifies the Choose the payment Title "<title>"
    And User Verifies the modified "<ModifiedPickUpTime>" "<ModifiedDropOdTime>" "<ModifiedCity>" and car name
    Then User verifies the Total amount
    And User enter "<Card_name>" "<Card_number>" "<Exp_number>" "<Exp_year>"
    Then User click on success button
    Then User verifies "<mobileNumber>" , Payment successfully message , amount and BookingId
    Then User goes to my profile page and click Booking button
    And User click on Upcoming filter and click on View details
    Then User click on cancels the booking by click on cancel button
    And User click on logout and verifies navigate to Login page

    Examples:
      | mobileNumber | otp    | userName | city    | From_Date  | To_Date    | ModifiedPickUpDate | ModifiedDropOfDate | ModifiedCity | ModifiedPickUpTime | ModifiedDropOdTime | pickupLocation     | pickupAddress | dropLocation      | dropAddress | pickupTime | returnTime | firstname | lastname | gender | DOB        | panNumber  | addressType | state     | pinCode | address  | title                 | Card_name | Card_number     | Exp_number | Exp_year |
      | 9999999999    | 123123 | Anil      | Delhi | 23-08-2024 | 26-08-2024 | 26-11-2024         | 28-11-2024         | Bengaluru    | 11:30:AM           | 6:30:PM            | BENGALURU AIRPORT | AIRPORT       | BENGALURU AIRPORT | AIRPORT     | 5:00:AM    | 6:00:PM    | anil      | nagaraja | Male   | 08/03/1994 | BYHPA5614C | Permanent   | Karnataka | 560100  | Banglore | Choose payment method | Anil      | 371449635398431 | 12         | 26       |


  Scenario Outline:  Verify by Booking through the fleet section for Daily rentals.
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    Then User click on Fleet link
    And User clicks on fleet car
    And User clicks on location button and selects "<city>" under popular city section in fleets
    And User selects From date and To Date along with from time "<pickupTime>" and to time "<returnTime>"
    And User click on search button
    Then User selects the car
    Then User selects the "<pickupLocation>" and verifies the pickup "<pickupAddress>"
    And User selects the "<dropLocation>" and verifies the drop "<dropAddress>"
    Then User verifies the Total charges
    Then User click on Proceed Button
    Then User verifies the "<firstname>" "<lastname>" "<gender>" and "<DOB>"
    Then User click Next button
    And User verifies the pan number "<panNumber>"
    And User edits and verifies the address "<addressType>" "<state>" "<pinCode>" "<address>"
    Then User click proceed to check out button
    Then User clicks on Agree & Proceed
    And User verifies the Choose the payment Title "<title>"
    And User Verifies the "<pickupTime>" "<returnTime>" "<city>" and car name in Daily Rentals
    Then User verifies the Total amount
    And User enter "<Card_name>" "<Card_number>" "<Exp_number>" "<Exp_year>"
    Then User click on success button
    Then User verifies "<mobileNumber>" , Payment successfully message , amount and BookingId
    Then User goes to my profile page and click Booking button
    And User click on Upcoming filter and click on View details
    Then User click on cancels the booking by click on cancel button
    And User click on logout and verifies navigate to Login page

    Examples:
      | mobileNumber | otp    | userName | city    | pickupLocation | pickupAddress                                       | dropLocation | dropAddress                                         | pickupTime | returnTime | firstname | lastname | gender | DOB        | panNumber  | addressType | state     | pinCode | address  | title                 | Card_name | Card_number     | Exp_number | Exp_year |
      | 9999999999   | 123123 | Anil     | Delhi   | MOTI NAGAR    | Plot no. 11 A Shivaji Marg, Moti Nagar, New  Delhi. | MOTI NAGAR   | Plot no. 11 A Shivaji Marg, Moti Nagar, New  Delhi. | 5:00:PM    | 7:00:PM    | anil      | nagaraja | Male   | 08/03/1994 | BYHPA5614C | Permanent   | Karnataka | 560100  | Banglore | Choose payment method | Anil      | 371449635398431 | 12         | 26       |


  Scenario Outline:  Verify filter features in car list page through Daily Rental
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    And User clicks on location button and selects "<city>" under popular city section
    And User selects From date and To Date along with from time "<pickupTime>" and to time "<returnTime>"
    And User click on search button
    Then User clicks on "<fuelType>" fuel type
    And User clicks on "<transmissionType>" transmission type
    And User click on "<luggage>" luggage type
    And User clicks on "<Seating>" Seating capacity
    Then User verifies the filter data of "<fuelType>" "<transmissionType>" "<luggage>" "<Seating>"
    And User click on logout and verifies navigate to Login page

    Examples:
      | mobileNumber | otp    | userName  | city  | fuelType | transmissionType | luggage | Seating | pickupTime | returnTime |
      | 9999999999   | 123123 | Anil      | Delhi | diesel   | manual           | 3       | 5       | 5:30:PM    | 2:30:PM    |