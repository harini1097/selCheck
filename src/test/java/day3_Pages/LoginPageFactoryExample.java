package day3_Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageFactoryExample {
	
	WebDriver driver;
	
	public LoginPageFactoryExample(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.NAME,using="userName")
	WebElement uname;
	
	@FindBy(how=How.NAME,using="password")
	WebElement password;
	
	@FindBy(how=How.NAME,using="login")
	WebElement signin;
	
	public void loginUser(String un,String pass)
	{
		uname.sendKeys(un);
		password.sendKeys(pass);
		signin.click();                                     
	}

}
