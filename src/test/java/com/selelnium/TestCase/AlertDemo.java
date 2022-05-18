package com.selelnium.TestCase;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selelnium.PageObject.LoginPage;
import com.selenium.utilites.ReadConfig;

public class AlertDemo extends BaseClass {
	@Test
	public void alert_check()
	{
		LoginPage lp=new LoginPage(driver);
		ReadConfig config = new ReadConfig();
		lp.setUserName(config.username());
		lp.setPassword(config.Password());
		lp.clickSubmit();
		if(isalertpresent())
		{
			System.out.println("Present");
			Assert.assertTrue(false);
		}
		else
		{
			System.out.println("Not Present");
			Assert.assertTrue(true);
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
