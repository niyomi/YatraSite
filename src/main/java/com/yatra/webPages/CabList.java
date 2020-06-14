package com.yatra.webPages;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.yatra.baseClass.PageBaseClass;
import com.yatra.utilities.Excel;

public class CabList extends PageBaseClass {
	
	public CabList(WebDriver driver) {
		this.driver = driver;
	}
	
	public void writeData()
	{
		elementClick("showMoreBtn_Xpath");
		String cabDetails[][] = new String[4][3]; // creating string array to store list of cabs
		for (int i = 0; i < 4; i++) {

			cabDetails[i][0] = text("suvCab" + (i + 1) + "_Xpath"); // assigning vendor name
			cabDetails[i][1] = text("suvCarName"+ (i + 1) + "_Xpath"); // assign car name
			cabDetails[i][2] = text("suvCabPrice" + (i + 1) + "_Xpath"); // assigning cab Price
		}

		try {
			Excel ex = new Excel(System.getProperty("user.dir") + "\\Cab Details List.xlsx"); // calling excel
																								// constructor with path
																								// of excel
			ex.readData("ListofCabs", cabDetails); // calling function to write the list of Cabs in excel sheet with
													// sheet name ="ListofCabs"
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
