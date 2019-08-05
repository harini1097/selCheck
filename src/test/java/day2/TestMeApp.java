package day2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestMeApp {
	WebDriver driver;
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside before class");
		  System.setProperty("webdriver.chrome.driver", "C:\\Suganya_Devops\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  }
	  
	  @Test(enabled=false)
	  public void aboutUs() throws InterruptedException {
		  String expectedResult="Contact Us";
		  WebElement aboutus= driver.findElement(By.xpath("//ul[@id='menu3']//li[3]/a/span"));
		  WebElement ourOffice=driver.findElement(By.xpath("//ul[@id='menu3']//li[3]//li/a/span"));
		  WebElement Chennai = driver.findElement(By.xpath("//ul[@id='menu3']//li[3]//li/ul/li/a/span"));
		  
		  Actions action=new Actions(driver);
		  action.moveToElement(aboutus).click().build().perform();
		  
		  WebDriverWait wait=new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.elementToBeClickable(ourOffice));
		  action.moveToElement(ourOffice).click().build().perform();
		  
		  wait.until(ExpectedConditions.elementToBeClickable(Chennai));
		  action.moveToElement(Chennai).click().build().perform();
		  
		  
		  wait.until(ExpectedConditions.titleIs(expectedResult));
		  Assert.assertEquals(expectedResult, driver.getTitle());
		  
	  }
	  
	  @Test
	  public void search()
	  {
		  WebElement search= driver.findElement(By.id("myInput"));
		  Actions action1=new Actions(driver);
		  action1.keyDown(search, Keys.SHIFT).perform();
		  action1.sendKeys("b").pause(3000).sendKeys("a").pause(3000).sendKeys("g").pause(3000).click(search).build().perform();
		  WebElement clickHandBag = driver.findElement(By.xpath("//div[contains(text(),'Hand bag')]"));
		  WebElement findDetails= driver.findElement(By.xpath("//input[@value='FIND DETAILS']"));
		  
		  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  action1.moveToElement(clickHandBag).click().build().perform();
		  
		  action1.click(findDetails).build().perform();
		
		  String winHandleBefore = driver.getWindowHandle();

			for(String winHandle : driver.getWindowHandles()){
			    driver.switchTo().window(winHandle);
			}
		  
		  
		  WebElement checkText=driver.findElement(By.xpath("//h4[contains(text(),'Hand bag')]"));
		  String check= checkText.getText();
		  Assert.assertTrue(check.contains("Hand bag"));
		  
	  }
	  
	  @AfterClass
	  public void afterClass() {
		  System.out.println("Inside after class");
		  driver.quit();
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
