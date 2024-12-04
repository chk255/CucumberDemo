package Standalone;

import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Overall {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String[] itemsneeded = { "Beetroot", "Cauliflower", "Cucumber" };
		
		String Itemsneeded="Beetroot";
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		WebElement prod = driver.findElement(By.xpath("//div[@class='product']"));
		List<WebElement> productsname = driver
				.findElements(By.xpath("//div[@class='product']/h4[@class='product-name']"));

		int j = 0;
		for (int i = 0; i < productsname.size(); i++)

		{

			String Prodname = productsname.get(i).getText().split("-")[0].trim();

			List items = Arrays.asList(itemsneeded);

			if ((Itemsneeded.equalsIgnoreCase(Prodname))) {
				j++;
				WebElement AddtoCart = driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i);
				AddtoCart.click();
				Thread.sleep(5000);
				if (j == itemsneeded.length) {
					break;
				}
			}

		}
		
		int itemscount=Integer.parseInt(driver.findElement(By.xpath("(//div[@class='cart-info']/table/tbody/tr/td[3])[1]")).getText());
		
		Assert.assertTrue(itemscount==itemsneeded.length);
		
		//WebElement Cartbutton=driver.findElement(By.cssSelector("img[alt='Cart']"));
		//Cartbutton.click();
		
		WebElement Topdeals=driver.findElement(By.xpath("//a[text()='Top Deals']"));
		Topdeals.click();
		
		Set<String> browser=driver.getWindowHandles();
		
		Iterator<String> it=browser.iterator();
		String parent=it.next();
		String Child=it.next();
		driver.switchTo().window(Child);
		
		
		
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("tom");
		String vegName=driver.findElement(By.xpath("//td[text()='Tomato']")).getText();
		
		Assert.assertTrue(vegName.equalsIgnoreCase("tomato"));
		
		//driver.close();

		
		
	}

}
