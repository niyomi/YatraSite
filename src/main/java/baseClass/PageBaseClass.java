package baseClass;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

//import org.testng.annotations.AfterMethod;
/*import com.aventstack.extentreports.Status;
import com.screensetup.ScreenShotClass;*/

import utilities.ExtentReportManager;
import utilities.ScreenShotClass;
import yatraWebPages.LandingPage;

public class PageBaseClass {

	public Properties prop;
	public ExtentReports report = ExtentReportManager.getReportInstance();
	public static ExtentTest logger;
	SoftAssert softAssert = new SoftAssert();
	public WebDriver driver;

	/************************* Invoke Browser *************************/

	public void invokeBrowser(String browserName) {
		try {

			if (browserName.equalsIgnoreCase("Chrome")) {
				System.setProperty("webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("Firefox")) {
				System.setProperty("webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			reportFailure(e.getMessage());
		}

		driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
		
	}

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

	/************************* Open Application *************************/
	public LandingPage openApplication(String siteName) {
		propLoad();
		driver.get(prop.getProperty(siteName));
		return PageFactory.initElements(driver, LandingPage.class);
	}

	/************************* Get Page Title *************************/
	public void pageTitle(String expected) {
		waitPageLoad();
		Assert.assertEquals(driver.getTitle(), expected);
	}

	/************************* CLose browser *************************/
	public void closeBrowser() {
		driver.close();
	}

	/************************* Quit Browser *************************/
	public void quitBrowser() {
		driver.quit();
	}

	/*************************
	 * Enter the text in text fields
	 *************************/
	public void enterText(String xpathKey, String data) {
		try {

			getElement(xpathKey).sendKeys(prop.getProperty(data));
			reportPass(data + " - Entered successfully in locator Element : " + xpathKey);
		} catch (Exception e) {
			reportFailure(e.getMessage());
		}
	}

	/************************* To click the element *************************/
	public void elementClick(String xpathKey) {
		try {
			WebElement c = getElement(xpathKey);
			c.click();			
			reportPass(xpathKey + " Identified Successfully");
		} catch (Exception e) {
			reportFailure(e.getMessage());
		}
	}

	/*************************
	 * To identify the web element
	 *************************/
	public WebElement getElement(String locatorKey) {
		WebElement element = null;
		prop = null;
		propLoad();
		try {
			if (locatorKey.endsWith("_Id")) {
				element = driver.findElement(By.id(prop.getProperty(locatorKey)));
				
			} else if (locatorKey.endsWith("_Xpath")) {
				element = driver.findElement(By.xpath(prop.getProperty(locatorKey)));

			} else if (locatorKey.endsWith("_Name")) {
				element = driver.findElement(By.name(prop.getProperty(locatorKey)));

			} else if (locatorKey.endsWith("_LinkText")) {
				element = driver.findElement(By.linkText(prop.getProperty(locatorKey)));

			} else if (locatorKey.endsWith("_CSS")) {
				element = driver.findElement(By.cssSelector(prop.getProperty(locatorKey)));

			} else if (locatorKey.endsWith("_Class")) {
				element = driver.findElement(By.className(prop.getProperty(locatorKey)));

			} else {
				reportFailure("Failing Test case,Invalid Locator: " + locatorKey);
				Assert.fail("Failing Test case,Invalid Locator: " + locatorKey);
			}
		} catch (Exception e) {
			// Fail the TestCase and Report the error
			reportFailure(e.getMessage());
			// e.printStackTrace();
		}

		return element;
	}

	/************************* To select value *************************/
	public void selectElement(String locaterKey, String value) {
		try {
			WebElement ele = getElement(locaterKey);
			Thread.sleep(2000);
			Select sel = new Select(ele);
			sel.selectByVisibleText(prop.getProperty(value));
			reportPass(locaterKey + " Identified Successfully");
			logger.log(Status.INFO, "Selected the Defined Value : " + value);
		} catch (Exception e) {
			reportFailure(e.getMessage());
		}
	}

	/************************* To get Text of element *************************/
	public String text(String locaterKey) {
		propLoad();
		WebElement ele = null;
		try {
			ele = getElement(locaterKey);
			//logger.log(Status.INFO, "Found the Defined Value : " + locaterKey);
		} catch (Exception e) {
			reportFailure(e.getMessage());
		}
		return ele.getText();
	}

	/************************* PageLoad Wait *************************/
	public void waitPageLoad() {
		driver.manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);
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

	
	 @AfterMethod 
	 public void afterTest()
	 { 
		 softAssert.assertAll(); driver.quit();
	 }
	 

}
