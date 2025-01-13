package activities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestActivity13 {

	public static void main(String[] args) {
		//Initializing the Driver
		WebDriver driver = new FirefoxDriver();
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://training-support.net/webelements/tables");
        // Print the title of the page
        System.out.println("Page title: " + driver.getTitle());

        //print the number of rows and columns
        List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/thead.tr.th"));
        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr"));
        System.out.println("No. of rows: " + rows.size());
        System.out.println("No. of cloumns: " + columns.size());
        //print the third row of the table
        WebElement thirdRow = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[3]"));
        System.out.println("Third row: " +thirdRow.getText());
        //print the second row, second cell value
        WebElement Row2Cell2 = driver.findElement(By.xpath("//table[contains(@class, 'table-auto')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second cell: " + Row2Cell2.getText());
        
        //close the browser
        driver.quit();

	}

}
