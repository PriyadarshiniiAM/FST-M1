package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity14 {

	public static void main(String[] args) {
		//Initializing the Driver
				WebDriver driver = new FirefoxDriver();
				//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
				driver.get("https://training-support.net/webelements/tables");
		        // Print the title of the page
		        System.out.println("Page title: " + driver.getTitle());

		        //print the number of rows and columns
		        List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th"));
		        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
		        System.out.println("No. of rows: " + rows.size());
		        System.out.println("No. of cloumns: " + columns.size());
		        //print the 5th book title from the table
		        WebElement fifthRowBook = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
		        System.out.println(fifthRowBook.getText());
		        //sort the table by price
		        driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/thead/tr/th[5]")).click();
		        fifthRowBook = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[5]/td[2]"));
		        System.out.println(fifthRowBook.getText());
		        
		        //close the browser
		        driver.quit();

	}

}
