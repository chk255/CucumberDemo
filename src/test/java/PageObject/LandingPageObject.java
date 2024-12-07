package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LandingPageObject {

	public WebDriver driver;

	public LandingPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='product']")
	WebElement prod;
	By AddtoCart=By.xpath("//button[text()='ADD TO CART']");
	@FindBy(xpath="(//div[@class='cart-info']/table/tbody/tr/td[3])[1]")
	WebElement pCount;
	@FindBy(xpath="//a[text()='Top Deals']")
	WebElement Topdeals;
	

	By pname = By.xpath("//div[@class='product']/h4[@class='product-name']");

	public void Selectproduct(String string) throws InterruptedException {

		List<WebElement> productsname = driver.findElements(pname);

		int j = 0;
		for (int i = 0; i < productsname.size(); i++) {
			String Prodname = productsname.get(i).getText().split("-")[0].trim();
			if ((string.equalsIgnoreCase(Prodname))) {
				j++;
				WebElement AddtoCart = driver.findElements(By.xpath("//button[text()='ADD TO CART']"))
						.get(i);
				AddtoCart.click();
				Thread.sleep(5000);
				if (j == 1) {
					break;

				}}}}

	public int validateItemCount() {
		
		 String productcount=pCount.getText();
		 int itemscount=Integer.parseInt(productcount);
		 return itemscount;	
	}

	public void topDeals() {
			Topdeals.click();
	}
}