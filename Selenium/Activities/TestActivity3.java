package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity3 {

	public static void main(String[] args) {
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://training-support.net/webelements/login-form");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());
        
        // Find the username field and enter the username
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("admin");
        
        // Find the password field and enter the password
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("password");
        //driver.findElement(By.id("password")).sendKeys("password");
        // Find the login button and click it
        driver.findElement(By.xpath("//button[text()='Submit']")).click();
        
        // Print the confirmation message
        String message = driver.findElement(By.xpath("//h1[contains(text(), 'Success')]")).getText();
        System.out.println(message);
        
        //print the success page title
        //System.out.println("Page title: " + driver.getTitle());
        //close the browser
        driver.quit();
	}
}