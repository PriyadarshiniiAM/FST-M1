package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Enter login credentials into the respective fields
//Verify that the Homepage has opened
public class CRM_Activity4 {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Webdriver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void pageTitleTest() {
		// Get the page title and verify it
		Assert.assertEquals(driver.getTitle(), "SuiteCRM", "Wrong Website");

	}

	@Test(priority = 2)
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

	@AfterClass
	public void browserClose() {
		// close the browser
		driver.quit();
	}
}
