package com.lowLevel;

import java.io.IOException;

import jxl.read.biff.BiffException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.lowLevel.CommonMethods;
import com.pageObjectRepo.HomePage;
import com.pageObjectRepo.LobbyPage;


public class LoginMethods extends HomePage {
	
	public static String userName;
	public static String password;
	
	public static void InitilazeObjects()  {

		HomePage pageObject = PageFactory.initElements(CommonMethods.driver,HomePage.class);
		LobbyPage LobbypageObject = PageFactory.initElements(CommonMethods.driver, LobbyPage.class); 
	}
	
	
	/*public static void login() throws BiffException, IOException
	{
		
		CommonMethods.readTestData(0);
	//	System.out.println(CommonMethods.userName);
		CommonMethods.loginVlaidUser();
		
	//	System.out.println(CommonMethods.userName);
	//	CommonMethods.driver.findElement(By.id("username")).sendKeys("happy");
		loginName.sendKeys(CommonMethods.userName);
		loginPassword.sendKeys(CommonMethods.password);
		submitLogin.click();
	}*/
	
	
	public static void loginVlaidUser() throws BiffException, IOException
	{
		  CommonMethods.readTestData(0); 
		    for (int i = 1; i < CommonMethods.rows; i++) {
			userName = CommonMethods.sheet.getCell(0, i).getContents();
			System.out.println(userName);
			password = CommonMethods.sheet.getCell(1, i).getContents();
			System.out.println(password);
			
			//CommonMethods.driver.findElement(By.id("username")).sendKeys(userName);
			//CommonMethods.driver.findElement(By.id("loginPassword")).sendKeys(password);
			//submitLogin.click();
			
			System.out.println(loginName);
			loginName.sendKeys(userName);
			loginPassword.sendKeys(password);
			submitLogin.click();
		}
	}
	
	
	

}

	
	

