package day2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class ReadFromExcel {
	
	 static WebDriver driver;
	  static String expectedResult="Sign-on: Mercury Tours";

	 @BeforeClass
	  public void beforeClass() {
		  System.out.println("Inside before class");
		  System.setProperty("webdriver.chrome.driver", "C:\\Suganya_Devops\\chromedriver.exe");
		  driver=new ChromeDriver();
		  driver.get("http://demoaut.com/");
	  }
	
	@Test
	public static void readData() throws IOException
	{
		File src=new File("C://Users//Training_c2d.02.11//MyWorkspace//selenium//SeleniumAdvancedConcept//testData.xlsx");
		
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(0);
		/*String data0= sheet1.getRow(0).getCell(0).getStringCellValue();
		String data1= sheet1.getRow(0).getCell(1).getStringCellValue();*/
		
		/*driver.findElement(By.name("userName")).sendKeys(data0);
		driver.findElement(By.name("password")).sendKeys(data1);
		driver.findElement(By.name("login")).click();
		  
		WebDriverWait wait=new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.titleIs(expectedResult)); //wait till the title get changed to next page
	    Assert.assertEquals(expectedResult, driver.getTitle());*/
	    
	  //For reading the entire excel
		//int rownum=sheet1.getLastRowNum();
	    int rownum = sheet1.getLastRowNum()-sheet1.getFirstRowNum();

		System.out.println(rownum);
		int column=sheet1.getRow(0).getLastCellNum();
		System.out.println(column);
		String userName = null;
		String password=null;
		for(int i=0;i<=rownum;i++)
		{
			Row row = sheet1.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++)
			{
				userName= sheet1.getRow(i).getCell(0).getStringCellValue();
			    password= sheet1.getRow(i).getCell(1).getStringCellValue();
				driver.findElement(By.name("userName")).clear();
				driver.findElement(By.name("userName")).sendKeys(userName);
				driver.findElement(By.name("password")).clear();
				driver.findElement(By.name("password")).sendKeys(password);
				driver.findElement(By.name("login")).click();
				  
				WebDriverWait wait1=new WebDriverWait(driver, 30);
			    wait1.until(ExpectedConditions.titleIs(expectedResult)); //wait till the title get changed to next page
			    Assert.assertEquals(expectedResult, driver.getTitle());
			    
			    if(expectedResult.equals(driver.getTitle()))
			    {
			    	sheet1.getRow(i).createCell(2).setCellValue("pass");
			    }
			    else
			    {
			    	sheet1.getRow(i).createCell(2).setCellValue("fail");
			    }
			    
			    FileOutputStream fo=new FileOutputStream(src);
			    wb.write(fo);
			}
			
		    
			driver.navigate().back();
			System.out.println(userName + " " + password);
		}
	  
	    
		wb.close();
	}

	@AfterClass
	  public void afterClass() {
		  System.out.println("Inside after class");
		  driver.close();
	  }

}
