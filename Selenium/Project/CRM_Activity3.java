package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Get the copyright text
//Goal: Print the first copyright text in the footer to the console
public class CRM_Activity3 {
	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Webdriver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("http://alchemy.hguy.co/crm");
		driver.manage().window().maximize();
	}

	@Test
	public void getCopyrightTest() {
		// Get the first copyright text in the footer.
		String actualCopyrightText = driver.findElement(By.id("admin_options")).getText();
		// Print the text to the console.
		System.out.println("The Copyright text in the Footer is : " + actualCopyrightText);

		// Verify the text with actual text
		String expectedCopyrightText = "© Supercharged by SuiteCRM";
		Assert.assertEquals(actualCopyrightText, expectedCopyrightText, "Copyright text is wrong");
	}
	
	@AfterClass
	public void browserCloes() {
		driver.quit();
	}
}
