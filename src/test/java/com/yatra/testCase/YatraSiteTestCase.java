package com.yatra.testCase;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.yatra.baseClass.PageBaseClass;
import com.yatra.webPages.CabBooking;
import com.yatra.webPages.CabList;
import com.yatra.webPages.HomePage;
import com.yatra.webPages.LandingPage;
import com.yatra.webPages.LogInPage;

public class YatraSiteTestCase {
	HomePage homeP;
	LogInPage loginP;
	CabBooking cabBookingP;
	CabList cabListP;
	LandingPage landingP;
	PageBaseClass pgB = new PageBaseClass();

	@BeforeTest()
	public void BrowserSelection() {
		PageBaseClass.logger = pgB.report.createTest("Yatra Site Cab Smoke Test"); // creating report
		pgB.invokeBrowser("browserName");
	}

	@Test(priority = 1, description = "Loading the site", groups = { "smoke test" })
	public void Loadsite() {

		landingP = pgB.openApplication("sitename");
		pgB.waitPageLoad();
	}

	@Test(priority = 2, description = "Logging in on the site")
	public void login() {
		loginP = landingP.clickLogin();

		homeP = loginP.clickLoginExisting();
		pgB.waitPageLoad();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 3, description = "Searching the Cab")
	public void searchCab() {

		cabBookingP = homeP.clickCab();
		pgB.waitPageLoad();
		cabListP = cabBookingP.searchCab();
	}

	@Test(priority = 4, description = "Writing into the excel file")
	public void ExcelWrite() {

		cabListP.writeData();
		PageBaseClass.logger.log(Status.PASS, "Excel File Created Successfully");

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
	}

	@AfterMethod
	public void endReport() {
		pgB.report.flush();
	}

}
