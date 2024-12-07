package Stepdefination;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObject.OfferPageObject;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class OfferPage {
	
	String vegname;
	TestContextSetup testContextSetup;
	public OfferPageObject offerPageObject;
	public OfferPage(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	@Given("Search the product with shortname {string}")
	public void User_is_at_Offer_Page(String vegname) {
		//WebElement Topdeals=testContextSetup.driver.findElement(By.xpath("//a[text()='Top Deals']"));
		//Topdeals.click();
		
		offerPageObject=new OfferPageObject(testContextSetup.driver);
		offerPageObject.SearchProduct(vegname);
		
	}
	
	@Then("Name {string} should be displayed")
	public void product_should_be_displayed(String string) {
		String prodname=offerPageObject.Displayname(string);
		Assert.assertTrue(prodname.equalsIgnoreCase(string));
		testContextSetup.driver.close();
		
	}
	
	

}
