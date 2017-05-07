Feature: Issue to user
  Scenario: Scenario_1
    Given Log in as "tester1"
    And Click on ReportIssue at the top
    When Fill the form from example "Issue"
    And Click on SubmitIssue
    And Click on ViewIssue
    Then Check that the IssueList contains "Issue" with "assigned" by "dev1"
    And Log out
    Given Log in as "dev1"
    And Click on ViewIssue
    Then Check that the IssueList contains "Issue" with "assigned" by "dev1"
    Given Open "Issue"
    And Task fields contain info from "Issue" with reporter by "tester1", status by "assigned", resolution by "open"
    Then Change status to "resolved"
    And Click on "Change Status To:" button
    And Click on "Resolve Issue" button
    And Log out
    Given Log in as "lead1"
    And Click on ViewIssue
    Then Check that the IssueList contains "Issue" with "resolved" by "dev1"
    Given Open "Issue"
    Then Change status to "closed"
    And Click on "Change Status To:" button
    And Click on "Close Issue" button
    And Click on MyView
    And Click on "Recently Modified (30 Days)" button
    Then Check that the IssueList contains "Issue" with "closed" by "lead1"