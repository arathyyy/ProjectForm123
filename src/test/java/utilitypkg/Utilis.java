package utilitypkg;

import java.io.FileInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Utilis {
	public static String getCellValue(String xl,String sheet,int r,int c)
	{
		try {
			FileInputStream fp=new FileInputStream(xl);
			XSSFWorkbook wb=new XSSFWorkbook(fp);
			XSSFCell cell=wb.getSheet(sheet).getRow(r).getCell(c);
			if(cell.getCellType()==CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else
			{
				double v=cell.getNumericCellValue();
				int val=(int)v;
				return String.valueOf(val);
				
				
			}
			
			
		}
		catch(Exception e)
		{
			return "";
		}
			
		
		
	}
	
	public static int getRowCount(String xl,String sheet)
	{
	try {
		FileInputStream fp= new FileInputStream(xl);
				XSSFWorkbook wb=new XSSFWorkbook(fp);
		return wb.getSheet(sheet).getLastRowNum();
		
	}
	catch(Exception e) {
		return 0;
	}
	}
	
public static void linkValidation(WebDriver driver) {
		
		{
			List<WebElement> li=driver.findElements(By.tagName("a"));
			System.out.println("Number of links--"+li.size());
			for(WebElement element:li)
			{
				String link=element.getAttribute("href");
				verify(link);
			}
			
		}
	}

	private static void verify(String link) {
		try {
			URL u=new URL(link);
			HttpURLConnection con=(HttpURLConnection)u.openConnection();
			con.connect();
			if(con.getResponseCode()==200)
			{
				System.out.println("links with suscessfull responses--"+link);
			}
			else if(con.getResponseCode()==404)
			{
				System.out.println("links with client error--"+link);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	

}
