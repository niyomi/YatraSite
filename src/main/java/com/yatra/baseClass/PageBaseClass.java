package com.yatra.baseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.yatra.utilities.ExtentReportManager;
import com.yatra.utilities.ScreenShotClass;
import com.yatra.webPages.LandingPage;

public class PageBaseClass {

	public Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	public static  WebDriver driver;

	/************************* Loading config.Properties File *************************/
	public void propLoad() {
		if (prop == null) {
			prop = new Properties();
			try {
				FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\config.properties");
				prop.load(file);
			} catch (Exception e) {
				reportFailure(e.getMessage());
				e.printStackTrace();
			}
		}

	}
	/************************* Invoke Browser *************************/

	public void invokeBrowser(String browserName) {
		prop=null;
		propLoad();
		try {

			if ("Chrome".equalsIgnoreCase(prop.getProperty(browserName))) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + prop.getProperty("chromePath"));
				driver = new ChromeDriver();

			} else if ("Firefox".equalsIgnoreCase(prop.getProperty(browserName))) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + prop.getProperty("FirefoxPath"));
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			reportFailure(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
	}

	

	/************************* Open Application *************************/
	public LandingPage openApplication(String siteName) {
		prop = null;
		propLoad();
		logger.log(Status.INFO, "Opening  Website: "+prop.getProperty(siteName));
		driver.get(prop.getProperty(siteName));
		logger.log(Status.PASS, "Successfully Opened the Website "+prop.getProperty(siteName));
		return PageFactory.initElements(driver, LandingPage.class);
	}

	/************************* Get Page Title *************************/
	public void pageTitle(String expected) {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Assert.assertEquals(driver.getTitle(), expected);			
			//logger.log(Status.PASS, "Successfully Checked the Title: "+expected);
			logger.log(Status.INFO,driver.getTitle() + " Title Found.");
	}

	/************************* Quit Browser *************************/
	
	public void quitBrowser() {
		
		logger.log(Status.INFO,"Quitting Browser");
		driver.quit();		
	}
	
	/*************************
	 * Enter the text in text fields
	 *************************/
	public void enterText(WebElement xpathKey, String data) {
		try {

			//getElement(xpathKey)
			xpathKey.sendKeys(prop.getProperty(data));
			reportPass(data + " - Entered successfully");
		} catch (Exception e) {
			reportFailure(e.getMessage());
		}
	}

	/************************* To click the element *************************/
	public void elementClick(WebElement element,String msg) {
			try {
			
			element.click();
			//Thread.sleep(2000);
			reportPass(msg+" Successfully");
		} catch (Exception e) {
			reportFailure(e.getMessage());
		}
	}

	
	/************************* To select value *************************/
	public void selectElement(WebElement element, String value) {
		try {
			//WebElement ele = getElement(locaterKey);
			Thread.sleep(2000);
			Select sel = new Select(element);
			sel.selectByVisibleText(prop.getProperty(value));
			reportPass(element + " Identified Successfully");
			logger.log(Status.INFO, "Selected the Defined Value : " + value);
		} catch (Exception e) {
			reportFailure(e.getMessage());
		}
	}

	/************************* To get Text of element *************************/
	public String text(WebElement ele) {
		String txt="";
		try {
			txt = ele.getText();
		} catch (Exception e) {
			reportFailure(e.getMessage());
		}
		return txt;
	}

	/************************* PageLoad Wait *************************/
	public void waitPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	}

	/************************* Reporting Functions *************************/
	public void reportFailure(String msg) {
		logger.log(Status.FAIL, msg);
		ScreenShotClass.takeScrennshotOnFailure(driver); //calling function to take screenshot from ScreenShotClass
		Assert.fail(msg);
	}

	public void reportPass(String msg) {
		
		ScreenShotClass.takeScrennshotOnFailure(driver); //calling function to take screenshot from ScreenShotClass
		logger.log(Status.PASS, msg);
	}


	 
	 

}
