package com.yatra.pageObjects;

public class WebElements {

	public static void webElements(){
	//Xpath of landing Page
	final String myAccountDropDown_Xpath = "//a[contains(text(),'My Account')]";
	final String logInButton_Xpath = "//a[@id='signInBtn']";

	// Xpath of Login Page
	final String email_Xpath = "//input[@id='login-input']";
	final String continueBtn_Xpath = "//button[@id='login-continue-btn']";
	final String password_Xpath = "//input[@id='login-password']";
	final String loginBtn_Xpath = "//button[@id='login-submit-btn']";

	// Xpath of Home Page
	final String cabsTab_Xpath="//a[@id='booking_engine_cabs']";

	//Xpath of CabBooking Page
	final String outStationOneWayBtn_Xpath ="//input[@id='BE_cab_non_stop']";
	final String fromCity_Xpath = "//input[@id='BE_cabs_from_station']";
	final String toCity_Xpath = "//input[@id='BE_cabs_to_station']";
	final String fromCity = "Delhi";
	final String ToCity = "Manali";
	final String DelhiSelect_Xpath ="/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[3]/li[1]/div[1]/div[1]/ul[1]/div[1]/div[1]/div[1]/li[1]";
	final String ManaliSelect_Xpath = "/html[1]/body[1]/div[2]/div[1]/section[1]/div[1]/div[1]/div[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/ul[3]/li[3]/div[1]/div[1]/ul[1]/div[1]/div[1]/div[1]/li[1]";
	final String pickupDate_Xpath ="//input[@id='BE_cabs_checkin_date']";
	final String date_Xpath = "//td[@id='10/08/2020']";
	final String pickupTime_Xpath = "//input[@id='checkInTimeField']";
	final String time_Xpath = "//li[contains(@class,'BE_cabs_checkout_date')][contains(text(),'6:30 am')]";
	final String searchCabBtn_Xpath = "//input[@id='BE_cabs_htsearch_btn']";

	//CabsList Page
	final String suv_Xpath = "//h2[contains(text(),'SUV')]";
	final String showMoreBtn_Xpath = "//div[5]//div[1]//div[2]//div[5]";
	final String bookNowBtn_Xpath = "//div[@class='right-module showVendor']//div[1]//div[3]//div[1]";

	final String suvCab1_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/h2[1]";
	final String suvCarName1_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/span[1]";
	final String suvCabPrice1_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[1]/div[1]/button[1]";

	final String suvCab2_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/h2[1]";
	final String suvCarName2_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/div[1]/span[1]";
	final String suvCabPrice2_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[2]/div[1]/button[1]";

	final String suvCab3_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[3]/div[1]/div[1]/h2[1]";
	final String suvCarName3_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[3]/div[1]/div[1]/span[1]";
	final String suvCabPrice3_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[3]/div[1]/button[1]";

	final String suvCab4_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[4]/div[1]/div[1]/h2[1]";
	final String suvCarName4_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[4]/div[1]/div[1]/span[1]";
	final String suvCabPrice4_Xpath = "/html[1]/body[1]/div[1]/div[1]/div[5]/div[1]/div[2]/div[4]/div[1]/button[1]";

	//ReviewBooking Page
	final String totalAmt_Xpath = "//span[contains(text(),'Total Amount')]";
	final String totalPrice_Xpath = "//span[contains(text(),'Total Amount')]";
}

}
