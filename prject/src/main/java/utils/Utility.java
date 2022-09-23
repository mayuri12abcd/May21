package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static void captureScreenShot(WebDriver driver,int testId) throws IOException
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("MM-dd-yyyy HH-mm-ss");
		LocalDateTime dateAndtime= LocalDateTime.now();
		String datetime =dtf.format(dateAndtime);	
		TakesScreenshot take= (TakesScreenshot) driver;
		File src= take.getScreenshotAs(OutputType.FILE);
		File dest =new File("E:\\Screenshot selenium\\test"+ testId+" "+datetime+".png");
		FileHandler.copy(src, dest);
		
	}
	public static String featchDatafromExcelSheet(String sheet,int row,int coloum) throws  IOException
	{
		String data;
		String path="C:\\Users\\DELL\\Desktop\\testcased.xlsx";
		FileInputStream file=new FileInputStream(path);
		data=WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(coloum).getStringCellValue();
		
		return data;
	}
	

}
	

