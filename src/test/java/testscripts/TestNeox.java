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
import basescripts.BaseSetupEnvEnd;
import basescripts.BaseSetupEnvStart;
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
		BaseReport.createaemReportOpen(BaseReport.getDate("SDF1"));
				

	}
	@AfterTest
	public void tearDownBrowser() throws IOException, InterruptedException, AWTException {
		BaseBrowser.tearDown();
		BaseReport.createaemReportFooter();



	}

 	
	@Test
	public void testNeox() throws Exception {
		

		//BaseReport.createaemReportOpen(BaseReport.checkedCounter.toString());
		NeoxPerform.getCode();
		NeoxPerform.getHeader(testDriver, testName);
		NeoxPerform.getMenu(testDriver, "header_menu_name", testName);
		//NeoxPerform.getSlide(testDriver, "body_item_element2", testName);

		BaseReport.createaemReportSeparator();
		BaseReport.softAssertion.assertAll();
				
	}

}
