package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity2 {
	AppiumDriver driver;
    WebDriverWait wait;

	// Setup function
	@BeforeClass
	public void setUp() throws MalformedURLException, URISyntaxException {
		// Desired Capabilities
		UiAutomator2Options options = new UiAutomator2Options();
		options.setPlatformName("android");
		options.setAutomationName("UiAutomator2");
		options.setAppPackage("com.android.chrome");
		options.setAppActivity("com.google.android.apps.chrome.Main");
		options.noReset();

		// server URL
		URL serverURL = new URI("http://localhost:4723").toURL();

		// Initialize the driver
		driver = new AndroidDriver(serverURL, options);

		// Open the page in Chrome
		driver.get("https://training-support.net");
		
	}

	// Test method
	@Test
	public void chromeTest() throws InterruptedException {
		String pageTitle = driver.findElement(AppiumBy.xpath("//android.view.View[@text='Training Support']")).getText();

		// Print to console
		System.out.println("Title: " + pageTitle);
		//wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Find and click the AboutUs Link
		driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).click();
		Thread.sleep(1000);

		// Find heading of new page and print to console
		String pageHeading = driver.findElement(AppiumBy.xpath("//android.view.View[@text='About Us']")).getText();
		System.out.println("pageHeading");

	}

	// Tear down
	@AfterClass
	public void tearDown() {
		// close the app
		driver.quit();
	}

}