package basescripts;

import java.io.IOException;

import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BaseBrowserSetupIE extends BaseBrowser {
	
	public static String configFile = "config.properties";
	
	@SuppressWarnings("deprecation")
	public static void ieSetup() throws IOException, InterruptedException {
		String ieDriverPath = "";
		
		if (proper.getPropValue(configFile, "ENV").equalsIgnoreCase("no")) {
			ieDriverPath = BaseReport.basePath + BaseReport.browserDriverPath + "ieDriverServer.exe";
		} else {
			//ieDriverPath = BaseReport.basePath + BaseReport.browserDriverPathENV + "ieDriverServer.exe";
		}
		System.setProperty("webdriver.ie.driver", ieDriverPath);
		
		capsi = DesiredCapabilities.internetExplorer();
		
		capsi.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capsi.setCapability("ie.ensureCleanSession", true);
		capsi.setCapability("requireWindowFocus", true);
		
		capsi.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		testDriver = new InternetExplorerDriver(capsi);
		testDriver.manage().deleteAllCookies();
	}

}
