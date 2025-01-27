package Project;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

//Traversing tables
//Goal: Open the accounts page and print the contents of the table
public class CRM_Activity8 {
	WebDriver driver;
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	Actions builder;

	// Set up method : Open a browser
	@BeforeClass
	public void setUp() {
		// Initialize Chrome driver
		driver = new FirefoxDriver();
		builder = new Actions(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		// Navigate to ‘http://alchemy.hguy.co/crm’.
		driver.get("http://alchemy.hguy.co/crm");
	}

	@Test(priority = 1)
	public void loginFormTest() {
		// Find the login input fields - username and password
		driver.findElement(By.id("user_name")).sendKeys("admin");
		driver.findElement(By.id("username_password")).sendKeys("pa$$w0rd");

		// Find the submit button and click it
		driver.findElement(By.xpath("//input[@type='submit']")).click();

		// verify that the homepage has opened
		String expectedUrl = "https://alchemy.hguy.co/crm/index.php?module=Home&action=index";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Login Failed");

	}

	@Test(priority = 2)
	public void openAccountsPage() throws InterruptedException {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("grouptab_0")));
		WebElement sales = driver.findElement(By.id("grouptab_0"));
		builder.moveToElement(sales).build().perform();

		// Select Accounts option
		driver.findElement(By.xpath("*//a[@id='grouptab_0']/following-sibling::ul/li[2]")).click();

		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("*//table[contains(@class,'table-responsive')]")));

		// Printing names from table
		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 1) {
				String nameText = driver.findElement(By.xpath("*//table[contains(@class,'table-responsive')]/tbody/tr[" + i + "]/td[3]")).getText();
				System.out.println(nameText);
			}
		}
	}

	@AfterClass
	public void afterClass() {

		driver.quit();
	}
}
