


Feature: Select the product and Add to Cart and search product with short name in offer page
  


  Scenario: Select the product and add to cart and search the product in offers page
    Given User is at Product landing page
    When User Select the prodcut "Beetroot" and add to cart
    Then itemscount should be equal to number of product added  and click on offer
     And Search the product with shortname "tom"
     And Name "Tomato" should be displayed
    
 
   
    


