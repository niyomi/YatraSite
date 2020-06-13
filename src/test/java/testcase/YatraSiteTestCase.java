package testcase;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import baseClass.PageBaseClass;
import yatraWebPages.CabBooking;
import yatraWebPages.CabList;
import yatraWebPages.HomePage;
import yatraWebPages.LogInPage;
import yatraWebPages.LandingPage;

public class YatraSiteTestCase {
	HomePage homeP;
	LogInPage loginP;
	CabBooking cabBookingP;
	CabList cabListP;
	LandingPage landingP;
	PageBaseClass pgB = new PageBaseClass();
	
	
	@Test(priority = 1,description="opens the browser")
	public void BrowserSelection() {
		pgB.logger = pgB.report.createTest("Yatra Site Cab Test");		//creating report
		pgB.invokeBrowser("firefox");
	}

	@Test(priority = 2,description="Loading the site")
	public void Loadsite() {

		landingP = pgB.openApplication("sitename");
		pgB.waitPageLoad();
	}

	@Test(priority = 3,description="Logging in on the site")
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
	
	@Test(priority = 4,description="Searching the Cab")
	public void searchCab()  {

		cabBookingP = homeP.clickCab();
		pgB.waitPageLoad();
		cabListP = cabBookingP.searchCab();
	}
	@Test(priority=5,description="Writing into the excel file")
	public void ExcelWrite() {
		
		cabListP.writeData();
	
	}

	@Test(priority = 6,description="Closing the Browser")
	public void QuitBrowser() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pgB.quitBrowser();
	}

	@AfterTest
	public void endReport() {
		pgB.report.flush();
	}

}
