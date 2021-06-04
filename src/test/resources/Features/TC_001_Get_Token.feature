Feature: Validating Place API's

  @TokenEndpoint @Regression
  Scenario Outline: Get the Bearer token
    Given Get the token API payload with "baseURL"
    When user calls "<SRC_1>" with GET http token API request
    Then the token API call got success with status code "code200"
    And get the "apiKey" and "token"

    Examples: 
      | SRC_1       |
      | getTokenAPI |
