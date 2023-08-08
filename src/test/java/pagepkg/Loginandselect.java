package pagepkg;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

//import utilitypkg.Utilis;

public class Loginandselect {
	WebDriver driver;
	//By log=By.xpath("//*[@id=\"menu-item-424\"]/a");
	By usname=By.name("username");
	By pswd=By.name("password");
	By logos = By.xpath("//*[@id=\"headerV3\"]/div/div[2]/div/div[1]/a/img");
	By loginbut=By.id("submit-form-button");
	By nwform=By.xpath("//*[@id=\"headerV3\"]/div/div[3]/button");
	By temp=By.xpath("//*[@id=\"qa_online_event_registration\"]");
	By publish =By.xpath("//*[@id=\"publish-form-button\"]");
	By sortn=By.xpath("//*[@id=\"headerV3\"]/div/div[5]/ul/li/div/span");  
	By srtbyname=By.xpath("//*[@id=\"headerV3\"]/div/div[5]/ul/li/ul/li[2]/div/span[2]");   
	By srtbynme1=By.xpath("//*[@id=\"headerV3\"]/div/div[5]/ul/li/ul/li[2]/ul/li[4]/div/span[2]");
	By fstcpy=By.xpath("//*[@id=\"view\"]/div[5]/div[3]/button[2]/span"); 
	By viewcpy=By.xpath("//*[@id=\"view-row-context-menu\"]/div[1]"); 
	By fname=By.xpath("//*[@id=\"form\"]/div[1]/div[2]/div[3]/div/div/input[1]"); 
	By lname=By.xpath("//*[@id=\"form\"]/div[1]/div[2]/div[3]/div/div/input[2]");
	By email=By.xpath("//*[@id=\"form\"]/div[1]/div[2]/div[4]/div[1]/div/input");  
	By phone=By.xpath("//*[@id=\"form\"]/div[1]/div[2]/div[4]/div[2]/div/input");
	By friendnum=By.xpath("//*[@id=\"form\"]/div[1]/div[2]/div[5]/div/div/div/select");
	By texts=By.xpath("//*[@id=\"textarea-00000024\"]");  
	By button=By.xpath("//*[@id=\"radio-0000001a0\"]/label"); 
	By reg=By.xpath("//*[@id=\"form\"]/div[1]/div[4]/div/button/span[1]");
	By veiwfrm=By.xpath("//*[@id=\"view\"]/div[5]/div[2]/div");
	By filledfrm=By.xpath("//*[@id=\"1777\"]/td[1]/div");
	By iframefld=By.xpath("//*[@id=\"_hjSafeContext_50979614\"]");
	By clsfldfrm=By.xpath("//*[@id=\"popup_cancellink\"]");
	By delfrm1=By.xpath("//*[@id=\"view\"]/div[7]/div[3]/button[2]");
	By delfrm2=By.xpath("//*[@id=\"view-row-context-menu\"]/div[16]");
	By delfrm3=By.xpath("/html/body/div[21]/div/div[3]/button[1]");
	By logout1=By.xpath("//*[@id=\"headerV3\"]/div/div[2]/div/ul[2]/li[3]/div");
	By logout2=By.xpath("//*[@id=\"headerV3\"]/div/div[2]/div/ul[2]/li[3]/ul/li[8]/div");
	
	
	
	public Loginandselect(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void setValues(String un,String pwd)
	{
		
		driver.findElement(usname).clear();
		driver.findElement(usname).sendKeys(un);
		driver.findElement(pswd).sendKeys(pwd);
		
	}
	public void logClick()
	{
		driver.findElement(loginbut).click();
		
		System.out.println("sucessfully logged in!!!");
		driver.findElement(logos).isDisplayed();

	}
	public void nwForms()
	{
		driver.findElement(nwform).click();
		driver.findElement(temp).click();
		
	}
	public void publishForm()
	{
		try {
		driver.findElement(publish).click();
		driver.navigate().refresh();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}
	public void sortform()
	{
		driver.findElement(sortn).click();
		driver.findElement(srtbyname).click();
		driver.findElement(srtbynme1).click();
		System.out.println("Forms are sorted based on alphabetical order");
	}
	public void fstCpy(String nm1,String nm2,String mail,String ph,String eventinfo) throws InterruptedException
	{
		driver.findElement(fstcpy).click();
		String parentwindow=driver.getWindowHandle();
		driver.findElement(viewcpy).click();
		Set<String>allwindowhandles=driver.getWindowHandles();
		for(String handle:allwindowhandles) {
			if(!handle.equalsIgnoreCase(parentwindow)) {
				driver.switchTo().window(handle);
				driver.findElement(fname).sendKeys(nm1);
				driver.findElement(lname).sendKeys(nm2);
				JavascriptExecutor jse=(JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0, 2000)");
				driver.findElement(email).sendKeys(mail);
				driver.findElement(phone).sendKeys(ph);
				jse.executeScript("window.scrollBy(0, 1500)");
				WebElement frndnum=driver.findElement(friendnum);
				Select number=new Select(frndnum);
				number.selectByValue("2");
				jse.executeScript("window.scrollBy(0, 1500)");
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
				driver.findElement(texts).sendKeys(eventinfo);
				jse.executeScript("window.scrollBy(0,800)");
				driver.findElement(button).isDisplayed();
				jse.executeScript("window.scrollBy(0,1500)");
				WebElement element= driver.findElement(reg);
				jse.executeScript("arguments[0].scrollIntoView(true);", element);
				element.click();
				Thread.sleep(10000);
				String txtmessage=driver.getPageSource();
				if(txtmessage.contains("Your message has been sent. Thank you for filling out our form!"))
				{
				   System.out.println(" form filling completed with message -Your message has been sent. Thank you for filling out our form!");
				}
				
				driver.close();
				}
			driver.switchTo().window(parentwindow);
		}
		
	}
		public void viewForms() throws IOException
		{
			driver.findElement(veiwfrm).click();
			
			driver.findElement(filledfrm).click();
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileHandler.copy(src, new File("./Screenshot//formfilled.png"));
			System.out.println("screenshot taken successfully.");
			driver.navigate().refresh();
			driver.navigate().back();
		   
		 }
		public void linkvalid()
		{
			WebElement hm=driver.findElement(nwform);
			hm.click();
			
		}
		public void delForm() throws InterruptedException
		{
			driver.findElement(delfrm1).click();
			driver.findElement(delfrm2).click();
			 Thread.sleep(1000);
			driver.navigate().refresh();
		}
		public void logout()
		{
			driver.findElement(logout1).click();
			driver.findElement(logout2).click();
			}
		
		
		
	
	
	
	
	
	
	
	
	
	

}
