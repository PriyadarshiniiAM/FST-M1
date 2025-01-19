package Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Get the url of the header image
//Goal: Print the url of the header image to the console

public class CRM_Activity2 {
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
	public void getHeaderImageURL() {
		// Find the header image element using its XPath
		WebElement headerImage = driver.findElement(By.xpath("//img[@alt='SuiteCRM']"));
		// Get the URL of the header image
		String actualimageURL = headerImage.getDomAttribute("src");
		
		// Print the image URL to the console
		System.out.println("The url of the Image is : " + actualimageURL);
		
		//Verify the URL
		String expimageUrl = "themes/default/images/company_logo.png?v=cK7kLsY0ftg72ZVHTYUT_g";
		Assert.assertEquals(actualimageURL, expimageUrl);
	}

	@AfterClass
	public void browserclose() {
		//close the browser
		driver.quit();
	}
}
