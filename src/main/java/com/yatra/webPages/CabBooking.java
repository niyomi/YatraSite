package com.yatra.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.yatra.baseClass.PageBaseClass;
import com.yatra.pageObjects.PageLocators;
import com.yatra.webPages.CabList;

public class CabBooking extends PageBaseClass {
	PageLocators pageLocator;
	public CabBooking(WebDriver driver) {
		PageBaseClass.driver = driver;
		pageLocator= new PageLocators(driver);
		PageFactory.initElements(driver, pageLocator);
	}

	public CabList searchCab() {
		propLoad();			
		waitPageLoad();
		pageTitle("Online Cab Booking with Latest Offers on Car Rental, Outstation Cabs, Airport Transfers");
		elementClick(PageLocators.outStationOneWayBtn,"Outstation Radio Button Clicked");		
		elementClick(PageLocators.fromCity,"From City TextBox Clicked");		
		logger.log(Status.INFO,"Entering From City Name");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		enterText(PageLocators.fromCity, "FromCity");				
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementClick(PageLocators.DelhiSelect,"Delhi Selected");		
		logger.log(Status.INFO,"Entering To City Name");
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		enterText(PageLocators.toCity, "ToCity");		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		elementClick(PageLocators.ManaliSelect,"Manali Selected");	
		elementClick(PageLocators.pickupDate,"pickupDate Clicked");		
		EventFiringWebDriver event = new EventFiringWebDriver(driver);
		event.executeScript("document.querySelector('#monthWrapper').scrollTop = 450");		
		elementClick(PageLocators.date,"Date Selected");		
		elementClick(PageLocators.pickupTime,"PickupTime Clicked");	
		elementClick(PageLocators.time,"Time Selected");		
		elementClick(PageLocators.searchCabBtn,"Search Cab Button Clicked");
		
		WebDriverWait expwait = new WebDriverWait(driver, 2);
		expwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='root']/div/div[6]")));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,850)");
		elementClick(PageLocators.showMoreBtn, "Show More Vendors Button Clicked");
		reportPass("SUV Cabs Found");
		
		return PageFactory.initElements(driver, CabList.class);
	}

}
