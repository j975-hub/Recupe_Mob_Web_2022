Feature: Patient Validation
  Description: User will validate patient profile

  @TC4
  Scenario: Patient details Validation
    Given User select the User type as "Admin / PSM"
    Then  User will give the credential to sign in the application
    And   User validate Patient Information
    Then  User click on Patient bar
    And   User will edit the profile and add Recupe Coach Name
