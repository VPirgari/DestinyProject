Feature: Airtable import, add descriptions to fields

  Background:
    Given User is on airtable page and logged in
    When user click on Destiny Import Project

  @studentEnrollments1.0
  Scenario: update table "Student Enrollments 1.0" columns with description
    And select "Student Enrollments 1.0" table
    Then user should add descriptions to headers moving bar with 200

  @courses1.1
  Scenario: update table "Courses 1.1" columns with description
    And select "Courses 1.1" table
    Then user should add descriptions to headers moving bar with 200


  @sections1.2
  Scenario: update table "Sections 1.2" columns with description
    And select "Sections 1.2" table
    Then user should add descriptions to headers moving bar with 60
