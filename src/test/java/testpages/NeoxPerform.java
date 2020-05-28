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
	public static String pageLayer = " NeoxPerform";
	public static String handle = null;

public static void getCode() throws Exception {
	
	cred.encodeCredential();
}	
public static void getHeader(WebDriver testDriver, String testName) throws Exception {
	testName = testName + pageLayer;
	bl.checkText(testName, "is Displayed", prop.getPropValue(porperFileText, "header_menu_name"), bl.getElementText(testDriver, "xpath", properFileXpath, "header_menu_name", testName));

}
public static void sClick(WebDriver testDriver, String objRef, String scrollOption, String testName) throws IOException, InterruptedException {
	testName = testName + pageLayer;
	
	bl.bClick(testDriver, "xpath", properFileXpath, objRef, scrollOption, testName);
}
public static void getMenu(WebDriver testDriver, String target, String testName) throws Exception {
	testName = testName + pageLayer;
	
	bl.checkText(testName, "Click Button Right", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "header_menu_name", testName));
	sClick(testDriver, "header_menu_name", "noScroll",testName);
	BaseLibrary.sleep(BaseLibrary.sleepTimeShortMedium);

}
public static void getSlide(WebDriver testDriver, String target, String testName) throws Exception {
	bl.scrollTo(testDriver, properFileXpath, "body_item_element2");
	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
	sClick(testDriver, "body_item_element3", "npScroll", testName);
	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
}

}
