package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestActivity1 {

	public static void main(String[] args) {
		
		// Initializing a driver should always be the first line
		WebDriver driver = new ChromeDriver();

		// open a browser/page
		driver.get("https://training-support.net"); // get-If the browser is open, it will open the page, if not, it
		//Print the page title
		System.out.println("Page title is: " + driver.getTitle());
		// will open the browser and open the page.

		//find the About Us link and click it
		driver.findElement(By.linkText("About Us")).click();
		//print the title of the new page
		System.out.println("The title of the New page:" +driver.getTitle());
		// close the browser
		driver.close();//close the current active tab
		//driver.quit();// close the entire tabs
	}

}
