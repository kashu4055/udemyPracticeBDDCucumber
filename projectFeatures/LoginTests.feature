@functionalTests
Feature: The Login Page 
As a ____ user (role)
I want to ___ login to the application (feature)
So that ___ able to use full website functionality (business value)

Background:
	Given the user is on  the login page


Scenario: the user should be able to login with valid credentials
	When the user enters valid credentials
	Then the user should be able to view their balance
	
@ignore
Scenario: the user should not be able to login with not valid credentials
	When the user enters not valid credentials
	Then the user should not be able to sign in
	
@ignore
Scenario: the user should not be able to sign up with not valid credentials
When user enters username as "username"
And user enters password as "123456"
And user clicks on signUp
Then the user should see error message like "There were problems creating your account."

@ignore
Scenario Outline:
When user enters "<username>" and "<password>"
And user clicks on signUp
Then the user should see error message like "There were problems creating your account."

Examples:
|username|password|
|user1|123456|
|user2|12345|

@ignore
Scenario: user enters not valid credentials and then not valid credentials again
When user enteres credentials username and password
|username|password|
|user1|mypassword|
|user2|mypassword|
Then the user should see error message like "There were problems creating your account."
	
	