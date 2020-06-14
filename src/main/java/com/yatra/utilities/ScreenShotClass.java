package com.yatra.utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.yatra.baseClass.PageBaseClass;
import com.yatra.utilities.Dateutils;

public class ScreenShotClass extends PageBaseClass {
	

	public static void takeScrennshotOnFailure(WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
		File destFile = new File(
				System.getProperty("user.dir") + "\\screenshots\\" + Dateutils.getTimeStamp() + ".png");

		try {
			// Saving file in the given path in Screenshot folder
			FileUtils.copyFile(sourceFile, destFile);

			// Adding the taken screen shot in extent report
			logger.addScreenCaptureFromPath(
					System.getProperty("user.dir") + "\\screenshots\\" + Dateutils.getTimeStamp() + ".png");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
