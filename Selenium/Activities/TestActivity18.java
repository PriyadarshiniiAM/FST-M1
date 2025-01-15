package activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity18 {

	public static void main(String[] args) {
		// Initializing the Driver
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://training-support.net/webelements/alerts");
		// Print the title of the page
		System.out.println("Page title: " + driver.getTitle());
		// find the element to launch the alert
		driver.findElement(By.id("simple")).click();
		// switch focus to the alert
		Alert simpleAlert = driver.switchTo().alert();
		// Print the alert text
		System.out.println("Alert message : " + simpleAlert.getText());
		// click OK on the alert
		simpleAlert.accept();

		// Print the message
		System.out.println(driver.findElement(By.id("result")).getText());

		// close the browser
		driver.quit();
	}

}
