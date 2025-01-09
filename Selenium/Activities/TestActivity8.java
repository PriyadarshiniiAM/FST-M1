package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TestActivity8 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		 // Create the Actions object
        Actions builder = new Actions(driver);

		driver.get("https://training-support.net/webelements/mouse-events");
		// Print the title of the page
		System.out.println("Page title: " + driver.getTitle());

		//Find all the buttons on the page
		WebElement cargoLock = driver.findElement(By.xpath("//h1[text()='Cargo.lock']"));
		WebElement cargoToml = driver.findElement(By.xpath("//h1[text()='Cargo.toml']"));
		WebElement srcButton = driver.findElement(By.xpath("//h1[text()='src']"));
		WebElement targetButton = driver.findElement(By.xpath("//h1[text()='target']"));
		
		//Left click .lock button, then click .toml button
		builder.click(cargoLock).pause(5000L).moveToElement(cargoToml).pause(5000L).click().build().perform(); //pause takes argument as Long value, 5000L
		
		//Print the message at the end of the sequence
		System.out.println(driver.findElement(By.id("result")).getText());
		
		//double click src button,then right click(contextClick) target button and select open
		builder.doubleClick(srcButton).pause(5000L).
		contextClick(targetButton).pause(5000L).
		build().perform();
		//then click the open option
		WebElement openOption = driver.findElement(By.xpath("//div[@id='menu']//ul/li[1]"));
		//openOption.click();
		builder.click(openOption).pause(5000L).build().perform();
		//print the message at the end of sequence
		System.out.println(driver.findElement(By.id("result")).getText());
		
		//close the browser
		driver.quit();
	}
}
