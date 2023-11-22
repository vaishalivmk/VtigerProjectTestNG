package CommonUtilas;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClass 
{
	//public WebDriver driver;
	
 	PropertFileUtils futils = new PropertFileUtils();
	WebDriverUtils wutils = new WebDriverUtils();
	ExcelUtils eutils = new ExcelUtils();
	JavaUtils jutils = new JavaUtils();

	public WebDriver driver;

	@BeforeSuite
	public void BSconfig() {
		Reporter.log("--connect to database--",true);
    }
	@BeforeClass
	public void BCconfig() throws IOException {
		String BROWSER=futils.getDataFromPropertyFile("browser");
		String URL=futils.getDataFromPropertyFile("url");
		
		 if(BROWSER.equalsIgnoreCase("chrome")) {
	        	driver = new ChromeDriver();
	        	
	        }else if(BROWSER.equalsIgnoreCase("Edge")) {
	        	driver = new EdgeDriver();
	        	
	        }else {
	        	driver = new FirefoxDriver();
	        }
	        //To Launch url
		    driver.get(URL);
		    //To maximize window
	        wutils.maximize(driver);
	        //To apply implicit wait
	        wutils.implicitwait(driver);

		
	}
	@BeforeMethod
    public void BMconfig() throws IOException {
		String USERNAME=futils.getDataFromPropertyFile("username");
		String PASSWORD=futils.getDataFromPropertyFile("password");
		
		 driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		 driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		 driver.findElement(By.id("submitButton")).click();
	}
	@AfterMethod
	public void AMconfig() throws InterruptedException {
	Thread.sleep(4000);

	WebElement image = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
        
	 wutils.mousehover(driver, image);
	 Thread.sleep(4000);
			
	 driver.findElement(By.xpath("//a[text()='Sign Out']")).click();//sign out 

	}
	@AfterClass
	public void ACconfig() {
		driver.close();
	}
	@AfterSuite
	public void ASconfig() {
		//System.out.println("Disconnect to data base");
		Reporter.log("--Disconnet to data base--",true);

}
}
