package activities;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;

public class Activity2 {

	WebDriver driver;

	@BeforeClass
	public void setUp() {
		// Initialize Webdriver
		driver = new FirefoxDriver();
		// Open the page
		driver.get("https://training-support.net/webelements/target-practice");
	}

	@Test
	public void testCase1() {
		// This test case will pass
		assertEquals(driver.getTitle(), "Selenium: Target Practice");
	}

	@Test

	public void testCase2() {
		// this test case will fail
		WebElement pinkButton = driver.findElement(By.cssSelector("button.bg-pink-200"));
		assertTrue(pinkButton.isDisplayed());
		assertEquals(pinkButton.getText(), "pink"); // P should be in caps to pass
	}

	@Test(enabled = false)

	public void testCase3() {
		// This method will be ignored
	}

	@Test

	public void testCase4() {
		// This method will be conditionally skipped
		throw new SkipException("This was skipped to prove a point");
	}

}
