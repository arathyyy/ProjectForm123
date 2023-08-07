package basepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

public class Baseclass {
	public WebDriver driver;
	@BeforeClass
	public void setUp()
	{
		driver =new ChromeDriver();
		//driver.get("https://www.123formbuilder.com/free-form-templates/gallery-registration/");
		driver.get("https://app.123formbuilder.com/index.php?p=login");
		driver.manage().window().maximize();
		
		
	}

}
