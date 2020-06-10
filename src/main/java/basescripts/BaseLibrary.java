package basescripts;

import java.awt.AWTException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.apache.pdfbox.io.RandomAccessBufferedFileInputStream;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

/**
 * 
 * @author M. Hornberger
 * This class contains a collection of Methods to use in Testscripts
 */

/* Changes the wait functionality of Browser/WebPage to a more reliable cycle */
public class BaseLibrary {
public static final Integer sleepTimeMiniShortRobot=100;
public static final Integer sleepTimeShort=500;
public static final Integer sleepTimeShortMedium=1000;
public static final Integer sleepTimeMedium=2000;
public static final Integer sleepTimeLong=4000;
public static final Integer sleepTimeVeryLong=6000;

public static BaseProperties proper = new BaseProperties();
public static String searchResultCounter = null;

public static String configFile = "config.properties";
public static String pdf = "";
public static String pdfURL = "";


/** 
 * 
 * switch focus to a iFrame
 * throws InterruptedException
 * 
 * */
public void switchToIFrame(WebDriver testDriver) throws InterruptedException {
	testDriver.switchTo().defaultContent(); // jumps to the entry start point
	testDriver.switchTo().frame(0); // jumps to the first, identified IFrame
	Thread.sleep(sleepTimeShortMedium);
}

/** 
 * 
 * forces a click on a blind/ forced position 
 * throws IOException
 * 
 * */
public void bClick(WebDriver testDriver, String locator, String properfile, String objRef, String scrollOption, String testName) throws IOException {
	WebElement clickEl = getWebElement(testDriver, locator, properfile, objRef, testName);
	if (scrollOption.equalsIgnoreCase("scroll")) {
		scrollTo(testDriver, properfile, objRef);
	}
	clickEl.click();
}

/** 
 * 
 * locate and check textpassages with defined text
 * throws IOException
 * */
public void checkText(WebDriver testDriver, String locator, String properfile, String objRef, String cQuestion, String expectedStr, String testName) throws IOException {
	String foundStr = "STRING NOT FOUND";
	WebElement webEl = null;
	webEl = getWebElement(testDriver, locator, properfile, objRef, testName);
	
	foundStr = webEl.getText().trim();
	
	if (!foundStr.equals(foundStr)) {
		BaseReport.createaemReportAdding(testName, cQuestion, expectedStr, foundStr, "");
			
	}
	else {// xpath not found
		String errXpath = proper.getPropValue(properfile, objRef);
		BaseReport.createaemReportAdding(testName, cQuestion, expectedStr, "", errXpath);
		System.err.println(testName + ":checkText() --->" + properfile + "<===>" + objRef);
	}
}

/** 
 * 
 * same text check without object references
 * */
public void checkText(String testName, String cQuestion, String expectedStr, String foundStr) throws IOException {
	BaseReport.createaemReportAdding(testName, cQuestion, expectedStr, foundStr.trim(), "");
}


public String getElementText(WebDriver testDriver, String locator, String properFile, String objRef, String testName) throws IOException {
	String foundStr = "STRING NOT FOUND";
	WebElement webEl = null;
	webEl = getWebElement(testDriver, locator, properFile, objRef, testName);
	
	foundStr = webEl.getText().trim();
	
	return foundStr;
}


/** 
 * 
 * fills input fields
 * 
 * */
public void fillInputField(WebDriver testDriver, String locator, String properfile, String objRef, String value, String testName) throws IOException {
	WebElement webEl = null;
	webEl = getWebElement(testDriver, locator, properfile, objRef, testName);
	
	try {
		webEl.click();
		webEl.clear();
		webEl.sendKeys(value);
		Thread.sleep(sleepTimeShort);
	} catch(Exception e) {
}		System.err.println(testName + "fillInputField() --->" + proper + "<===>" + objRef);
}

/** 
 * 
 * checks and highlights an menu option
 * 
 * */
public void selectListBox(WebDriver testDriver, String testName, String properfile, String objRef, String optionText) throws IOException {
	Select dropdown = new Select (testDriver.findElement(By.xpath(proper.getPropValue(properfile, objRef))));
	dropdown.selectByVisibleText(optionText);
	checkText(testName, "if selected option is displayed correctly from the menu", optionText, dropdown.getFirstSelectedOption().getText());
}

/** 
 * 
 * select and activate an menu option
 * 
 * */
public String getSelectedDropdownItem(WebDriver testDriver, String testName, String properfile, String objRef) throws IOException{
	
	Select dropdown = new Select (testDriver.findElement(By.xpath(proper.getPropValue(properfile, objRef))));
	return dropdown.getFirstSelectedOption().getText();
}

/** 
 * 
 * select all entries from a menu
 * 
 * */
public Integer getAllDropdownOptions(WebDriver testDriver, String testName, String properfile, String objRef) throws IOException {
	
	WebElement elem = testDriver.findElement(By.xpath(proper.getPropValue(properfile, objRef)));
	List <WebElement> options = elem.findElements(By.tagName("options"));
	
	return options.size();
}

/** 
 * 
 * a scroll method for different browser behaviors
 * 
 * */
public void scrollTo(WebDriver testDriver, String properfile, String objRef) throws IOException {
	
	WebElement webEl = null;
	String webObj = proper.getPropValue(properfile, objRef);
	
	if (testDriver instanceof ChromeDriver || testDriver instanceof FirefoxDriver) {
		try {
			webEl = testDriver.findElement(By.xpath(webObj));
			((JavascriptExecutor) testDriver).executeScript("arguments[0].scrollIntoView()", webEl);
			}		catch (Exception e) {
				System.err.println("scrollTo() --->" + proper.getPropValue(properfile, objRef));
			}
}
}
/** 
 * 
 * select the option from the menu
 * 
 * */
public String getDropdownSelectedItem(WebDriver testDriver, String properfile, String ddObj) throws IOException {
	Select select = new Select(testDriver.findElement(By.xpath(proper.getPropValue(properfile, ddObj))));
	WebElement option =select.getFirstSelectedOption();
	
	return option.getText();
}
/** 
 * 
 * 
 * useful identifier for Web elements
 * 
 * */
public static WebElement getWebElement(WebDriver testDriver, String locator, String properfile, String objRef, String testName) throws IOException {
	
	WebElement webEl = null;
	String webObj = proper.getPropValue(properfile, objRef);
	
	try {
		switch (locator.toLowerCase()) {
		case "id":
			webEl = testDriver.findElement(By.id(webObj));
			break;
		case "name":
			webEl = testDriver.findElement(By.name(webObj));
			break;
		case "xpath":
			webEl = testDriver.findElement(By.xpath(webObj));
			break;
		case "classname":
			webEl = testDriver.findElement(By.className(webObj));
			break;
		case "linktext":
			webEl = testDriver.findElement(By.linkText(webObj));
			break;
			
	default:
		throw new IllegalArgumentException("WEBELEMENT_NOT_FOUND:" + properfile + "<===>" + objRef);
		}
	
	}catch (Exception ex) {
		System.err.println(testName + ":getElementText () --->" + proper.getPropValue(properfile, objRef));
	}
	webEl = fluentWaitforElement(testDriver, webEl);
	return webEl;
}
/** 
 * 
 * get and check a text from a web element 
 * 
 * */
public WebElement getWebTextElement(WebDriver testDriver, String locator, String searchString) throws IOException {
	
	WebElement webEl = null;
	
	String testObj = "//" + locator + "[contains(text(), '"+ searchString +"')]";
	webEl = testDriver.findElement(By.xpath(testObj));
	return webEl;
}
/** 
 * 
 * checks the unchecked status of a dynamic menu
 * 
 * */
public static String getCheckboxStatus(WebDriver testDriver, String locator, String properfile, String objRef, String attributValue, String testName) throws IOException {
	
	String boo ="false";
	WebElement webEl = null;
	webEl = getWebElement(testDriver, locator, properfile, objRef, testName);
	
	try {
		boo = webEl.getAttribute(attributValue);
		if (boo.equalsIgnoreCase("true")) {
			boo = "true";
			
		}
		} catch (Exception e) {
		  return boo;
	}	
	return boo;
}
/** 
 * 
 * this method regulates the waiting behavior outside the standard wait
 * 
 * */
public static WebElement fluentWaitforElement(WebDriver testDriver, WebElement el) throws IOException {
	
	@SuppressWarnings("deprecation")

	FluentWait<WebDriver> fwait = new FluentWait<WebDriver>(testDriver).withTimeout(20, TimeUnit.SECONDS).pollingEvery(500, TimeUnit.MILLISECONDS)
	.ignoring(NoSuchElementException.class, TimeoutException.class).ignoring(StaleElementReferenceException.class);
	
	for (int i = 0; i < 5; i++) {
		try {
			fwait.until(ExpectedConditions.visibilityOf(el));
			fwait.until(ExpectedConditions.elementToBeClickable(el));
		} catch (Exception e) {
			System.err.println("Element not found trying again - " + el.toString().substring(70));
		}
		
	}
	return el;
}
/** 
 * 
 * checks the content of tables
 * 
 * */
public static String getTableContent(WebDriver testDriver, String tableClassName, String searchString) throws IOException {
	
	String tdContent = null;
	
	WebElement Webtable = testDriver.findElement(By.className(tableClassName)); //replaces the Table ID with the actual ID or XPath
	List<WebElement> TotalRowCount = Webtable.findElements(By.xpath("//tr"));
	
	Integer searchResultCounterTemp = TotalRowCount.size() - 1; 
	searchResultCounter = Integer.toString(searchResultCounterTemp);
	
	System.out.println("No. of Rows in the Webtable: " + TotalRowCount.size());
	
	int RowIndex = 1;
	for (WebElement rowElement:TotalRowCount) {
		List<WebElement> TotalColumnCount = rowElement.findElements(By.xpath("td"));
		int ColumnIndex = 1;
		
		for (WebElement colElement:TotalColumnCount) {
		
		if (colElement.getText().equalsIgnoreCase(searchString)) {
			tdContent = colElement.getText();
			System.err.println("Found in: " + "Row " + RowIndex + "Column " + ColumnIndex + "Data " + colElement.getText());
		}else {
			System.err.println("Found other Data: " + "Row" + RowIndex + "Column " + ColumnIndex + "Data " + colElement.getText());
		}
		ColumnIndex = ColumnIndex + 1;
	}
	RowIndex = RowIndex + 1;
}
	return tdContent;
}
/** 
 * 
 * checks the availability of an icon
 * 
 * */
public String isIconDisplayed(WebDriver testDriver, String locator, String properfile, String objRef, String testName) throws IOException {
	
	Boolean boo = false;
	WebElement webEl = null;
	
	try {
		webEl = getWebElement(testDriver, locator, properfile, objRef, testName);
		boo = webEl.isDisplayed();
	} catch (Exception e){
		System.err.println(testName + "isIconDisplayed() --->" + proper.getPropValue(properfile, objRef));
		return boo.toString();
	}
	return boo.toString();
}
/** 
 * 
 * extra timer
 * 
 * */
public static void sleep(Integer timer) throws InterruptedException {
	Thread.sleep(timer);
}

public static String getPDF() {
	return pdf;
}

public static String getpdfURL() {
	return pdfURL;
}



public String ReadPDF(String foundStr) throws IOException , InterruptedException, AWTException{
	
	//Boolean cast = true;
	
	pdf = proper.getPropValue(configFile, "PDFName");
	pdfURL = proper.getPropValue(configFile, "PDFurl");
	URL TestURL = new URL(pdfURL +  pdf);
	RandomAccessBufferedFileInputStream TestFile = new RandomAccessBufferedFileInputStream(TestURL.openStream());
	PDFParser TestPDF = new PDFParser((RandomAccessRead) TestFile);
	TestPDF.parse();
	
	String TestText = new PDFTextStripper().getText(TestPDF.getPDDocument());
	if (TestText.contains(foundStr)) {
	Assert.assertTrue(TestText.contains(foundStr));
	TestText = new String(foundStr);
	return TestText;
	}else {
		Assert.assertFalse(TestText.contains(foundStr));
		System.err.println(foundStr + " is not part of this document");
		return null + " "+ foundStr + " is not part of this doc";
		}
	

	}


}
