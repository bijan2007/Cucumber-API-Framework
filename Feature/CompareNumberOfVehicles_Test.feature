@tag
Feature: Compare data of Newly Registered Motor Vehicles in Karnataka and Maharashtra

@tag1
Scenario: User calls Web Service to Get Number of Newly Registered Motor Vehicles in Karnataka
Given Karnataka API status code is OK
Then Store response from Karnataka in CSV


@tag2
Scenario: User calls Web Service to Get Number of Newly Registered Motor Vehicles in Maharashtra
Given Maharashtra API status code is OK
Then Store response from Maharashtra in CSV

@tag3
Scenario: User compares API response on Newly Resigtered Motor Vehicles from Karnataka with Maharashtra
Given Compare response files