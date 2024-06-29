package com.company.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


import com.company.testbase.TestBase;

public class Util extends TestBase {
	

	
	public static final Duration ImplicitWait =Duration.ofMillis(30000) ;
	public static Duration pageLoadTimeout=Duration.ofMillis(30000);
	
	
	WebDriver driver;

	public Util(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public Object[][] readExcel() throws IOException 
	{XSSFWorkbook workbook = null;
	FileInputStream fis = null;
		try {
		 fis=new FileInputStream("C:\\Users\\sarit\\OneDrive\\Desktop\\Rooca_TestData_Phase1_EU_Test_1.Xlsx");
		 workbook=new XSSFWorkbook(fis);
		XSSFSheet sheet=workbook.getSheet("Incidents");
		int row=sheet.getPhysicalNumberOfRows();
		int column=sheet.getRow(0).getLastCellNum();
		DataFormatter formatter=new DataFormatter();
		
		Object[][] data=new Object[row-1][column];
		
		for(int i=0;i<row-1;i++)
		{
			
			for(int j=0;j<column;j++)
			{
			XSSFCell cell=	sheet.getRow(i+1).getCell(j);
			//System.out.println(formatter.formatCellValue(cell));
			data[i][j]=formatter.formatCellValue(cell);
			}
		}
		return data;

		}
		finally {
			if(workbook !=null)
			{
				workbook.close();
			}
			
			if(fis !=null)
			{
				
				fis.close();
			}
		}
		
		
		
	}
	
public WebDriverWait expliciwait() {
	WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(3000));
	return wait;
}
	
}
