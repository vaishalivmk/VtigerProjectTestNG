package POM;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CommonUtilas.BaseClass;
import CommonUtilas.BaseClass1;
import CommonUtilas.ExcelUtils;
import CommonUtilas.JavaUtils;
import CommonUtilas.PropertFileUtils;
import CommonUtilas.WebDriverUtils;

public class CreateContactPOMTestNG extends BaseClass1 {

	@Test
	
	public  void Contactpom() throws InterruptedException, IOException
	{
		
		
		  PropertFileUtils futils = new PropertFileUtils();
		  WebDriverUtils wutils = new WebDriverUtils();
		  ExcelUtils eutils = new ExcelUtils();
		  
		  // TO READ DATA FORM PROPERTY FILE
		  
		
		  
		  // TO READ DATA FROM EXEL FILE
		   String firstname = eutils.getDataFromExcelFile("Sheet1", 1, 3);   
		   String lastname = eutils.getDataFromExcelFile("Sheet1", 1, 4);   
		   String Drop = eutils.getDataFromExcelFile("Sheet1",1,2);
		   //String OrgName = eutils.getDataFromExcelFile("Sheet1",1,2);
		   String PARENTURL = eutils.getDataFromExcelFile("Sheet1", 1, 5);
		   String CHILDURL = eutils.getDataFromExcelFile("Sheet1", 4, 5);
		   
		  
			
			//homepagecontact hp = new homepagecontact();
			HomePage hp= new HomePage();
			PageFactory.initElements(driver, hp);
			hp.getContactlink().click();
	        hp.getCreateContactlink().click();
	        
	        ContactPage cont = new ContactPage();
	        PageFactory.initElements(driver, cont);
	     	cont.getFirstname().sendKeys(firstname);
	     	cont.getLastnametf().sendKeys(lastname);
	     	
	     	Set<String> ids = driver .getWindowHandles();
			System.out.println(ids);
			
//			cont.getAssignnedtobtn().click();
//			cont.getContactPlusbtn().click();
//			
			//to transfer control from parent to child
			
	        wutils.switchtowindow(driver,CHILDURL);
//            cont.getSearchbtn().sendKeys(OrgName);
//            cont.getSearchbtn().click();
       	    Thread.sleep(4000);

			//to transfer control from child to parent

	        wutils.switchtowindow(driver,PARENTURL);
	        PageFactory.initElements(driver, cont);

	        cont.getAssignnedtobtn().click();
       	   // wutils.handledropdown(cont.getAssignedtodropdowm(),Drop );
       	    Thread.sleep(4000);

//			
		        	  Thread.sleep(4000);
		        	  cont.getSavebtn().click(); 
		        	  wutils.mousehover(driver,cont.getImagebtn());
		        	  cont.getContactSignoutbtn().click();
		        	  
		          }
			

		// TODO Auto-generated method stub

	

}
