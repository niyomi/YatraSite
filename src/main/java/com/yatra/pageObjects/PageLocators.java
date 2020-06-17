package com.yatra.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.yatra.baseClass.PageBaseClass;

public class PageLocators extends PageBaseClass {

	public PageLocators(WebDriver driver) {
		PageBaseClass.driver = driver;
	}

	// Xpath of landing Page
	@FindBy(xpath = "//a[contains(text(),'My Account')]")
	public static WebElement MyAccountmyAccountDropDown;

	@FindBy(xpath = "//a[@id='signInBtn']")
	public static WebElement logInButton;

	// Xpath of Login Page
	@FindBy(xpath = "//input[@id='login-input']")
	public static WebElement email;

	@FindBy(xpath = "//button[@id='login-continue-btn']")
	public static WebElement continueBtn;

	@FindBy(xpath = "//input[@id='login-password']")
	public static WebElement password;

	@FindBy(xpath = "//button[@id='login-submit-btn']")
	public static WebElement loginBtn;

	// Xpath of Home Page
	@FindBy(xpath = "//a[@id='booking_engine_cabs']")
	public static WebElement cabsTab;

	// Xpath of CabBooking Page
	@FindBy(xpath = "//input[@id='BE_cab_non_stop']")
	public static WebElement outStationOneWayBtn;

	@FindBy(xpath = "//input[@id='BE_cabs_from_station']")
	public static WebElement fromCity;

	@FindBy(xpath = "//input[@id='BE_cabs_to_station']")
	public static WebElement toCity;

	/*
	 * public static WebElement fromCity = "Delhi"; public static WebElement ToCity
	 * = "Manali";
	 */

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[3]/li[1]/div[1]/div[1]/ul[1]/div[1]/div[1]/div[1]/li[1]")
	public static WebElement DelhiSelect;

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[3]/li[3]/div[1]/div[1]/ul[1]/div[1]/div[1]/div[1]/li[1]")
	public static WebElement ManaliSelect;

	@FindBy(xpath = "//input[@id='BE_cabs_checkin_date']")
	public static WebElement pickupDate;

	@FindBy(xpath = "//td[@id='10/08/2020']")
	public static WebElement date;

	@FindBy(xpath = "//input[@id='checkInTimeField']")
	public static WebElement pickupTime;

	@FindBy(xpath = "//li[contains(@class,'BE_cabs_checkout_date')][contains(text(),'6:30 am')]")
	public static WebElement time;

	@FindBy(xpath = "//input[@id='BE_cabs_htsearch_btn']")
	public static WebElement searchCabBtn;

	// CabsList Page
	@FindBy(xpath = "//h2[contains(text(),'SUV')]")
	public static WebElement suv;

	@FindBy(xpath = "//div[6]//div[1]//div[2]//div[5]")
	public static WebElement showMoreBtn;

	@FindBy(xpath = "//div[@class='right-module showVendor']//div[1]//div[3]//div[1]")
	public static WebElement bookNowBtn;

	public static WebElement[] vendorarr = new WebElement[4];
	public static WebElement[] cabnamearr = new WebElement[4];
	public static WebElement[] cabpricearr = new WebElement[4];

	// ReviewBooking Page
	@FindBy(xpath = "//span[contains(text(),'Total Amount')]")
	public static WebElement totalAmt;

	@FindBy(xpath = "//span[contains(text(),'Total Amount')]")
	public static WebElement totalPrice;

	public static void cab() {
		for (int i = 0; i < 4; i++) {
			vendorarr[i] = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[" + (i + 1) + "]/div[1]/div[1]/h2[1]"));
			cabnamearr[i] = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[" + (i + 1) + "]/div[1]/div[1]/span[1]"));
			cabpricearr[i] = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[6]/div[1]/div[2]/div[" + (i + 1) + "]/div[1]/button[1]"));
		}
	}
}
