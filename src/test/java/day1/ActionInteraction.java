package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActionInteraction {
	WebDriver driver;
	  String expectedResult="Find a Flight: Mercury Tours:";
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside before class");
		  System.setProperty("webdriver.chrome.driver", "C:\\Suganya_Devops\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://www.google.com/");
	  }
	  
	  @Test(priority=1)
	  public void login() throws InterruptedException {
		  System.out.println("Inside Function 1");
		 
		  WebElement clickHold = driver.findElement(By.linkText("Gmail"));
		  Actions action=new Actions(driver);
		  action.clickAndHold(clickHold).build().perform(); // click and hold and will not move to next page
		  action.clickAndHold(clickHold).release().build().perform(); //click and hold for few seconds and release which navigate to next page
	  }
	  
	  @Test(enabled=false)
	  public void f1(){
		  System.out.println("Inside function 2");
	  }
	  
	 

	  @AfterClass
	  public void afterClass() {
		  System.out.println("Inside after class");
		  //driver.close();
	  }
	  
	  @BeforeTest
	  public void beforeTest()
	  {
		  System.out.println("inside before test");
	  }

	  @AfterTest
	  public void afterTest(){
		  System.out.println("inside after test");
	  }

}
