package Basic;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import CommonUtilas.BaseClass;
import CommonUtilas.ExcelUtils;
import CommonUtilas.JavaUtils;
import CommonUtilas.PropertFileUtils;
import CommonUtilas.WebDriverUtils;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationPage;

public class Createorgnizationtestng extends BaseClass{

	//public WebDriver driver;
	@Test
	
	public  void Organization () throws IOException, InterruptedException
	{
		
		
		PropertFileUtils futils = new PropertFileUtils();
		WebDriverUtils wutils = new WebDriverUtils();
		ExcelUtils eutils = new ExcelUtils();
		JavaUtils jutils = new JavaUtils();

		/*To read the data from property file */
		
		
		/* To read data from excel utils*/
		String OrgName = eutils.getDataFromExcelFile("Sheet1", 1, 0);
		String Group = eutils.getDataFromExcelFile("Sheet1", 1, 1);
		String Industry = eutils.getDataFromExcelFile("Sheet1", 1, 2);
				
        		
       

       
		
		Reporter.log("clicking organisation");

		driver.findElement(By.xpath("(//a[text()='Organizations'])[1]")).click();
		
		
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		
		//Enter account name
		driver.findElement(By.name("accountname")).sendKeys(OrgName + jutils.getrandomnumber());
		Reporter.log("Enter account organisation");

		//Dropdown webelement
		driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
		
		Thread.sleep(2000);
		WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
		//Handle dropdown by visible text
//		wutils.handledropdown(dropdown, Group);
		wutils.handledropdown(dropdown, 2);
		//dropdown webelement
		WebElement industrydropdown = driver.findElement(By.name("industry"));
		Reporter.log("clicking on industry name");

		//Handle dropdown by visible text
		wutils.handledropdown(industrydropdown, Industry);
		//checkbox
		WebElement box = driver.findElement(By.name("notify_owner"));
		//click on action on checkbox
		wutils.action(driver, box);
		//TO click on save
		//Admin image
		Thread.sleep(4000);
		Reporter.log("clicking on save button");

		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();//save button
		
		

	}

}
