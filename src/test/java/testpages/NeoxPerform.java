package testpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import basescripts.BaseCredential;
import basescripts.BaseLibrary;
import basescripts.BaseProperties;

public class NeoxPerform {
	public static String properFileXpath = "neox_landing_xpath.properties";
	public static String porperFileText = "neox_landing_text.properties";
	public static BaseLibrary bl = new BaseLibrary();
	public static BaseProperties prop = new BaseProperties();
	public static BaseCredential cred = new BaseCredential();
	public static String pageLayer = "NeoxPerform";
	public static String handle = null;

public static void getCode() throws Exception {
	
	cred.encodeCredential();
}	
public static void getHeader(WebDriver testDriver, String testName) throws Exception {
	testName = testName + pageLayer;
	bl.checkText(testName, "is Displayed", prop.getPropValue(porperFileText, "header_menu_name"), bl.getElementText(testDriver, "xpath", properFileXpath, "header_menu_name", testName));

}

}
