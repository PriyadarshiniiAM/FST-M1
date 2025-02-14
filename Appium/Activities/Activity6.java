package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity6 {
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
		driver.get("https://training-support.net/webelements/sliders");
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
		
		
		@Test (priority = 1)
		public void volume75Test() {
			// Wait for page to load
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
			// Get the size of the screen
			Dimension dims = driver.manage().window().getSize();
			// Set the start and end points
			Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .65));
			Point end = new Point((int) (dims.getWidth() * .67), (int) (dims.getHeight() * .65));
			// Perform swipe
			ActionsBase.doSwipe(driver, start, end, 2000);
			
			//Get the volume level
			String volumeText = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"50%\"]")).getText();
	 

}
		@Test (priority = 2)
		public void volume25Test() {
			// Wait for page to load
			wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.SeekBar")));
			// Get the size of the screen
			Dimension dims = driver.manage().window().getSize();
			// Set the start and end points
			Point start = new Point((int) (dims.getWidth() * .50), (int) (dims.getHeight() * .65));
			Point end = new Point((int) (dims.getWidth() * .33), (int) (dims.getHeight() * .65));
			// Perform swipe
			ActionsBase.doSwipe(driver, start, end, 2000);
			
			//Get the volume level
			String volumeText = driver.findElement(AppiumBy.xpath("//android.view.View[@text=\"50%\"]")).getText();
			
}
}
