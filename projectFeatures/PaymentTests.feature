@noCode
Feature: user should be able to purchase product

Background:
Given navigate to the home page
Given load signIn widjet
Given enter valid credentials

@regressionTests
Scenario: user add product to the cart
	Given enter product name in search field
	And click on go button
	And click on the first product
	And click on the add button

@end2EndTests	
Scenario: users add product to the cart
	Given enter product name in search field
	And click on go button
	And click on the first product
	And click on the add button