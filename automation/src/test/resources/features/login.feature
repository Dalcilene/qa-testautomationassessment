#language: en

Feature: Login

  Background: User is on login page
    Given user is in login page

  Scenario: login with valid credentials
    When user perform login with "demouser" and "abc123"
    Then user should be redirected to the Invoice List page

  Scenario Template: login with invalid credentials
    When user perform login with "<username>" and "<password>"
    Then user will see message "Wrong username or password"
    Examples:
      | username  | password |
      | Demouser  | abc123   |
      | demouser_ | xyz      |
      | demouser  | nananana |
      | demouser  | abc123   |

