package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Getting colors
//Goal: Get the color of the navigation menu

public class CRM_Activity5 {
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

	@Test(priority = 2)
	public void navigationMenu() {
		Color navMenuColor = Color.fromString(driver.findElement(By.id("toolbar")).getCssValue("color"));
		String expectedNavMenuColorRGB = "rgb(83, 77, 100)";
		String actualNavMenuColorRGB = navMenuColor.asRgb();
		System.out.println("Navigation Menu Color as RGB is : " + actualNavMenuColorRGB);
		Assert.assertEquals(actualNavMenuColorRGB, expectedNavMenuColorRGB);
	}

	@AfterClass
	public void browserClose() {
		//close the browser
		driver.quit();
	}
}
