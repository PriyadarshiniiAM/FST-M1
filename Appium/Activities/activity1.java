package activities;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class activity1 {
	AppiumDriver driver;

	//Setup function
		@BeforeClass
		public void setUp() throws MalformedURLException, URISyntaxException {
			// Desired Capabilities
			UiAutomator2Options options = new UiAutomator2Options();
			options.setPlatformName("android");
			options.setAutomationName("UiAutomator2");
			options.setAppPackage("com.android.calculator2");
			options.setAppActivity(".Calculator");
			options.noReset();

			// server URL
			URL serverURL = new URI("http://localhost:4723").toURL();

			// Initialize the driver
			driver = new AndroidDriver(serverURL, options);
		}

	//Test function
		@Test
		public void addTest() {
			// find digit 5 and tap it
			driver.findElement(AppiumBy.id("digit_8")).click(); 
			// find plus symbol and tap it
			driver.findElement(AppiumBy.id("op_mul")).click();
			// find digit 3 and tap it
			driver.findElement(AppiumBy.id("digit_6")).click();
			// find equals symbol and tap it
			driver.findElement(AppiumBy.accessibilityId("equals")).click();

			// Assertion
			String result = driver.findElement(AppiumBy.id("result")).getText();
			assertEquals(result, "48");
		}

	//Tear down
		@AfterClass
		public void tearDown() {
			// close the app
			driver.quit();
		}


}
