Feature: Login and Product Actions
Scenario: Verify user login and product actions
Given user opens browser and navigates to website
When user clicks on My Account
And user clicks on Login option
And user enters email 
And user enters password 
And user clicks on Login button
And user navigates to Mac products
And user adds product to wishlist
And user adds product to cart
And user opens product and prints details
And user fills contact us form
Then user closes browser