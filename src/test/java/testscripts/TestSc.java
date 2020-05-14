package testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import basescripts.BaseBrowser;
import basescripts.BaseCredential;
import basescripts.BaseLibrary;
import basescripts.BaseProperties;
import basescripts.BaseReport;
import basescripts.BaseRobot;
import testpages.ScreenCSVExport;
import testpages.ScreenLanding;
import testpages.ScreenLogin;

public class TestSc {
	
	public WebDriver testDriver;
	public BaseLibrary bl = new BaseLibrary();
	public static BaseProperties prop = new BaseProperties();
	public BaseRobot robo = new BaseRobot();
	public String testName = "TestSc";
	
	/** 
	 * 
	 * Load URL
	 * 
	 * */
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
//	public void testSc()throws Exception {
//		ScreenLogin.login(testDriver, "user1", "user2", testName);
//		
//		ScreenLanding.navigateTo(testDriver, "URLNAME", testName);
//		ScreenLanding.openNewWebsite(testDriver, "SCREENLANDING", testName);
//		//Next Screen after Landing eg.
//		//ScreenInsert.pageInformation(testDriver, "startWorkFlow", "SCREEN_INSERT...", testName);
//		//ScreenInsert.setWorkflowPopupLayer(testDriver, "unlock", "SCRE...", testName);
//		
//		ScreenLanding.createCSVExport(testDriver, testName);
//		ScreenLanding.sClick(testDriver, "SCREENLANDING...", "noScroll", testName);
//		ScreenCSVExport.checkScreenElements(testDriver, testName);
//		
//		BaseReport.createaemReportSeparator();
//		BaseReport.softAssertion.assertAll();
//	}
	public void pass()throws Exception {
		
			String cred = "Annegret";
			
			String cryptedString = Base64.encodeBase64String(cred.getBytes());
			System.out.println(cryptedString);
		
	}
}
