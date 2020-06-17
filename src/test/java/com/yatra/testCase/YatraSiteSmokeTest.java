package com.yatra.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.yatra.baseClass.PageBaseClass;
import com.yatra.webPages.CabBooking;
import com.yatra.webPages.CabList;
import com.yatra.webPages.HomePage;
import com.yatra.webPages.LandingPage;
import com.yatra.webPages.LogInPage;

public class YatraSiteSmokeTest {
	// HomePage homeP;
	LogInPage loginP;
	CabBooking cabBookingP;
	CabList cabListP;
	LandingPage landingP;
	PageBaseClass pgB = new PageBaseClass();
	WebDriver driver;

	@BeforeTest()
	public void BrowserSelection() {
		PageBaseClass.logger = pgB.report.createTest("Yatra Site Cab Smoke Test"); // creating report
		pgB.invokeBrowser("browserName");
	}

	@Test(priority = 1, description = "Loading the site", groups = {"smoke test"})
	public void Loadsite() {

		landingP = pgB.openApplication("sitename");
		pgB.waitPageLoad();
		driver = PageBaseClass.driver;
	}

	@Test(priority = 2, description = "Searching the Cab", groups = {"smoke test"})
	public void searchCab() {
		HomePage homeP = new HomePage(driver);
		cabBookingP = homeP.clickCab();
		pgB.waitPageLoad();
		cabListP = cabBookingP.searchCab();
	}

	@AfterTest
	public void QuitBrowser() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pgB.quitBrowser();
		// pgB.logger.log(Status.INFO,"Quiting Browser");
	}

	@AfterMethod
	public void endReport() {
		pgB.report.flush();
	}

}
