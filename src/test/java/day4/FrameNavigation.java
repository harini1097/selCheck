package day4;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FrameNavigation {
 
	WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside before class");
		  System.setProperty("webdriver.chrome.driver", "C:\\Suganya_Devops\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://10.232.237.143:443/TestMeApp/fetchcat.htm");
	  }
	  
	  @Test()
	  public void alertWindow()
	  {
		  //String expectedResult="Contact Us";
		  WebElement aboutus= driver.findElement(By.xpath("//ul[@id='menu3']//li[3]/a/span"));
		  WebElement ourOffice=driver.findElement(By.xpath("//ul[@id='menu3']//li[3]//li/a/span"));
		  WebElement Chennai = driver.findElement(By.xpath("//ul[@id='menu3']//li[3]//li/ul/li/a/span"));
		  WebElement bangalore = driver.findElement(By.xpath("//ul[@id='menu3']//li[3]//li/ul/li[2]/a/span"));
		  
		  Actions action=new Actions(driver);
		  action.moveToElement(aboutus).click().build().perform();
		  
		  WebDriverWait wait=new WebDriverWait(driver, 60);
		  wait.until(ExpectedConditions.elementToBeClickable(ourOffice));
		  action.moveToElement(ourOffice).click().build().perform();
		  
		  wait.until(ExpectedConditions.elementToBeClickable(Chennai));
		  action.moveToElement(Chennai).click().build().perform();
		  
		  String parentWindow=driver.getWindowHandle();
		  Set<String> s=driver.getWindowHandles();
		  for(String sFor:s)
		  {
			  driver.switchTo().window(sFor);
		  }
		 
		  driver.switchTo().frame("main_page");
		  String address=driver.findElement(By.tagName("address")).getText();
		  System.out.println(address);
		  
		  driver.switchTo().window(parentWindow);
		 
		  action.moveToElement(aboutus).click().build().perform();
		  wait.until(ExpectedConditions.elementToBeClickable(ourOffice));
		  action.moveToElement(ourOffice).click().build().perform();
		  wait.until(ExpectedConditions.elementToBeClickable(bangalore));
		  action.moveToElement(bangalore).click().build().perform();
		  Set<String> sbang=driver.getWindowHandles();
		  for(String sFor:sbang)
		  {
			  driver.switchTo().window(sFor);
		  }
		  driver.switchTo().frame(driver.findElement(By.name("main_page")));
		  String addressBangalore=driver.findElement(By.tagName("address")).getText();
		  System.out.println(addressBangalore); 
		  
		  driver.quit();
	  }
	  
}
