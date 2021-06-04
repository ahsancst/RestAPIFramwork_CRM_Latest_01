Feature: Validating opportunity APIs

  @OpportunityEndpoint @Regression
  Scenario Outline: Verify if opportunity is being succesfully added using opportunityAPIs
    Given Get the create opportunity payload with "baseURL_CRM" and "<ColumnName>" and "<TestCase>" and "<SheetName>"
    When user calls "opportunityAPI" with POST http opportunity API request
    Then opportunity API call got success with status code "code200"
    And get the "planId" from the opportunity API response body

    Examples: 
      | ColumnName | TestCase | SheetName   |
      | Type       | Create   | Opportunity |

  @OpportunityEndpoint @Regression
  Scenario Outline: Verify if opportunity is being succesfully updated using opportunityAPIs
    Given Get the update opportunity payload with "baseURL_CRM" and "<ColumnName>" and "<TestCase>"
    When user calls "opportunityAPI" with PUT http opportunity API request
    Then opportunity API call got success with status code "code200"
    And verify the "opportunityUpdateParam" as "opportunityUpdateStatus" from the update opportunity API response body

    Examples: 
      | ColumnName | TestCase |
      | Type       | Update   |

  @OpportunityEndpoint @Regression
  Scenario Outline: Verify if opportunity is being succesfully deleted using opportunityAPIs
    Given Get the delete opportunity payload with "baseURL_CRM" and "<TestCase>"
    When user calls "opportunityAPI" with DELETE http opportunity API request
    Then opportunity API call got success with status code "code200"
    And verify the "opportunityDeleteParam" as "opportunityDeleteStatus" from the delete opportunity API response body

    Examples: 
      | TestCase |
      | Delete   |
