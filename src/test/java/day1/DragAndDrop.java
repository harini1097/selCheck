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

public class DragAndDrop {
	WebDriver driver;
	  String expectedResult="Find a Flight: Mercury Tours:";
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside before class");
		  System.setProperty("webdriver.chrome.driver", "C:\\Suganya_Devops\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://jqueryui.com/resources/demos/resizable/default.html");
	  }
	  
	  @Test(priority=1)
	  public void login() throws InterruptedException {
		  System.out.println("Inside Function 1");
		 
		  WebElement dragAndDrop = driver.findElement(By.xpath("//div[@id='resizable']//div[3]"));
		  Actions action=new Actions(driver);		 
		  action.dragAndDropBy(dragAndDrop, 300, 300).build().perform();
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
