package com.yatra.webPages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.yatra.baseClass.PageBaseClass;
import com.yatra.pageObjects.PageLocators;


public class LogInPage extends PageBaseClass {
	PageLocators pageLocator;
	public LogInPage(WebDriver driver) {
		PageBaseClass.driver = driver;
		pageLocator= new PageLocators(driver);
		PageFactory.initElements(driver, pageLocator);
	}

	public HomePage clickLoginExisting() {
		propLoad();
		
		pageTitle("Yatra Account");
		
		logger.log(Status.INFO, "Entering Email Address");	
		enterText(PageLocators.email, "username");
		elementClick(PageLocators.continueBtn,"Continue Button Clicked");
		waitPageLoad();
		
		logger.log(Status.INFO, "Entering Password");
		enterText(PageLocators.password, "password");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementClick(PageLocators.loginBtn,"Login Button Clicked");
		logger.log(Status.PASS, "Signin Successful");
		
		return PageFactory.initElements(driver, HomePage.class);

	}
}
