Feature: Validating Account APIs

  @AccountEndpoint @Regression
  Scenario Outline: Verify if account is being succesfully added using accountAPIs
    Given Get the create account payload with "baseURL_CRM" and "<ColumnName>" and "<TestCase>" and "<SheetName>"
    When user calls "accountAPI" with PUT http account API request
    Then account API call got success with status code "code200"
    And get the "aosAccountId" from the "<TestCase>" account API response body

    Examples: 
      | ColumnName | TestCase   | SheetName |
      | type       | Advertiser | Account   |
      | type       | Agency     | Account   |
      | type       | Brand      | Account   |

  @AccountEndpoint @Regression
  Scenario Outline: Verify if account is being succesfully updated using accountAPIs
    Given Get the update account payload with "baseURL_CRM" and "<ColumnName>" and "<TestCase>"
    When user calls "accountAPI" with PUT http account API request
    Then account API call got success with status code "code200"
    And get the "aosAccountId" from the "<TestCase>" account API response body

    Examples: 
      | ColumnName | TestCase   |
      | type       | Advertiser |
      | type       | Agency     |
      | type       | Brand      |

  @AccountEndpoint @Regression
  Scenario Outline: Verify if account is being succesfully deleted using accountAPIs
    Given Get the delete account payload with "baseURL_CRM" and "<ColumnName>" and "<TestCase>"
    When user calls "accountAPI" with DELETE http delete account API request
    Then account API call got success with status code "code200"
    And verify the "deleteMsg" from the "<TestCase>" account API response body with "expectedDeleteStatus"

    Examples: 
      | ColumnName | TestCase   |
      | type       | Advertiser |
      | type       | Agency     |
      | type       | Brand      |
