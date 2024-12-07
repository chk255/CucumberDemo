package Stepdefination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import PageObject.LandingPageObject;
import Utils.TestContextSetup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Product;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPage {

	// public WebDriver driver;
	TestContextSetup testContextSetup;
	public LandingPageObject landingPageObject;

	public LandingPage(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	@Given("User is at Product landing page")
	public void user_is_at_product_landing_page() {

		WebDriverManager.chromedriver().setup();

		testContextSetup.driver = new ChromeDriver();
		// this.driver=driver;
		testContextSetup.driver.manage().window().maximize();
		testContextSetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("User Select the prodcut {string} and add to cart")
	public void user_select_the_prodcut_and_add_to_cart(String string) throws InterruptedException {

		landingPageObject = new LandingPageObject(testContextSetup.driver);
		landingPageObject.Selectproduct(string);
	}

	@Then("itemscount should be equal to number of product added  and click on offer")
	public void itemscount_should_be_equal_to_number_of_product_added() {

		int itemscounts = landingPageObject.validateItemCount();
		Assert.assertTrue(itemscounts == 1);
		System.out.println("Test case is pass");
		WebElement Topdeals = testContextSetup.driver.findElement(By.xpath("//a[text()='Top Deals']"));
		Topdeals.click();

	}

}
