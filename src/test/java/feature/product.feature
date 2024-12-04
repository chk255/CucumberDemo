


Feature: Select the product and Add to Cart
  


  Scenario: Select the product and add to cart and search the product in offers page
    Given User is at Product landing page
    When User Select the prodcut "Beetroot" and add to cart
    Then itemscount should be equal to number of product added
    


