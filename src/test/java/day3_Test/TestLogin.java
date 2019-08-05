package day3_Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import day3_Pages.Login;
import day3_Utility.BrowserFactory;

public class TestLogin {
	
	WebDriver driver;
	String expectedResult="Find a Flight: Mercury Tours:";

	@Test
	public void f() {
		driver=BrowserFactory.startBrowser("chrome", "http://demoaut.com/");
		Login login=new Login(driver);
		login.loginUser("tutorial", "tutorial");
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.titleIs(expectedResult));
		Assert.assertEquals(expectedResult, driver.getTitle());
	}
}
