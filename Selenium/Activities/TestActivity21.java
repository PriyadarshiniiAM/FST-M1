package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity21 {

	public static void main(String[] args) {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page
		driver.get("https://training-support.net/webelements/tabs");
		// Print the title of the page
		System.out.println("Page title: " + driver.getTitle());
		// Print the current page handle
		System.out.println("Page handle is: " + driver.getWindowHandle());

		// Find the button to open a new tab and click it
		driver.findElement(By.xpath("//button[contains(text(), 'Open')]")).click();
		// Wait for a new tab to open
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));
		// Print the windows handles
		System.out.println("Current windows open: " + driver.getWindowHandles());

		// Switch to the new tab
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		// Print the new page title
		System.out.println("Page title is: " + driver.getTitle());
		// Print the current page handle
		System.out.println("Page handle is: " + driver.getWindowHandle());
		// Print the message on the page
		System.out.println("Page message is: " + driver.findElement(By.cssSelector("h2.mt-5")).getText());

		// Open the page
		driver.get("https://training-support.net/webelements/tabs");
		// Print the title of the page
		System.out.println("Page title: " + driver.getTitle());
		// Print the current page handle
		System.out.println("Page handle is: " + driver.getWindowHandle());

		// Find the button to open a new tab and click it
		driver.findElement(By.xpath("//button[contains(text(), 'Open')]")).click();
		// Wait for a new tab to open
		wait.until(ExpectedConditions.numberOfWindowsToBe(3));
		// Print the windows handles
		System.out.println("Current windows open: " + driver.getWindowHandles());

		// Switch to the new tab
		for (String handle : driver.getWindowHandles()) {
			driver.switchTo().window(handle);
		}

		// Print the new page title
		System.out.println("Page title is: " + driver.getTitle());
		// Print the current page handle
		System.out.println("Page handle is: " + driver.getWindowHandle());
		// Print the message on the page
		System.out.println("Page message is: " + driver.findElement(By.cssSelector("h2.mt-5")).getText());

		// close the browser
		driver.quit();
	}

}
