package com.highLevel;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.lowLevel.CommonMethods;
import com.lowLevel.LoginMethods;
import com.pageObjectRepo.LobbyPage;

public class LoginWR {


	@BeforeMethod
	public void beforeClass() throws IOException {
		//GeneralMethods.getBrowser();
				CommonMethods.openBrowser();
				LoginMethods.InitilazeObjects();
	}
	
	@Test
	public void testloginIntoRummy() throws BiffException, IOException
	{
		LoginMethods.loginVlaidUser();
		System.out.println(LobbyPage.introStartClose);
		
		LobbyPage.introStartClose.click();
		LobbyPage.fancyBoxClose.click();
		Assert.assertEquals("Welcome, happy1302", CommonMethods.driver.findElement(By.xpath(".//*[@id='playerBadge']/li[1]")).getText());
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		
	}
	
}
 