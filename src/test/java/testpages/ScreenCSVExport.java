package testpages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import basescripts.BaseLibrary;
import basescripts.BaseProperties;



public class ScreenCSVExport {
	
	public static String propertiesFileXpath = "screen_csvexport_xpath.properties";
	public static String propertiesFileText = "screen_csvexport_text.properties";
	public static BaseLibrary bl = new BaseLibrary();
	public static BaseProperties proper = new BaseProperties();
	public static String pageLayer = "ScreenCSVExport";
	
	public static void checkScreenElements(WebDriver testDriver, String testName) throws IOException {
		testName = testName + pageLayer;
		
		bl.checkText(testName, "if checkbox 'modified' is checked", "true", BaseLibrary.getCheckboxStatus(testDriver, "xpath", propertiesFileXpath, "screen_csvexport_xpath.propertis", pageLayer, testName));
	}

}
