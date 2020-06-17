package com.yatra.testCase;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;
import com.yatra.baseClass.PageBaseClass;
import com.yatra.webPages.CabBooking;
import com.yatra.webPages.CabList;
import com.yatra.webPages.HomePage;
import com.yatra.webPages.LandingPage;
import com.yatra.webPages.LogInPage;

public class YatraSiteRegressionTest {
	HomePage homeP;
	LogInPage loginP;
	CabBooking cabBookingP;
	CabList cabListP;
	LandingPage landingP;
	PageBaseClass pgB = new PageBaseClass();
	WebDriver driver;
	
	
	//@Test(priority = 1,description="Opening Browser",groups = {"Regression test","Smoke test","Full Testing"})
	@BeforeTest(alwaysRun=true)
	public void BrowserSelection() {
		PageBaseClass.logger = pgB.report.createTest("Yatra Site Cab Test");		//creating report
		pgB.invokeBrowser("browserName");
	}

	@Test(priority = 2,description="Loading the site",groups = {"Regression test","Smoke test","Full Testing"})
	public void Loadsite() {

		landingP = pgB.openApplication("sitename");
		pgB.waitPageLoad();
		driver=PageBaseClass.driver;
	}

	@Test(priority = 3,description="Logging in on the site",groups = {"Regression test","Full Testing"})
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
	
	@Test(priority = 4,description="Searching the Cab",groups = {"Regression test","Full Testing","Smoke test"})
	public void searchCab()  {
		
		cabBookingP = homeP.clickCab();
		
		pgB.waitPageLoad();
		cabListP = cabBookingP.searchCab();
	}
	
	/*@Test(priority = 4,description="Searching the Cab",groups = { "Smoke test"})
	public void searchCabSmoke()  {
		
		HomePage homeP = new HomePage(driver);
		cabBookingP = homeP.clickCab();
		pgB.waitPageLoad();
		cabListP = cabBookingP.searchCab();
	}*/
	
	@Test(priority=5,description="Writing into the excel file",groups = {"Full Testing"})
	public void ExcelWrite() {
		
		cabListP.writeData();
	
	}
	
	//priority = 1,description="opens the browser", groups = {"Regression test","Smoke test","Full Testing"}

	//@Test(priority = 6,description="Opening Browser",groups = {"Regression test","Smoke test","Full Testing"})
	
	@AfterTest(alwaysRun=true)
	public void QuitBrowser() {
		pgB.waitPageLoad();
		pgB.quitBrowser();
		pgB.logger.log(Status.INFO,"Quiting Browser");
	}
	//priority = 6,description="Closing the Browser",groups = {"Regression test","Smoke test"}
	
	@AfterMethod(alwaysRun=true)
	public void endReport() {
		pgB.report.flush();
	}




}
