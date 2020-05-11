package basescripts;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseBrowserSetupChromeSeleniumGrid extends BaseBrowser {
	
	public static void chromeSeleniumGridSetup() throws IOException {
		
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setBrowserName("chrome");
		capabilities.setPlatform(Platform.ANY);
		String nodeURL = "https://selenium-hub..."; // a Selenium Testhub is needed
		
		testDriver = new RemoteWebDriver(new URL(nodeURL), capabilities);
	}

}
