package testpages;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import basescripts.BaseCredential;
import basescripts.BaseLibrary;
import basescripts.BaseProperties;
import basescripts.BaseRobot;

public class SBTPerform {
	
	public static String properFileXpath = "sbt_landing_xpath.properties";
	public static String porperFileText = "sbt_landing_text.properties";
	public static BaseLibrary bl = new BaseLibrary();
	public static BaseProperties prop = new BaseProperties();
	public static BaseCredential cred = new BaseCredential();
	public static BaseRobot rob = new BaseRobot();
	public static String pageLayer = " SBTPerform";
	public static String handle = null;

public static void getCode() throws Exception {
	
	cred.encodeCredential();
}	
public static void getHeader(WebDriver testDriver, String testName) throws Exception {
	testName = testName + pageLayer;
	bl.checkText(testName, "is Displayed", prop.getPropValue(porperFileText, "screen_landing_header_title"), bl.getElementText(testDriver, "xpath", properFileXpath, "screen_landing_header_title", testName));

}
public static void sClick(WebDriver testDriver, String objRef, String scrollOption, String testName) throws IOException, InterruptedException {
	testName = testName + pageLayer;
	
	bl.bClick(testDriver, "xpath", properFileXpath, objRef, scrollOption, testName);
}

public static void getMenu(WebDriver testDriver, String target, String testName) throws Exception {
	testName = testName + pageLayer;
	
	bl.checkText(testName, "nav_button1", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "nav_button1", testName));
	bl.checkText(testName, "nav_button2", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "nav_button2", testName));
	bl.checkText(testName, "nav_button3", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "nav_button3", testName));
	bl.checkText(testName, "nav_button4", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "nav_button4", testName));
	bl.checkText(testName, "nav_side_entry1", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "nav_side_entry1", testName));
	//bl.checkText(testName, "nav_side_entry2", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "nav_side_entry2", testName));
	//sClick(testDriver, "header_menu_name", "noScroll",testName);

	Actions hover = new Actions(testDriver);
	WebElement Elem_to_hover = testDriver.findElement(By.id("menu-item-59"));
	hover.moveToElement(Elem_to_hover).build().perform();
	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);

	WebElement Elem_to_hover1 = testDriver.findElement(By.id("menu-item-65"));
	hover.moveToElement(Elem_to_hover1).build().perform();
	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
	bl.checkText(testName, "nav_sub_button1-1", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "nav_sub_button1-1", testName));
	
	WebElement Elem_to_hover3 = testDriver.findElement(By.id("menu-item-64"));
	hover.moveToElement(Elem_to_hover3).build().perform();
	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
	bl.checkText(testName, "nav_sub_button1-2", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "nav_sub_button1-2", testName));
	
	WebElement Elem_to_hover4 = testDriver.findElement(By.id("menu-item-80"));
	hover.moveToElement(Elem_to_hover4).build().perform();
	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
	
	bl.checkText(testName, "nav_sub_button1-3", "true", bl.isIconDisplayed(testDriver, "xpath", properFileXpath, "nav_sub_button1-3", testName));
	
	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);

}

public static void getPDF(WebDriver testDriver, String testName) throws Exception {
	
	Actions hover = new Actions(testDriver);
	WebElement Elem_to_hover = testDriver.findElement(By.id("menu-item-59"));
	hover.moveToElement(Elem_to_hover).build().perform();
	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);

	WebElement Elem_to_hover1 = testDriver.findElement(By.id("menu-item-65"));
	hover.moveToElement(Elem_to_hover1).build().perform();
	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
	sClick(testDriver, "nav_sub_button1-2", "noScroll", testName);
	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
	
	
	sClick(testDriver, "nav_dlb_pdf", "noScroll", testName);
	//bl.getPdfText();
	//bl.ReadPDF();
	
	BaseLibrary.sleep(BaseLibrary.sleepTimeLong);
	BaseLibrary.sleep(BaseLibrary.sleepTimeLong);
	
}
//public static void getSlide(WebDriver testDriver, String target, String testName) throws Exception {
//	bl.scrollTo(testDriver, properFileXpath, "body_item_element2");
//	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
//	sClick(testDriver, "body_item_element3", "npScroll", testName);
//	BaseLibrary.sleep(BaseLibrary.sleepTimeMedium);
//}


}
