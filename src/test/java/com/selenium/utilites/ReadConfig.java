package com.selenium.utilites;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()
	{
		File src= new File("./Configuration/config.properties");
		try
		{
			FileInputStream fin = new FileInputStream(src);
			pro =new Properties();
			pro.load(fin);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
	public String ApplicationUrl()
	{
		return pro.getProperty("baseUrl");
	}
	public String username()
	{
		return pro.getProperty("username");
	}
	public String Password()
	{
		return pro.getProperty("password");
	}

}
