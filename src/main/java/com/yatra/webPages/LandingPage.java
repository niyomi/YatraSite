package com.yatra.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.yatra.baseClass.PageBaseClass;
import com.yatra.webPages.LogInPage;

public class LandingPage extends PageBaseClass {	

	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public LogInPage clickLogin() {
		elementClick("myAccountDropDown_Xpath");
		elementClick("logInButton_Xpath");
		/*Actions builder = new Actions(driver);
		builder.moveToElement(getElement("signInBtn_Xpath")).build().perform();*/
		return PageFactory.initElements(driver, LogInPage.class);
	

}
}