package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Menu checking
//Goal: Make sure that the “Activities” menu item exists and is clickable

public class CRM_Activity6 {
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

	// Ensure that the “Activities” menu item exists
	@Test(priority = 2)
	public void locateMenu() throws InterruptedException {
		Thread.sleep(5000);
		driver.manage().window().maximize();

		WebElement activitiesMenu = driver.findElement(By.id("grouptab_3"));
		String textAct = activitiesMenu.getText();
		Thread.sleep(5000);
		System.out.println("The Menu has " + textAct);
		Assert.assertTrue(activitiesMenu.isEnabled());

	}

	@AfterClass
	public void browserClose() {
		// close the browser
		driver.quit();
	}
}
