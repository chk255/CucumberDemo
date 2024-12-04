package Stepdefination;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Product;
import io.github.bonigarcia.wdm.WebDriverManager;



	public class GreenKartStepdefination {
		
		public WebDriver driver;
		@Given("User is at Product landing page")
		public void user_is_at_product_landing_page() {
			
			WebDriverManager.chromedriver().setup();

			WebDriver driver = new ChromeDriver();
			this.driver=driver;
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		}
		@When("User Select the prodcut {string} and add to cart")
		public void user_select_the_prodcut_and_add_to_cart(String string) throws InterruptedException {
			WebElement prod = driver.findElement(By.xpath("//div[@class='product']"));
			List<WebElement> productsname = driver
					.findElements(By.xpath("//div[@class='product']/h4[@class='product-name']"));

			int j = 0;
			for (int i = 0; i < productsname.size(); i++){
				String Prodname = productsname.get(i).getText().split("-")[0].trim();
				if ((string.equalsIgnoreCase(Prodname))) {
					j++;
					WebElement AddtoCart = driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i);
					AddtoCart.click();
					Thread.sleep(5000);
					if (j == 1) {
						break;
					}
				}
			}
		}
		@Then("itemscount should be equal to number of product added")
		public void itemscount_should_be_equal_to_number_of_product_added() {
	    int itemscount=Integer.parseInt(driver.findElement(By.xpath("(//div[@class='cart-info']/table/tbody/tr/td[3])[1]")).getText());
			
			Assert.assertTrue(itemscount==1);
			System.out.println("Test case is pass");
			driver.close();
		
	}
	

	
}
