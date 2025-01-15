package activities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

//import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity20 {

	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		WebDriver driver = new FirefoxDriver();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Open the page
		driver.get("https://training-support.net/webelements/alerts");
		// Print the title of the page
		System.out.println("Page title: " + driver.getTitle());
		// find the element to launch the alert
		driver.findElement(By.id("prompt")).click();
		// Switch focus to the alert
		Alert promptAlert = driver.switchTo().alert();
		
		//Print the text in the alert
		 String alertText = promptAlert.getText();
	     System.out.println("Text in alert: " + alertText);
		
	    //Type into the alert
	     promptAlert.sendKeys("Its Awesome!Thanks");
	     Thread.sleep(5000);
	     
	     //close the alert by clicking OK
	     promptAlert.accept();
		//print the message
		System.out.println("Action Performed was: " + driver.findElement(By.id("result")).getText());
		
		//close the browser
		driver.quit();
	}

}
