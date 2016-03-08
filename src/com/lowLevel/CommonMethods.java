package com.lowLevel;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.pageObjectRepo.HomePage;



public class CommonMethods {

	public static Workbook wb;
	public static Sheet sheet;
	public static FileInputStream fs;
	public static WebDriver driver;	
	static int rows;
	static int columns;
	
	
	

	//Select the browser 
	public static WebDriver getBrowser() throws IOException {
	  	  FileReader reader = new FileReader("../JungleeGamesAutomation/config.properties"); //Reading configuration file
	  	  Properties prop = new Properties();
	  	  prop.load(reader);
	  	  
	  	  String browser = prop.getProperty("browserName"); // Assigning String value form configuraion file
	  	  //String ver = prop.getProperty("version");        // Assigning String value form configuraion file

	  	    if(browser.equalsIgnoreCase("IE"))
	  	    {
	  	     //String path=System.getProperty("user.dir") +File.separator + "Browsers"+ File.separator +"IEDriverServer.exe";
	  	        System.setProperty("webdriver.ie.driver", "../JungleeGamesAutomation/webdrivers/IEDriverServer.exe"); // setting path of the IEDriver
	  	        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
	  	           ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
	  	             driver = new InternetExplorerDriver(ieCapabilities);       
	  	    }
	  	     else if(browser.equalsIgnoreCase("firefox")){
	  	    	 driver = new FirefoxDriver();
	  	      }
	  	      else if(browser.equalsIgnoreCase("chrome")){
	  	            //String path=System.getProperty("user.dir") +File.separator + "Browsers"+ File.separator +"chromedriver.exe";
	  	            //System.out.println(path);
	  	            System.setProperty("webdriver.chrome.driver", "../chromedriver.exe"); // setting path of the ChromeDriver
	  	            driver = new ChromeDriver();
	  	           }
	  	   return driver;    
	  	  }
	
	//Get url from properties file
		public static void openURL() throws IOException
		{
			FileReader reader = new FileReader("../JungleeGamesAutomation/config.properties"); 
		  	Properties prop = new Properties();
		  	prop.load(reader);    	  
		  	String appServer = prop.getProperty("url");
		  	System.out.println(appServer);
		  	callingImplicitSleep();
	        driver.get(appServer); 
	    }
	
	//Maximize window
	public static void windowMax() {
	    driver.manage().window().maximize();

	}
	
	//Delete cookies    
	public static void deletecookies() {
		driver.manage().deleteAllCookies();
	}

   //Implicit wait
	public static void callingImplicitSleep(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	    
	
	
	//Test data- Sheet number 
	public static void readTestData(int sheetNumber) throws BiffException, IOException
	{
			
		    fs = new FileInputStream("../JungleeGamesAutomation/test-data/Web_TestData.xls");
			wb = Workbook.getWorkbook(fs);
			sheet = wb.getSheet(sheetNumber);
			rows = sheet.getRows();
			columns = sheet.getColumns();
		//	System.out.println(rows);
		//	System.out.println(columns);
	}
	
	

	public static void openBrowser() throws IOException
	{
		CommonMethods.getBrowser();
		CommonMethods.windowMax();
		CommonMethods.deletecookies();
		CommonMethods.openURL();
		CommonMethods.callingImplicitSleep();
	}
	
	
}
