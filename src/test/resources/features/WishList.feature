Feature: wishlist functionality


  Background: login with true credentials
    Given user on homepage
    When  user clicks My Account Link
    And   user clicks Login Link
    Then  Login page should be visible

    When  user fill the login form with the following data
      | username | deneme@deneme.com |
      | password | deneme            |

    And   user clicks Login button
    Then  login should be successfull


  Scenario: wishlist TC 1
    Given user search for "imac"




"""
1. Enter any existing Product name into the Search text box field - <iMac>
2. Click on the button having search icon
3. Click on the Product displayed in the Search results
4. Click on 'Add to Wish List' option on a product that is displayed in the
  'Related Products' section of displayed 'Product Display' page (Validate ER-1)
5. Click on the 'wish list!' link in the displayed success message (Validate ER-2)


1. Success message with text - 'Success: You have added Product Name to your wish list!' should be displayed
2. Product should be successfully displayed in the 'My Wish List' page
"""