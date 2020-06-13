package yatraWebPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClass.PageBaseClass;


public class LogInPage extends PageBaseClass {
	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}

	public HomePage clickLoginExisting() {
		
		enterText("email_Xpath", "username");
		elementClick("continueBtn_Xpath");
		waitPageLoad();
		enterText("password_Xpath", "password");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementClick("loginBtn_Xpath");
		return PageFactory.initElements(driver, HomePage.class);

	}
}
