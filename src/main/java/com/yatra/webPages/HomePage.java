package com.yatra.webPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.yatra.baseClass.PageBaseClass;

public class HomePage extends PageBaseClass {
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public CabBooking clickCab() {	

		WebElement ele = getElement("cabsTab_Xpath");
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", ele);
		return PageFactory.initElements(driver, CabBooking.class);
		
	}

}
