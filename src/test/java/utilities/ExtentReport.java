/**
 * 
 */
package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * @author Srihari
 *
 */
public class ExtentReport {
	public static ExtentReports generateExtentReport() {
		ExtentReports extentreporter = new ExtentReports();

		File reportFile = new File(System.getProperty("user.dir") + "//test-output//ExtentReports//extenreport.html");

		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportFile);
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setDocumentTitle("Orange HRM");
		sparkReporter.config().setReportName("Ornage HRM Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/mm/yyyy hh::mm::ss");
		extentreporter.attachReporter(sparkReporter);

		Properties prop = new Properties();
		File f = new File("./Configuration/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		extentreporter.setSystemInfo("Application Url", prop.getProperty("Url"));
		extentreporter.setSystemInfo("BrowserName", prop.getProperty("Browser"));
		extentreporter.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentreporter.setSystemInfo("Username", System.getProperty("user.name"));
		extentreporter.setSystemInfo("Java Version", System.getProperty("java.version"));

		return extentreporter;
	}

}
