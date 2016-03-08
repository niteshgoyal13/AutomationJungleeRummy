package com.pageObjectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LobbyPage {
	
	@FindBy(id= "intro_start_close")
	public static WebElement introStartClose;
	
	@FindBy(id= "fancybox-close")
	public static WebElement fancyBoxClose;
	


}
