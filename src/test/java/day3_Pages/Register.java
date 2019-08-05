package day3_Pages;

import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Register {

	WebDriver driver;
	
	public Register(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(how=How.XPATH,using="//a[contains(text(),'REGISTER')]")
	WebElement registerClk;
	
	@FindBy(how=How.XPATH,using="//input[@name='firstName']")
	WebElement firstNameTxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='lastName']")
	WebElement lastNameTxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='phone']")
	WebElement phoneTxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@id='userName']")
	WebElement emailTxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='address1']")
	WebElement address1TxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='address2']")
	WebElement address2TxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='city']")
	WebElement cityTxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='state']")
	WebElement stateTxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='postalCode']")
	WebElement postalCodeTxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='country']")
	WebElement countrydrpBox;
	
	@FindBy(how=How.XPATH,using="//input[@id='email']")
	WebElement userNameTxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='password']")
	WebElement passwordTxtBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='confirmPassword']")
	WebElement confirmPassTxtBox;
	
	
	public void registerLinkClk()
	{
		registerClk.click();
	}

	public void enterDetails(ArrayList<String> list,int rownum,XSSFSheet sheet1) {
		// TODO Auto-generated method stub
		int size=list.size();
		
		for(int i=0;i<size;i++)
		{
			firstNameTxtBox.sendKeys(list.get(i));
			lastNameTxtBox.sendKeys(list.get(i+1));
		}
	}
}
