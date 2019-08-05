package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Basics {
	
  WebDriver driver;
  String expectedResult="Find a Flight: Mercury Tours:";
  
  @BeforeClass
  public void beforeClass() {
	  System.out.println("Inside before class");
	  System.setProperty("webdriver.chrome.driver", "C:\\Suganya_Devops\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.get("http://demoaut.com/");
  }
  
  @Test(priority=1)
  public void login() throws InterruptedException {
	  System.out.println("Inside Function 1");
	  driver.findElement(By.name("userName")).sendKeys("tutorial");
	  driver.findElement(By.name("password")).sendKeys("tutorial");
	  driver.findElement(By.name("login")).click();
	  //IMPLICIT WAIT
	  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  //EXPLICIT WAIT
	  WebDriverWait wait=new WebDriverWait(driver, 30);
	  wait.until(ExpectedConditions.titleIs(expectedResult)); //wait till the title get changed to next page
	  Assert.assertEquals(expectedResult, driver.getTitle());
	  
  }
  
  @Test(enabled=false)
  public void f1(){
	  System.out.println("Inside function 2");
  }
  
 

  @AfterClass
  public void afterClass() {
	  System.out.println("Inside after class");
	  driver.close();
  }
  
  @BeforeTest
  public void beforeTest()
  {
	  System.out.println("inside before test");
  }
  
  /*@BeforeMethod
  public void beforeMethod(){
	  System.out.println("Inside before method");
  }
  
  @AfterMethod
  public void afterMethod(){
	  System.out.println("Inside after method");
  }*/

  @AfterTest
  public void afterTest(){
	  System.out.println("inside after test");
  }
  
}
