package com.selenium.utilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class XLUtils {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet xs;
	public static XSSFRow rw;
	public static XSSFCell cell;

	
	public static int getRowCount(String path, String sheetname) throws FileNotFoundException, IOException
	{
		
		wb = new XSSFWorkbook(new FileInputStream(path));
		xs = wb.getSheet(sheetname);
		int rowcount = xs.getLastRowNum();
		System.out.println(rowcount);
		wb.close();
		return rowcount;
		
				
	}
	public static int getCellCount(String path, String sheetname) throws FileNotFoundException, IOException
	{
		
		wb = new XSSFWorkbook(new FileInputStream(path));
		xs = wb.getSheet(sheetname);
		rw = xs.getRow(1);
		int cellCount = rw.getLastCellNum();
		wb.close();
		return cellCount;		
	}
	public static String getCellValue(String path, String sheetname, int rnumber, int cnumber) throws FileNotFoundException, IOException
	{
		
		wb = new XSSFWorkbook(new FileInputStream(path));
		xs = wb.getSheet(sheetname);
		rw = xs.getRow(rnumber);
		cell=rw.getCell(cnumber);
		String data;
		try 
		{
			DataFormatter formatter = new DataFormatter();
            String cellData = formatter.formatCellValue(cell);
            return cellData;
		}
		catch (Exception e) 
		{
			data="";
		}
		wb.close();
		
		return data;
			
	}

}
