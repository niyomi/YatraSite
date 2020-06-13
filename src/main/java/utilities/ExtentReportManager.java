package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;

public class ExtentReportManager {

	public static ExtentReports report;

	public static ExtentReports getReportInstance() {
		if (report == null) {
			String reportName = Dateutils.getTimeStamp() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(
					System.getProperty("user.dir") + "\\reports\\" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);

			// System Information
			report.setSystemInfo("OS", "Windows 10");
			report.setSystemInfo("Build Version", "10.8.1");
			report.setSystemInfo("Browser", "Mozilla");
			report.setSystemInfo("Environment", "UAT");

			// to give info realted to HTML page
			htmlReporter.config().setDocumentTitle("Project id 1");		//setting title of the webpage
			htmlReporter.config().setReportName("MakeMyTrip site Report");	//setting title of the report
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
			htmlReporter.config().setTimeStampFormat("MMM dd,yyyy hh:mm:ss a");	//date and time for the report created

		}
		return report;
	}

}
