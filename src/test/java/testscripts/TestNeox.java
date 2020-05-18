package testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basescripts.BaseBrowser;
import basescripts.BaseLibrary;
import basescripts.BaseProperties;
import basescripts.BaseReport;
import basescripts.BaseRobot;
import testpages.NeoxPerform;

public class TestNeox {
	
	public WebDriver testDriver;
	public BaseLibrary bl = new BaseLibrary();
	public static BaseProperties prop = new BaseProperties();
	public BaseRobot robo = new BaseRobot();
	public String testName = "TestNeox";
	
	@BeforeTest
	public void startBrowser() throws IOException, InterruptedException, AWTException {
		BaseBrowser.initBrowser();
		testDriver = BaseBrowser.getDriver();	
	}
	@AfterTest
	public void tearDownBrowser() throws IOException, InterruptedException, AWTException {
		BaseBrowser.tearDown();
	}
	
	@Test
	public void testNeox() throws Exception {
		
//		NeoxPerform.checkScreenElements(testDriver, "screen_landing_header_title",testName);
//		NeoxPerform.checkBlockText(testDriver, testName);
//		NeoxPerform.checkSlide(testDriver, "screen_landing_navi_arrow_buttonR", testName);
		NeoxPerform.getCode();
		NeoxPerform.getHeader(testDriver, testName);
		NeoxPerform.getMenu(testDriver, "header_menu_name", testName);
				
		BaseReport.createaemReportSeparator();
		BaseReport.softAssertion.assertAll();
	}

}
