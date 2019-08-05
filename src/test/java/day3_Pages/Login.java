package day3_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;
	By userName=By.name("userName");
	By password=By.name("password");
	By signin=By.name("login");
	
	public Login(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void loginUser(String un,String pass)
	{
		driver.findElement(userName).sendKeys(un);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signin).click();                                     
	}

}
