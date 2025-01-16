package activities;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
	WebDriver driver; //decalred outside the function, because we can use it in any no. of functions.
	
  @BeforeClass
  public void setUp() {
	  //Initialize Webdriver
	  driver = new FirefoxDriver();
	  //Open the page
	  driver.get("https://training-support.net");
  }
  
  @Test (priority = 1)
  public void pageTitleTest() {
	  //Get the page title
	  //String pageTitle = driver.getTitle();
	  //Get the page title and verify it
	  assertEquals(driver.getTitle(), "Training Support");
  }
  
  @Test(priority = 2)
  public void aboutUsLinkTest() {
	  //Find and click the About Us link
	  driver.findElement(By.linkText("About Us")).click();
	  
	  //Verify the new page title
	  assertEquals(driver.getTitle(), "About Training Support");
  }
  
  @AfterClass
  public void tearDown() {
	  //close the browser
	  driver.quit();
  }

}
