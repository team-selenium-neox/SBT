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
import basescripts.BaseSetupEnvStart;
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
		BaseSetupEnvStart.createReportFolder();
		BaseReport.createaemReportOpen(BaseReport.getDate("SDF1"));
		
				

	}
	@AfterTest
	public void tearDownBrowser() throws IOException, InterruptedException, AWTException {
		BaseBrowser.tearDown();
		BaseReport.createaemReportFooter();
		BaseReport.createaemReportOpen(BaseReport.getDate("SDF1"));



	}

 	
	@Test
	public void testSBT() throws Exception {

		SBTPerform.getCode();
		SBTPerform.getHeader(testDriver, testName);
		SBTPerform.getMenu(testDriver, "header_menu_name", testName);
		SBTPerform.getPDF(testDriver, "PDFName", testName);
		

		BaseReport.createaemReportSeparator();
		BaseReport.softAssertion.assertAll();
				
	}

}
