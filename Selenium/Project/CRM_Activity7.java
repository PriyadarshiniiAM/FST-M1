package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Reading additional information
//Goal: Reading a popup that contains additional information about the account/lead.

public class CRM_Activity7 {
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
	public void additionalInformation() throws InterruptedException {
		driver.manage().window().maximize();
		//Navigate to Sales -> Leads
		driver.findElement(By.id("grouptab_0")).click();
		driver.findElement(By.id("moduleTab_9_Leads")).click();
		Thread.sleep(2000);
		//In the table, find the Additional information icon at the end of the row of the lead information. Click it.
		driver.findElement(By.xpath("//span[@title='Additional Details']")).click();
		Thread.sleep(2000);
		//Read the popup and print the phone number displayed in it.
		WebElement additionalDetails = driver.findElement(By.xpath("//span[@class='phone']"));
		String mobileNumber = additionalDetails.getText();
		System.out.println("The mobile number is :" + mobileNumber);
		Assert.assertFalse(mobileNumber.isEmpty(),"Mobile Number not available");

	}

  @AfterClass
  public void browserClose() {
	  driver.quit();
  }
}
