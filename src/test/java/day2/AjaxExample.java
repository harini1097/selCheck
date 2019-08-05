package day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AjaxExample {
	WebDriver driver;
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside before class");
		  System.setProperty("webdriver.chrome.driver", "C:\\Suganya_Devops\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("https://demos.telerik.com/aspnet-ajax/ajaxloadingpanel/functionality/explicit-show-hide/defaultcs.aspx");
	  }
	  
	  @Test(priority=1)
	  public void login() throws InterruptedException {
		  System.out.println("Inside Function 1");
		  By container=By.xpath("//div[@class='demo-container size-narrow']");
		  WebDriverWait wait=new WebDriverWait(driver, 5);
		  wait.until(ExpectedConditions.presenceOfElementLocated(container));
		  //before
		  WebElement noselectedDatesText = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
		  String beforeAjaxCall = noselectedDatesText.getText().trim();
		  
		  //click on date
		  WebElement clickDate = driver.findElement(By.linkText("2"));
		  clickDate.click();
		  
		  //Wait till loader disappear
		  By loader = By.className("raDiv");
		  wait.until(ExpectedConditions.invisibilityOfElementLocated(loader));
		  
		  //after
		  WebElement selectedDatesText = driver.findElement(By.xpath("//div[@class='RadAjaxPanel']/span"));
		  String afterAjaxCall = selectedDatesText.getText().trim();
		  System.out.println(beforeAjaxCall+"    " +afterAjaxCall);
		  
		  //Clear dates
		  WebElement clear = driver.findElement(By.xpath("//button[@value='Clear Selected Dates']"));
		  clear.click();
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


}
