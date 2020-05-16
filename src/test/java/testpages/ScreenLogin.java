package testpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import basescripts.BaseCredential;
import basescripts.BaseLibrary;
import basescripts.BaseProperties;


public class ScreenLogin {
	
	public static String properFileXpath = "screen_login_xpath.properties";
	public static String properFileText = "screen_login.properties";
	public static BaseLibrary bl = new BaseLibrary();
	public static BaseProperties prop = new BaseProperties();
	public static String pageLayer = "ScreenLogin";
	
	public static void checkScreenElement(WebDriver testDriver, String testName) throws IOException, InterruptedException {
		testName = testName + pageLayer;
		
		bl.checkText(testName, "if title is displayed correctly:", prop.getPropValue(properFileText, "screen_login_headline"), bl.getElementText(testDriver, "xpath", properFileXpath, "screen_login_headline", testName));
		
	}
	
	public static void login(WebDriver testDriver, String username, String userpwd, String testName) throws IOException, InterruptedException {
		testName = testName + pageLayer;
		
		String userName = BaseCredential.getDecoded(prop.getPropValue("useridfile.properties", username));
		String userPwd = BaseCredential.getDecoded(prop.getPropValue("useridfile.properties", userpwd));
		
		bl.fillInputField(testDriver, "xpath", properFileXpath, "screen_login_usernameField", userName, testName);
		bl.fillInputField(testDriver, "xpath", properFileXpath, "screen_login_passwordFiel", userPwd, testName);
		bl.bClick(testDriver, "xpath", properFileXpath, "screen_login_loginButton", "noScroll", testName);
		
		BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
	}

}
