package com.yatra.webPages;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.yatra.baseClass.PageBaseClass;
import com.yatra.pageObjects.*;
import com.yatra.utilities.Excel;

public class CabList extends PageBaseClass {
	PageLocators pageLocator;

	public CabList(WebDriver driver) {
		PageBaseClass.driver = driver;
		pageLocator = new PageLocators(driver);
		PageFactory.initElements(driver, pageLocator);
	}

	public void writeData() {
		pageTitle("Cabs");
	
		

		PageLocators.cab();
		String cabDetails[][] = new String[4][3]; // creating string array to store list of cabs
		
		for (int i = 0; i < 4; i++) {
			cabDetails[i][0] = text(PageLocators.vendorarr[i]); // assigning vendor name
			cabDetails[i][1] = text(PageLocators.cabnamearr[i]); // assign car name
			cabDetails[i][2] = text(PageLocators.cabpricearr[i]); // assigning cab Price
		}

		try {
			Excel ex = new Excel();
			ex.writeCabInfo(cabDetails); // calling function to write the list of Cabs in excel sheet with
											// sheet name ="ListofCabs,suv"
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
