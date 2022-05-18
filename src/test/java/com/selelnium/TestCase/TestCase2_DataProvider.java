package com.selelnium.TestCase;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selelnium.PageObject.LoginPage;
import com.selenium.utilites.XLUtils;


public class TestCase2_DataProvider extends BaseClass {
	@Test(dataProvider="getdata")
	public void loginDDT(String user,String pwd) throws InterruptedException
	{

		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(user);
		lp.setPassword(pwd);
		lp.clickSubmit();
		Thread.sleep(3000);
		if(isAlertPresent()==true)
		{
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
		}
		else
		{
			Assert.assertTrue(true);
			lp.clickLogout();
			Thread.sleep(3000);
			driver.switchTo().alert().accept();//close logout alert
			driver.switchTo().defaultContent();
			
		}
		
		
	}
	
	
	public boolean isAlertPresent() //user defined method created to check alert is presetn or not
	{
		try
		{
		driver.switchTo().alert();
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
	
	@DataProvider(name="getdata")
	String[][] rowcount() throws FileNotFoundException, IOException
	{
		String path="C:/Users/SUMIT/eclipse-workspace/com.ishu/src/test/java/com/selelnium/TestData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int CellCount = XLUtils.getCellCount(path, "Sheet1");
		System.out.println(rownum+ " " +CellCount);
		String [][]data= new String[rownum] [CellCount];
		for (int i=0;i<rownum;i++)
		{
			for(int j=0;j<CellCount;j++)
			{
				data[i][j] = XLUtils.getCellValue(path, "Sheet1", i+1, j);
			}
		}
		return data;	
		
	}
	 

}
