package activities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestActivity15 {

	public static void main(String[] args) {
		//Initializing the Driver
		WebDriver driver = new FirefoxDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://training-support.net/webelements/dynamic-attributes");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        //Find the full name field and enter the details
        driver.findElement(By.xpath("//input[starts-with(@id, 'full-name-')]")).sendKeys("Priya");
        //Find the email field and enter details
        driver.findElement(By.xpath("//input[contains(@id, '-email')]")).sendKeys("priya@example.com");
        //Find the date fields and enter details
        //Date must be entered as YYYY-MM-DD
        driver.findElement(By.xpath("//input[contains(@name, '-event-date-')]")).sendKeys("2025-01-14");
        //find the additional details and enter additional details
        driver.findElement(By.xpath("//textarea[contains(@id, '-additional-details-')]")).sendKeys("Pongal");
        //find the click submit and click it
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
        //to print confirmation message
        String message = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("action-confirmation"))).getText();
        System.out.println(message);
        
        //close the browser
        driver.quit();
        
        
	}

}
