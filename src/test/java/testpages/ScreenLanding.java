package testpages;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//import com.sun.tools.classfile.Opcode.Set;

import basescripts.BaseLibrary;
import basescripts.BaseProperties;

public class ScreenLanding {
	
	public static String properFileXpath = "screen_landing_xpath.properties";
	public static String porperFileText = "screen_landing_text.properties";
	public static BaseLibrary bl = new BaseLibrary();
	public static BaseProperties prop = new BaseProperties();
	public static String pageLayer = "ScreenLanding";
	public static String handle = null;
	
	public static void checkScreenElements(WebDriver testDriver, String testName) throws IOException, InterruptedException {
		testName = testName + pageLayer;
		// Example Code
		bl.checkText(testName, "if icon is visible / displayed", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "screen_landing_header_logo", testName));
		bl.checkText(testName, "if title is displayed correctly", prop.getPropValue(porperFileText, "screen_landing_header_title"), bl.getElementText(testDriver, "xpath", properFileXpath, "screen_landing_header_title", testName));
//		bl.checkText(testName, "if icon is visible / displayed", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "screen_landing_header_search", testName));
//		bl.checkText(testName, "if icon is visible / displayed", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "screen_landing_header_help", testName));
//		bl.checkText(testName, "if icon is visible / displayed", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "screen_landing_header_solution", testName));
		
		bl.checkText(testName, "if menu item is displayed correctly", prop.getPropValue(porperFileText, "screen_landing_navi_col1_item1"), bl.getElementText(testDriver, "xpath", properFileXpath, "screen_landing_navi_col1_item1", testName));
	}
	
	public static void createCSVExport(WebDriver testDriver, String testName) throws IOException {
		testName = testName + pageLayer;
		
		bl.bClick(testDriver, "xpath", properFileXpath, "screen_landing_subheader_create", "noScroll", testName);
		
		WebElement webEl = bl.getWebTextElement(testDriver, "coral_list_item_content", "CSV Report");
		webEl.click();
	}
	
	public static void sClick(WebDriver testDriver, String objRef, String scrollOption, String testName) throws IOException, InterruptedException {
		testName = testName + pageLayer;
		
		bl.bClick(testDriver, "xpath", properFileXpath, objRef, scrollOption, testName);
	}
	
	public static void navigateTo(WebDriver testDriver, String target, String testName) throws IOException, InterruptedException {
		if (target.equalsIgnoreCase("Demo")) {
			sClick(testDriver, "screen_landing_navi_col1_item1", "noScroll", testName);
			sClick(testDriver, "screen_landing_navi_col1_col2_item1", "noScroll", testName);
			//...
			
		}else {
			
		}
		
	}
	
	public static void openNewWebsite(WebDriver testDriver, String objRef, String testName) throws IOException, InterruptedException {
		
		handle = testDriver.getWindowHandle();
		sClick(testDriver, objRef, "noScroll", testName);
		
		@SuppressWarnings({"unused", "rawtypes"})
		Set handles = testDriver.getWindowHandles();
		
		for (String handle1 : testDriver.getWindowHandles()) {
			testDriver.switchTo().window(handle1);
		}
		BaseLibrary.sleep(BaseLibrary.sleepTimeVeryLong);
	}

}
