Feature: wishList functionality


  Background: login with true credentials
    Given user on homepage
    When  user login with username "deneme@deneme.com" and password "deneme"
    Then  login should be successfull

    Scenario: wishList TC 1
      Given user search for "imac"
      When user add "iMac" to the WishList
      Then success notification with "wish list!" should be visible

