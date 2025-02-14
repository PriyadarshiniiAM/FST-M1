package activities;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Activity4 {
	 // Driver Declaration
    AndroidDriver driver;
    WebDriverWait wait;
 
    // Set up method
    @BeforeClass
    public void setUp() throws MalformedURLException, URISyntaxException {
        // Desired Capabilities
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("android");
        options.setAutomationName("UiAutomator2");
        options.setAppPackage("com.google.android.dialer");
        options.setAppActivity(".extensions.GoogleDialtactsActivity");
        options.noReset();
 
        // Server Address
        URL serverURL = new URI("http://localhost:4723").toURL();
 
        // Driver Initialization
        driver = new AndroidDriver(serverURL, options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
 // Test method
    @Test
    public void contactsTest() {
    	//find the contacts icon and click
    	driver.findElement(AppiumBy.accessibilityId("Phone")).click();
        // Find and click the add button
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.google.android.dialer:id/contact_name\" and @text=\"Create new contact\"]")).click();
        
     // Wait for elements to load
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.EditText[@text='First name']")));
        
        //Enter the details
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
        driver.findElement(AppiumBy.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("9597891293");
        
       //click on save
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.android.contacts:id/editor_menu_save_button\"]")).click();
        
        //wait for the contacts to save
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(AppiumBy.xpath("//android.widget.TextView[@text='Aaditya Varma']")));
        
        //Assertion
        String contactName = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Aaditya Varma']")).getText();
        Assert.assertEquals(contactName, "Aaditya Varma");
    }
    
    //close
    @AfterClass
    public void tearDown() {
    	driver.quit();
    }
 
}
