@test
Feature: MonthlyRental Functionality

  Scenario Outline:  Verify Monthly Subscription bookings
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    And User clicks in Monthly Subscription
    And User clicks on location button and selects "<city>" under popular city section in Monthly Subcription
    And User select from date "<fromDate>"and time "<pickupTime>"
    And User click on Monthly Subscription search button
    Then User selects the car in Monthly Subscription
    Then User selects the "<pickupLocation>" and verifies the pickup "<pickupAddress>"
    And User selects the "<dropLocation>" and verifies the drop "<dropAddress>"
    Then User verifies the Total charges for Monthly Subscription
    Then User click on Proceed Button
    Then User verifies the "<firstname>" "<lastname>" "<gender>" and "<DOB>"
    Then User click Next button
    And User verifies the pan number "<panNumber>"
    And User edits and verifies the address "<addressType>" "<state>" "<pinCode>" "<address>"
    Then User click proceed to check out button
    Then User clicks on Agree & Proceed
    And User verifies the Choose the payment Title "<title>"
    And User Verifies the details "<pickupTime>" and "<city>"
    Then User verifies the Total amount
    And User choose the NetBanking option
    And User verifies payment method and bankName "<paymentMethod>" "<bankName>"
    Then User click on success button
    Then User verifies "<mobileNumber>" , Payment successfully message , amount and BookingId
    Then User goes to my profile page and click Booking button
    And User click on Upcoming filter and click on View details
    Then User click on cancels the booking by click on cancel button

    Examples:
      | mobileNumber | otp    | userName | city    | pickupLocation | pickupAddress                                       | dropLocation | dropAddress                                         | pickupTime | returnTime | firstname | lastname | gender | DOB        | panNumber  | addressType | state       | pinCode | address  | title                 |bankName|paymentMethod|
      | 9999999999    | 123123 | Anil      | Delhi | MOTI NAGAR    | Plot no. 11 A Shivaji Marg, Moti Nagar, New  Delhi. | MOTI NAGAR   | Plot no. 11 A Shivaji Marg, Moti Nagar, New  Delhi. | 11:00:AM    | 11:00:AM    | anil      | nagaraja | Male   | 08/03/1994 | BYHPA5614C | Permanent   | Karnataka | 560100  | Banglore | Choose payment method  |HDFC     | Netbanking  |


  Scenario Outline:  Verify by Booking through the fleet section for monthly rentals.
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    Then User click on Fleet link
    And User clicks on fleet car
    And User clicks in Monthly Subscription
    And User clicks on location button and selects "<city>" under popular city section in Monthly Subcription
    And User select from date "<fromDate>"and time "<pickupTime>" for fleets
    And User click on Monthly Subscription search button
    Then User selects the car in Monthly Subscription
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
    And User Verifies the details "<pickupTime>" and "<city>"
    Then User verifies the Total amount
    And User choose the NetBanking option
    And User verifies payment method and bankName "<paymentMethod>" "<bankName>"
    Then User click on success button
    Then User verifies "<mobileNumber>" , Payment successfully message , amount and BookingId
    Then User goes to my profile page and click Booking button
    And User click on Upcoming filter and click on View details
    Then User click on cancels the booking by click on cancel button

    Examples:
      | mobileNumber | otp    | userName | city  | pickupLocation | pickupAddress                                       | dropLocation | dropAddress                                         | pickupTime | returntime | firstname | lastname | gender | DOB          | panNumber  | addressType | state     | pinCode | address  | title              |bankName|paymentMethod|
      | 9999999999    | 123123 | Anil      | Bengaluru | At my Address(Outside city Limiits)_monthly    | Demo pickup Loc | At my Address(Outside city Limiits)_monthly  | Demo pickup Loc | 11:00:AM    | 7:00:PM    | anil      | nagaraja | Male   | 08/03/1994 | BYHPA5614C | Permanent   | Karnataka | 560100  | Banglore | Choose payment method | HDFC     | Netbanking |


  Scenario Outline: Verify booking through Monthly Rental  by selecting "Nearby Location" and verifying the "Total Amount" accordingly.
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    And User clicks in Monthly Subscription
    And User clicks on location button and selects "<city>" under popular city section in Monthly Subcription
    And User select from date "<fromDate>"and time "<pickupTime>"
    And User click on Monthly Subscription search button
    Then User selects the car in Monthly Subscription
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
    And User Verifies the details "<pickupTime>" and "<city>"
    Then User verifies the Total amount
    And User choose the NetBanking option
    And User verifies payment method and bankName "<paymentMethod>" "<bankName>"
    Then User click on success button
    Then User verifies "<mobileNumber>" , Payment successfully message , amount and BookingId
    Then User goes to my profile page and click Booking button
    And User click on Upcoming filter and click on View details
    Then User click on cancels the booking by click on cancel button


    Examples:
      | mobileNumber | otp    | userName | city  | pickupLocation | pickupAddress                      | dropLocation | dropAddress                        | pickupTime | returntime | firstname | lastname | gender | DOB        | panNumber  | addressType | state     | pinCode | address  | title                 | bankName|paymentMethod|
      | 9999999999    | 123123 | Anil      | Delhi | ICL           | AT MY ADDRESS (INSIDE CITY LIMITS) | ICL          | AT MY ADDRESS (INSIDE CITY LIMITS) | 11:00:AM    | 6:00:PM    | anil      | nagaraja | Male   | 08/03/1994 | BYHPA5614C | Permanent   | Karnataka | 560100  | Banglore | Choose payment method | HDFC     | Netbanking  |


  Scenario Outline: Verify booking through Monthly Rental by selecting promo code, Luggage carrier and trip protection plan and verifying the "Total Amount" accordingly.
    Given User enters the url and lands in the Home page
    When User click on Login or Signup button
    Then User click on LoginHere button
    Then User enters the Mobile number "<mobileNumber>" and click login button
    Then User enters the Otp "<otp>" and click on validate button
    Then User validates the user name "<userName>"
    And User clicks in Monthly Subscription
    And User clicks on location button and selects "<city>" under popular city section in Monthly Subcription
    And User select from date "<fromDate>"and time "<pickupTime>"
    And User click on Monthly Subscription search button
    Then User selects the car in Monthly Subscription
    Then User selects the "<pickupLocation>" and verifies the pickup "<pickupAddress>"
    And User selects the "<dropLocation>" and verifies the drop "<dropAddress>"
    Then User select the "<promocode>"
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
    And User Verifies the details "<pickupTime>" and "<city>"
    Then User verifies the Total amount
    And User choose the NetBanking option
    And User verifies payment method and bankName "<paymentMethod>" "<bankName>"
    Then User click on success button
    Then User verifies "<mobileNumber>" , Payment successfully message , amount and BookingId
    Then User goes to my profile page and click Booking button
    And User click on Upcoming filter and click on View details
    Then User click on cancels the booking by click on cancel button


    Examples:
      | mobileNumber | otp     | userName | city    | promocode | pickupLocation | pickupAddress                      | dropLocation | dropAddress                        | pickupTime | returntime | firstname | lastname | gender | DOB        | panNumber  | addressType | state     | pinCode | address  | title                 | bankName|paymentMethod|
      | 9999999999    | 123123 | Anil      | Delhi  | DRIVE2000 | ICL           | AT MY ADDRESS (INSIDE CITY LIMITS) | ICL          | AT MY ADDRESS (INSIDE CITY LIMITS) | 10:00:AM    | 6:00:PM    | anil      | nagaraja | Male   | 08/03/1994 | BYHPA5614C | Permanent   | Karnataka | 560100  | Banglore | Choose payment method |HDFC     | Netbanking  |