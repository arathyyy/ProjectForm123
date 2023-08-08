package testpkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import basepkg.Baseclass;
import pagepkg.Loginandselect;
import utilitypkg.Utilis;

public class LoginNselctest extends Baseclass{
	@Test(priority=1)
	public void loginCred() throws InterruptedException, IOException
	{
	Loginandselect nw=new Loginandselect(driver);
	String xl="C:\\Users\\WINTECH\\Desktop\\Book3.xlsx";
	String sheet="Sheet1";
	int rowCount=Utilis.getRowCount(xl, sheet);
	for(int i=1;i<rowCount;i++) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		String username=Utilis.getCellValue(xl, sheet, i, 0);
		System.out.println("username--"+username);
		String password=Utilis.getCellValue(xl, sheet, i, 1);
		System.out.println("password--"+password);
		nw.setValues(username, password);
		String expurl="https://app.123formbuilder.com/index.php?p=your_forms";
		String actualurl=driver.getCurrentUrl();
		if(actualurl.equalsIgnoreCase(expurl))
		{
			System.out.println("Login successfull!!");
			
		}
		else
		{
			System.out.println("Login  failed!!");
		
		}
	}
		driver.navigate().refresh();
		nw.setValues("fortestingsand123@gmail.com", "luminartechnolabs");
		nw.logClick();
		
		String title=driver.getTitle();
		System.out.println("Title--"+title);
		System.out.println("logo of thr page is displayed");
		
		
		
		
		// nw.viewForms();
		
		
	}
	
	
	@Test(priority=2)
	public void formSelect()
	{
		 Loginandselect nw=new Loginandselect(driver);
		nw.nwForms();
		nw.publishForm();
		
		//driver.navigate().back();
		nw.sortform();
	
	}
	@Test(priority=3)
	public void formFilSubmit() throws InterruptedException, IOException
	{
		
		Loginandselect nw=new Loginandselect(driver);
		nw.fstCpy("Arathy", "S", "abc@gmail.com", "9874563210","through newspaper");
		System.out.println("form submitted sucessfully!!");
		nw.viewForms();
		System.out.println("Form veiwed sucessfully!!");
	}
	@Test(priority=4)
	public void linkValidtn()
	{
		Loginandselect nw=new Loginandselect(driver);
		 Utilis.linkValidation(driver);
		 nw.linkvalid();
		 driver.navigate().back();
		 driver.navigate().back();
		 System.out.println("Link validation completed");
		
	}
	@Test(priority=5)
	public void delForm() throws InterruptedException
	{
		Loginandselect nw=new Loginandselect(driver);
		 nw.delForm();
	}
		 @Test(priority=6)
		 public void test2()
		 {
			 Loginandselect nw=new Loginandselect(driver);
			 nw.logout();
			 System.out.println("logged out sucessfully!!!");
			 
		 }
		
		

	
	
	


		
	}

