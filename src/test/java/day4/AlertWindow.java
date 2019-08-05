package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertWindow {
  
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
		  WebElement alert= driver.findElement(By.xpath("//input[@value='FIND DETAILS']"));
		  alert.click();
		  String mess=driver.switchTo().alert().getText();
		  System.out.println(mess);
		  driver.switchTo().alert().accept();
	  }
	  
	  @AfterClass
	  public void afterClass()
	  {
		 // driver.close();
	  }
}
