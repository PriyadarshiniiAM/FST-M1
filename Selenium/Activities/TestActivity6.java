package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestActivity6 {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://training-support.net/webelements/dynamic-controls");
		// Print the title of the page
		System.out.println("Page title: " + driver.getTitle());
		//Find the checkbox element
		WebElement checkbox = driver.findElement(By.id("checkbox"));
		
		//click
		checkbox.click();
		
        // print the visibility of the checkbox
        System.out.println("Is Checkbox is selected: " + checkbox.isSelected());
        // Click the button again
        //driver.findElement(By.xpath("//button[text()='Toggle Checkbox']")).click();
        checkbox.click();
        // Check if it is displayed on the page
        System.out.println("Is Checkbox is selected: " + checkbox.isSelected());

        // Close the browser
        driver.quit();
	}

}
