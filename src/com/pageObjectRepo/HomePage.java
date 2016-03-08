package com.pageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {
	
	@FindBy(id="username")
	public static WebElement loginName;
	
	@FindBy(id="loginPassword")
	public static WebElement loginPassword;
	
	@FindBy(xpath=".//*[@id='loginForm']/div/input")
	public static WebElement submitLogin;

}
