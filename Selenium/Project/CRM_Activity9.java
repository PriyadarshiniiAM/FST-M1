package Project;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Traversing tables 2
//Goal: Find the table on the page and print the first 10 values in the Name column and the User column of the table to the console.

public class CRM_Activity9 {
	WebDriver driver;
	Actions action;
	WebDriverWait wait;

	@BeforeClass
	public void setUp() {
		// Initialize Webdriver
		driver = new FirefoxDriver();
		action = new Actions(driver);
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
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
	public void getLeadsNameAndUser() throws InterruptedException {
		driver.manage().window().maximize();

		// Navigate Sales->Leads
		WebElement sales = driver.findElement(By.xpath("*//a[@id='grouptab_0']"));
		action.moveToElement(sales).click().build().perform();
		WebElement leads = driver.findElement(
				By.xpath("*//a[@id='grouptab_0']//following-sibling::ul[@class='dropdown-menu']/li/a[text()='Leads']"));
		leads.click();
		action.pause(5000L).build().perform();

		// Printing names from table
		for (int i = 1; i <= 10; i++) {

			String nameText = driver
					.findElement(By.xpath("*//table[contains(@class,'table-responsive')]/tbody/tr[" + i + "]/td[3]"))
					.getText();
			String userText = driver
					.findElement(By.xpath("*//table[contains(@class,'table-responsive')]/tbody/tr[" + i + "]/td[8]"))
					.getText();

			System.out.println(i + ". Name : " + nameText + " ; User : " + userText);
		}

	}

	@AfterClass
	public void afterClass() {

		driver.quit();

	}
}
