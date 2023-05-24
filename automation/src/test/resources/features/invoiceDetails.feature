#language: en

Feature: Invoice Details

  Background: User is on login page
    Given user is logged in with "demouser" and "abc123"

  Scenario: Verify invoice information
    When  the user clicks the Invoice Details link for the 1 item presented on the screen
    Then  the invoice information should be correctly presented on the page with the information identified with key "RendezvousHotel"
