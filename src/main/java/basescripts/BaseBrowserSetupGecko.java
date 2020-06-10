package basescripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseBrowserSetupGecko extends BaseBrowser {
	
	public static String configFile = "config.properties";
	
	@SuppressWarnings("deprecation")
	public static void geckoSetup() throws IOException, InterruptedException {
		
		String geckoDriverPath = "";
		// for untrusted Web Pages
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("acceptsInsecureCerts", true);
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("browser.download.dir", getFileDir("pdfDir"));
		profile.setPreference("browser.download.folderList", 2);
		// for suppressing the download confirmation
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", 
				"application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;"
				+ "application/pdf;"
				+ "application/vnd.openxmlformats-officedocument.wordprocessingml.document;"
				+ "text/plain;"
				+ "text/csv");
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disable", true);
		profile.setPreference("dom.disable_beforeunload", true);
		
		cap.setCapability(FirefoxDriver.PROFILE, profile);
		
		String browserPath = BaseReport.browserDriverPath + "geckodriver.exe";
		File pathToBinary = null;
		
		pathToBinary = new File(browserPath);
		FirefoxBinary ffBinary = new FirefoxBinary(pathToBinary);
		
		geckoDriverPath = BaseReport.browserDriverPath +"geckodriver.exe";
		
//		String geckoDriverPath = "";
//		
//		if (proper.getPropValue(configFile, "ENV").equalsIgnoreCase("no")) {
//			geckoDriverPath = BaseReport.browserDriverPath +"geckodriver.exe";
//		} else {
//			// This "else" is only used if you try to use another environment which is not standard
//			geckoDriverPath = BaseReport.basePath + BaseReport.browserDriverPathENV +"geckodriver.exe";
//		}
		System.setProperty("webdriver.gecko.driver", geckoDriverPath);
		
		System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
		
		testDriver = new FirefoxDriver(new GeckoDriverService.Builder().usingFirefoxBinary(ffBinary).build(), cap);
	}

}
