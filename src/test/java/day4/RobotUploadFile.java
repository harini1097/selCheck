package day4;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RobotUploadFile {
 
	WebDriver driver;
	
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside before class");
		  System.setProperty("webdriver.chrome.driver", "C:\\Suganya_Devops\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("file:///C:/Users/Training_c2d.02.11/MyWorkspace/selenium/SeleniumAdvancedConcept/fileUpload.html");
	  }
	  
	  @Test()
	  public void uploadFile() throws AWTException
	  {
		  Robot robot=new Robot();
		  
		  driver.findElement(By.id("1")).click();
		  robot.setAutoDelay(1000);
		  
		  String path="C:\\Users\\Training_c2d.02.11\\MyWorkspace\\selenium\\SeleniumAdvancedConcept\\testupload.docx";
		  StringSelection sel=new StringSelection(path);
		  //copy to clipboard
		  Toolkit.getDefaultToolkit().getSystemClipboard().setContents(sel, null);
		  
		  robot.setAutoDelay(1000);
		  robot.keyPress(KeyEvent.VK_CONTROL);
		  robot.keyPress(KeyEvent.VK_V);
		  
		  robot.keyRelease(KeyEvent.VK_CONTROL);
		  robot.keyRelease(KeyEvent.VK_V);
		  
		  robot.setAutoDelay(1000);
		  robot.keyPress(KeyEvent.VK_ENTER);
		  robot.keyRelease(KeyEvent.VK_ENTER);
		  
		  
	  }
	  
}
