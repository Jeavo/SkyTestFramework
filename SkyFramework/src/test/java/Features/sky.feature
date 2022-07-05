#Author: ryanjeavo@gmail.com
#30/05/22
#Description: Created for Sky Tech Test
#Sample Feature Definition Template
@TestScenario
Feature: This feature will make sure that the shop page is navigable and usable

	@Test1
  Scenario Outline: User navigates to shop page
    Given I am on the home page
    When I navigate to <page>
    Then the user should be on <page>

    Examples: 
      | page  |
      | deals |

  @Test1
  Scenario: User Sees Instructions on the Sign In Page
    Given I am on the home page
    When I try to sign in with invalid credentials
    Then I should see a box with the text Create your My Sky password
    
    
	@Test1
	Scenario: User sees a list of deals on the deals page
	Given I am on the deals page
	Then I see a list of deals with a price to it
	
	
	@Test1
	Scenario: User uses the search box
	Given I am on the home page
	When I search Sky in the search bar
	Then I should see the editorial section
	
