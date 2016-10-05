Feature: List Item

  Background:
    Given Lista de Itens application is opened
    And visualize the Home screen of the application

  @TDC
  Scenario: Save item with success
    Given form item is opened
    When type the item name "ARROZ"
    And chose the category "Alimentos"
    And type the quantity "2"
    And type the unit price "2.50"
    And check the total price item "5.0"
    And click on save button
    Then verify the item "ARROZ" save with success
