Feature: Maps.me Splash activity opens
  Check that maps.me splash activity works

  Scenario: Check privacy policy opens after splash activity
    Given Splash activity
    When Tap by agree with privacy policy and terms of use
    Then Opens access for storage and location


#    When I type search "<criteria>" to the search field
#    Then I should see search "<result>"
#    Examples:
#      | criteria    |result |
#      | hello world |hello world text|