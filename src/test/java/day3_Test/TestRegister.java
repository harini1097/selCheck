package day3_Test;

import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import day3_Pages.LoginPageFactoryExample;
import day3_Pages.Register;
import day3_Utility.BrowserFactory;

public class TestRegister {
	WebDriver driver;
	String expectedResult="Find a Flight: Mercury Tours:";

	@Test
	public void f() throws IOException {
		driver=BrowserFactory.startBrowser("chrome", "http://demoaut.com/");
		Register register=PageFactory.initElements(driver, Register.class);
		File src=new File("C://Users//Training_c2d.02.11//MyWorkspace//selenium//SeleniumAdvancedConcept//testData.xlsx");
		
		ArrayList<String> list=new ArrayList<String>();
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet1=wb.getSheetAt(1);
		int rownum = sheet1.getLastRowNum()-sheet1.getFirstRowNum();
		int column=sheet1.getRow(0).getLastCellNum();
		
		for(int i=0;i<=rownum;i++)
		{
			for(int j=0;j<column;j++)
			{
				String details= sheet1.getRow(i).getCell(j).getStringCellValue();
				list.add(details);
			}
		}
		System.out.println(list);
		register.registerLinkClk();
		register.enterDetails(list,rownum,sheet1);
		
		wb.close();
		
	}
}
