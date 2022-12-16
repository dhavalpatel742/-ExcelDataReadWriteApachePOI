package com.excel.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.lib.util.Xls_Reader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement username = driver.findElement(By.id("email"));
		WebElement pwd = driver.findElement(By.id("pass"));
		
		Xls_Reader reader = new Xls_Reader("C:\\Selenium_Workspace\\ExcelDataReadWriteApachePOI\\src\\main\\java\\com\\excel\\lib\\util\\SampleExcel.xlsx");
		String sheetname = "login";
		
		int rowcount = reader.getRowCount(sheetname);
		
		for(int rownum=2; rownum<=rowcount; rownum++) {
			
			String loginid = reader.getCellData(sheetname, "username", rownum);
			String password = reader.getCellData(sheetname, "password", rownum);
			System.out.println("Loginid = "+loginid+"    "+"password = "+password);
			
			username.clear();
			username.sendKeys(loginid);
			pwd.clear();
			pwd.sendKeys(password);
				
		}
				

	}

}
