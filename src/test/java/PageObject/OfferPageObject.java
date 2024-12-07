package PageObject;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OfferPageObject {

	public WebDriver driver;

	public OfferPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='search-field']")
	WebElement searchbox;
	@FindBy(xpath="//td[text()='Tomato']")
	WebElement pname;

	public void SearchProduct(String vegname) {
		Set<String> browser = driver.getWindowHandles();

		Iterator<String> it = browser.iterator();
		String parent = it.next();
		String Child = it.next();
		driver.switchTo().window(Child);
		searchbox.sendKeys(vegname);
	}
	public String Displayname(String string) {
		String prodname=pname.getText();
		return prodname;
	}
}