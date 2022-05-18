package com.selelnium.TestCase;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.selenium.utilites.ReadConfig;

public class BaseClass {
	ReadConfig readconfig= new ReadConfig();
	public String baseURL=readconfig.ApplicationUrl();
	public String username=readconfig.username();
	public String password=readconfig.Password();
	public static WebDriver driver;
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{			
		if (br.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Driverr\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (br.equals("Firefox"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Driverr\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		if (br.equals("IE"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Driverr\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		driver.get("http://demo.guru99.com/v4/index.php");
			
	}
	@AfterClass
	public void Teardown()
	{
		driver.close();
	}
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	
}
	