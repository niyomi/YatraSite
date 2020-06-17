package com.yatra.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.yatra.baseClass.PageBaseClass;
import com.yatra.pageObjects.PageLocators;
import com.yatra.webPages.LogInPage;

public class LandingPage extends PageBaseClass {	
	PageLocators pageLocator;
	public LandingPage(WebDriver driver)
	{
		PageBaseClass.driver = driver;
		pageLocator= new PageLocators(driver);
		PageFactory.initElements(driver, pageLocator);
	}
	
	public LogInPage clickLogin() {
		
		pageTitle("Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com");
		
		elementClick(PageLocators.MyAccountmyAccountDropDown,"My Account DropDown Clicked");
		elementClick(PageLocators.logInButton,"My account Login Button Clicked");
		
		return PageFactory.initElements(driver, LogInPage.class);
	}
}