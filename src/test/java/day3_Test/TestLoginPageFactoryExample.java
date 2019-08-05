package day3_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import day3_Pages.LoginPageFactoryExample;
import day3_Utility.BrowserFactory;

public class TestLoginPageFactoryExample {
  
	WebDriver driver;
	String expectedResult="Find a Flight: Mercury Tours:";

	@Test
	public void f() {
		driver=BrowserFactory.startBrowser("chrome", "http://demoaut.com/");
		LoginPageFactoryExample loginPageFactoryExample=PageFactory.initElements(driver, LoginPageFactoryExample.class);
		loginPageFactoryExample.loginUser("tutorial", "tutorial");
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs(expectedResult));
		Assert.assertEquals(expectedResult, driver.getTitle());
	}
}
