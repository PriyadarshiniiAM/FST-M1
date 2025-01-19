package Project;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CRM_Activity1 {
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

	@AfterClass
	public void browserClose() {
		// close the browser
		driver.quit();

	}
}
