package yatraWebPages;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.PageBaseClass;
import yatraWebPages.CabList;

public class CabBooking extends PageBaseClass {

	public CabBooking(WebDriver driver) {
		this.driver = driver;
	}

	public CabList searchCab() {
		
		elementClick("outStationOneWayBtn_Xpath");
		elementClick("fromCity_Xpath");
		enterText("fromCity_Xpath", "fromCity");
		WebElement ele = getElement("fromCity_Xpath");
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", ele);

		elementClick("DelhiSelect_Xpath");

		enterText("toCity_Xpath", "ToCity");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"/html/body/div/div/div[2]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/div/div/ul/li[1]/div/p")));
		elementClick("ManaliSelect_Xpath");

		elementClick("pickupDate_Xpath");
		elementClick("date_Xpath");
		

		/*EventFiringWebDriver event = new EventFiringWebDriver(driver);
		event.executeScript(
				"document.querySelector('#root > div > div.minContainer > div > div > div.csw.outstationOneway.widgetOpen > div > div.csw_inputBox.timePicker.inactiveWidget.activeWidget > ul').scrollTop = 450");*/
		elementClick("pickupTime_Xpath");
		elementClick("time_Xpath");

		elementClick("searchCabBtn");

		return PageFactory.initElements(driver, CabList.class);
	}

}
