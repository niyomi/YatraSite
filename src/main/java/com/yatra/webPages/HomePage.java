package com.yatra.webPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;
import com.yatra.baseClass.PageBaseClass;
import com.yatra.pageObjects.PageLocators;

public class HomePage extends PageBaseClass {
	PageLocators pageLocator;

	public HomePage(WebDriver driver) {
		PageBaseClass.driver = driver;
		pageLocator = new PageLocators(driver);
		PageFactory.initElements(driver, pageLocator);
	}

	public CabBooking clickCab() {

		pageTitle("Flight, Cheap Air Tickets , Hotels, Holiday, Trains Package Booking - Yatra.com");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", PageLocators.cabsTab);
		logger.log(Status.PASS, "Cab Tab Clicked Successfully");

		return PageFactory.initElements(driver, CabBooking.class);

	}

}
