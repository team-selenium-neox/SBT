package testpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import basescripts.BaseLibrary;
import basescripts.BaseProperties;

public class NeoxPerform {
	public static String properFileXpath = "neox_landing_xpath.properties";
	public static String porperFileText = "neox_landing_text.properties";
	public static BaseLibrary bl = new BaseLibrary();
	public static BaseProperties prop = new BaseProperties();
	public static String pageLayer = "NeoxPerform";
	public static String handle = null;

	
	public static void checkScreenElements(WebDriver testDriver, String target, String testName) throws IOException, InterruptedException {
		testName = testName +pageLayer;
		
		bl.checkText(testName, "if Icon is displayed", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "screen_landing_header_logo", testName));
		bl.checkText(testName, "if title is displayed correctly", prop.getPropValue(porperFileText, "screen_landing_header_title"), bl.getElementText(testDriver, "xpath", properFileXpath, "screen_landing_header_title", testName));
		bl.checkText(testName, "if menu item is displayed correctly", prop.getPropValue(porperFileText, "screen_landing_navi_col1_item1"), bl.getElementText(testDriver, "xpath", properFileXpath, "screen_landing_navi_col1_item1", testName));
			
	}
	
	public static void checkBlockText(WebDriver testDriver, String testName) throws IOException, InterruptedException {
		testName = testName + pageLayer;
		
		bl.getWebTextElement(testDriver, "text is the same", bl.getElementText(testDriver, "xpath", properFileXpath, "screen_landing_navi_col1_col2_item1", testName));
		
	}
	
	public static void checkSlide (WebDriver testDriver, String target, String testName) throws IOException, InterruptedException {
		if (target.equalsIgnoreCase("Neox")) {
			sClick(testDriver, "screen_landing_navi_arrow_buttonR", "noScroll", testName);
			sClick(testDriver, "screen_landing_navi_arrow_buttonR", "noScroll", testName);
			//...
			
		}else {
			
		}
	}
	
	public static void sClick(WebDriver testDriver, String objRef, String scrollOption, String testName) throws IOException, InterruptedException {
		testName = testName + pageLayer;
		
		bl.bClick(testDriver, "xpath", properFileXpath, objRef, scrollOption, testName);
	}
}
