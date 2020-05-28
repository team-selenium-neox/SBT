package basescripts;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseBrowserSetupChrome extends BaseBrowser {
	
	public static String configFile = "config.properties";
	public static void chromeSetup() throws IOException {		
		
		String chromeDriverPath = "";
		chromeDriverPath = BaseReport.browserDriverPath + "chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", chromeDriverPath);
		
		String downloadFilepath = "";
		downloadFilepath = BaseReport.pdfDownloadPath;
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("-Dchrome.switches=--disable-extensions");
		options.addArguments("disable-infobars");
		options.addArguments("window-size=1920x1200");
		
		if (proper.getPropValue(configFile, "chromeHeadless").equalsIgnoreCase("true")) {
			options.addArguments("headless");
			options.addArguments("window-size=1920x1200");			
		}
		//deactivates the PDF-Reader of the Browser
		HashMap<String, Object> plugin = new HashMap<String, Object>();
		plugin.put("enabled", false);
		plugin.put("name", "Chrome PDF Viewer");
		plugin.put("name", "pdfjs.disabled");
		plugin.put("name", "settings-pdf-documents");
		plugin.put("plugins.always_open_pdf_externally", true);
		HashMap<String, Object> prefs = new HashMap<String, Object>();
		prefs.put("plugins.plugins_list", Arrays.asList(plugin));
		prefs.put("profile.default_content_settings.popups", 0);
		prefs.put("download.default_directory", downloadFilepath);
		
		options.setExperimentalOption("prefs", prefs);
		
		testDriver = new ChromeDriver(options);
	}


}
