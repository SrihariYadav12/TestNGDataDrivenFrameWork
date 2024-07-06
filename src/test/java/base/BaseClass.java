/**
 * 
 */
package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * @author Srihari
 *
 */
public class BaseClass {

	public static Properties prop;
	// public static WebDriver driver;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<>();

	public static WebDriver getDriver() {
		// get driver from threadLocalmap
		return driver.get();
	}

	public BaseClass() {

		prop = new Properties();
		File f = new File(System.getProperty("user.dir") + "\\Configuration\\Config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			prop.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void intilizeBrowser(String browser) {
		if (browser.equalsIgnoreCase("Chrome")) {
			// driver = new ChromeDriver();
			// set Browser to ThreadLocalMap
			driver.set(new ChromeDriver());

		} else if (browser.equalsIgnoreCase("Edge")) {
			// driver = new EdgeDriver();
			driver.set(new EdgeDriver());
		} else {
			// driver = new FirefoxDriver();
			driver.set(new FirefoxDriver());
		}

		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		getDriver().get(prop.getProperty("Url"));

	}

	public static String captureScreenShot(String testName) throws Throwable {

		TakesScreenshot ts = (TakesScreenshot) getDriver();
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/ScreenShots/" + testName + ".png";
		File target = new File(path);
		FileUtils.copyFile(source, target);
		return path;

	}
}
