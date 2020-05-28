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
import testpages.SBTPerform;

public class TestSBT {
	
	public WebDriver testDriver;
	public BaseLibrary bl = new BaseLibrary();
	public static BaseProperties prop = new BaseProperties();
	public BaseRobot robo = new BaseRobot();
	public String testName = "TestSBT";
	
	
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
	public void testSBT() throws Exception {

		SBTPerform.getCode();
		BaseReport.createaemReportSeparator();
		BaseReport.createaemReportSeparator();
		SBTPerform.getHeader(testDriver, testName);


		BaseReport.createaemReportSeparator();
		BaseReport.softAssertion.assertAll();
		BaseReport.createaemReportSeparator();
				
	}
	@Test
	public void testSBT1() throws Exception {
		
		BaseReport.createaemReportSeparator();
		BaseReport.softAssertion.assertAll();
		SBTPerform.getMenu(testDriver, "header_menu_name", testName);
		
		BaseReport.createaemReportSeparator();
		BaseReport.softAssertion.assertAll();
		
		SBTPerform.getPDF(testDriver, testName);
		
	}

}
