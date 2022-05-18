package com.selelnium.TestCase;


import java.io.IOException;
import com.selenium.utilites.ReadConfig;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.selelnium.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	@Test
	public void loginTest() throws IOException 
	{
		LoginPage lp=new LoginPage(driver);
		ReadConfig config = new ReadConfig();
		lp.setUserName(config.username());
		
		lp.setPassword(config.Password());
		
		lp.clickSubmit();
		if(isalertpresent())
			Loginverify();
		else 
			Loginverify();
	}
	
	public void Loginverify() throws IOException 
	{
		if(driver.getTitle().equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			
		}
		else
		{
			captureScreen(driver,"Loginerror");
			Assert.assertTrue(false);
			
		}
	}
	
	public boolean isalertpresent()
	{
		try
		{
		    Alert alert= driver.switchTo().alert();
		    alert.accept();
		    return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
		
	}
}

