package basescripts;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

//import com.sun.tools.javac.util.Options;

public class BaseBrowser {
	
	public static WebDriver testDriver;
	public static DesiredCapabilities capsi = null;
	public static BaseLibrary bl = new BaseLibrary();
	public static BaseProperties proper = new BaseProperties();
	public static BaseRobot rob = new BaseRobot();
	public static String configFile = "config.properties";
	
	/** 
	 * 
	 * Set execution Environment and Browser
	 * 
	 * */
	public static String env = "";
	public static String browser = "";
	public static String startURL = "";
	
	public BaseBrowser() {}
		
		public static void initBrowser() throws IOException, InterruptedException, AWTException {
			
			setEnv();
			if (browser.equalsIgnoreCase("gecko")) {
				BaseBrowserSetupGecko.geckoSetup();
			}else if (browser.equalsIgnoreCase("chrome")) {
				BaseBrowserSetupChrome.chromeSetup();
			}else if (browser.equalsIgnoreCase("chromeSeleniumGrid")) {
				BaseBrowserSetupChromeSeleniumGrid.chromeSeleniumGridSetup();
			}else if (browser.equalsIgnoreCase("ie")) {
				BaseBrowserSetupIE.ieSetup();
			}
			if (browser.equalsIgnoreCase("gecko") || browser.equalsIgnoreCase("chrome") || browser.equalsIgnoreCase("chromeSeleniumGrid")) {
				if (env.equalsIgnoreCase("live")) { // PAGENAME needs to be changed under config.properties-->targetEnv 
					startURL = proper.getPropValue(configFile, "testUrl1"); //TESTURL needs to be changed under config.properties-->testUrl
				}else if (env.equalsIgnoreCase("stage")) {
					startURL = proper.getPropValue(configFile, "testUrl2");
				}else {
					
				}
				
			}else if (browser.equalsIgnoreCase("ie")) {
				if(env.equalsIgnoreCase("live")) {
					startURL = proper.getPropValue(configFile, "testUrl1");
				}else if (env.equalsIgnoreCase("stage")) {
					startURL = proper.getPropValue(configFile, "testUrl2");
				}else {
					
				}
			}
			/** 
			 * 
			 * Delete Cookies
			 * 
			 * */
			testDriver.manage().deleteAllCookies();
			BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
			testDriver.get(startURL);
			
			testDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			testDriver.manage().window().maximize();
			BaseLibrary.sleep(BaseLibrary.sleepTimeShort);
			
			setBrowserInfo();
			
		}
		/** 
		 * 
		 * Stops the Browser
		 * 
		 * */
	public static void tearDown() throws IOException, InterruptedException, AWTException {
		
		if (browser.equalsIgnoreCase("gecko")) {
			testDriver.close();
			BaseSetupEnvEnd.killAllGeckoProcess();
		}else if (browser.equalsIgnoreCase("chrome")) {
			testDriver.quit();
		}else {
			try {
				Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
				Runtime.getRuntime().exec("taskkill /F /IM iexplore.exe");
			}catch (IOException e) {
				System.out.println("tearDown() IE - Catch Block" + e.getMessage());
			}
		}
		
	}
	//Set Default Path
	public static WebDriver getDriver( ) {
		return testDriver;
	}
	
	public static String getBasePath() throws IOException {
		String localPath = "";
		
		localPath = BaseReport.basePath;
		return localPath;
	}
	// Set Default Browser
	public static String getBaseBrowser() throws IOException {
		String browserPath = "";
		
		browserPath = BaseReport.browserDriverPath;
		return browserPath;
	}
	// Set PDF Download directory
	public static String getFileDir(String option) throws IOException {
		String fileDir = null;
		
		if (option.equalsIgnoreCase("pdfDir")) {
			fileDir = BaseReport.pdfDownloadPath;
		}else if (option.equalsIgnoreCase("logDir")) {
			fileDir = BaseReport.LogPath;
		}
		return fileDir;
	}
	
	public static void setDriver(WebDriver newDriver) {
		testDriver = newDriver;
	} 
	
	public static String getEnv() {
		return env;
	}
	
	public static String getBrowser() {
		return browser;
	}
	
	public static void setEnv() throws IOException {
		
		env = proper.getPropValue(configFile, "targetEnv");
		browser = proper.getPropValue(configFile, "targetBrowser");
	}
	
	public static void setBrowserInfo() {
		
		Capabilities cap = ((RemoteWebDriver) testDriver).getCapabilities();
		BaseReport.browser = cap.getBrowserName();
		BaseReport.bversion = cap.getVersion().toString();
	}

}
