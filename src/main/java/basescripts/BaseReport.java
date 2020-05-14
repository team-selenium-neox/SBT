package basescripts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.maven.shared.utils.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

public class BaseReport {
	
	public static String basePath = Stream.of("C:", "Benutzer", "RouxLoki", "Projekt Neox").collect(Collectors.joining(File.separator)) + File.separator;
	public static String browserDriverPath = Stream.of(System.getProperty("user.dir"), "BrowserDrivers").collect(Collectors.joining(File.separator)) +File.separator;
	public static String pdfDownloadPath = Stream.of(System.getProperty("user.dir"), "aemReport", "downloadPDF").collect(Collectors.joining(File.separator)) + File.separator;
	public static String aemReportPath = Stream.of(System.getProperty("user.dir"), "aemReport").collect(Collectors.joining(File.separator)) + File.separator;
	public static String LogPath = Stream.of(System.getProperty("user.dir"), "aemReport", "aemLogs").collect(Collectors.joining(File.separator)) + File.separator;
	
	public static BaseProperties proper = new BaseProperties();
	public static BaseLibrary bl = new BaseLibrary();
	
	public static Integer checkedCounter = 0;
	public static Integer passedCounter = 0;
	public static Integer failedCounter = 0;
	public static String screenshotFile = "";
	public static String screenshotFileLink = "";
	public static String errMsg1 = "Searched String does not match!";
	public static String startTime = "";
	public static String endTime = "";
	
	public static SoftAssert softAssertion = new SoftAssert();
	
	public static String browser = "";
	public static String browserHeadLess = "chrome (headless)";
	public static String bversion = "";
	public static String reportName = "aemReport.htm";
	public static String configFile = "config.properties";
	
	private static final SimpleDateFormat SDF1 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"); // Timestamp for Report
	private static final SimpleDateFormat SDF2 = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"); // Timestamp for Error screenshot
	
	/** 
	 * 
	 * this method creates the header of the Report
	 * 
	 * */
	public static void createaemReportOpen(String currentDate) throws IOException {
		
		String fileName = "";
		fileName = aemReportPath + "screenshots" + File.separator + reportName;
		
		FileWriter fw = new FileWriter(fileName, true);
		
		fw.write("<html>\n");
		fw.write("<head>\n");
		fw.write("<title>AEM</title>\n");
		
		fw.write("<style>\n");
		fw.write("<!--\n");
		
		fw.write("a:link {color:#ffffff;}\n");
		fw.write("a:visited {color:#000000;}\n");
		fw.write("a:active {color:#ffffff;}\n");
		
		fw.write("body {\n");
		fw.write("font-family: Verdana,Arial,Helvetica,sans-serif;\n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write("table.fixed {\n");
		fw.write("table-layout:fixed; width:1100px; word-break:break-all;\n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write("table.fixed {\n");
		fw.write("overflow:hidden; {\n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".aemCellBlue {\n");
		fw.write("font-weight:bold; \n");
		fw.write("background-color: #08298A; \n");
		fw.write("color: #ffffff; \n");
		fw.write("font-size: 12px; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".aemCellYellow {\n");
		fw.write("font-weight:bold; \n");
		fw.write("background-color: #FFFF99; \n");
		fw.write("font-size: 12px; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".aemCellGrey {\n");
		fw.write("font-weight:bold; \n");
		fw.write("background-color: #E8E8E8; \n");
		fw.write("font-size: 12px; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".aemCellGreyNormal {\n");
		fw.write("font-weight:normal; \n");
		fw.write("background-color: #E8E8E8; \n");
		fw.write("width; 800px \n");
		fw.write("font-size: 12px; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".aemCellWhite {\n");
		fw.write("font-weight:bold; \n");
		fw.write("background-color: #FFFFFF; \n");
		fw.write("font-size: 12px; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".aemCellWhiteNormal {\n");
		fw.write("font-weight:normal; \n");
		fw.write("background-color: #FFFFFF; \n");
		fw.write("font-size: 12px; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".aemCellGreen {\n");
		fw.write("font-weight:bold; \n");
		fw.write("background-color: #33FF00; \n");
		fw.write("font-size: 12px; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".aemCellGreenNormal {\n");
		fw.write("font-weight:normal; \n");
		fw.write("background-color: #33FF00; \n");
		fw.write("font-size: 12px; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".aemCellRed {\n");
		fw.write("font-weight:bold; \n");
		fw.write("background-color: #FF0000; \n");
		fw.write("color: #FFFFFF; \n");
		fw.write("font-size: 12px; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".aemCellRedNormal {\n");
		fw.write("font-weight:normal; \n");
		fw.write("background-color: #FF0000; \n");
		fw.write("color: #FFFFFF; \n");
		fw.write("font-size: 12px; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".displayField {\n");
		fw.write("font-weight:bold; \n");
		fw.write("background-color: #E8E8E8; \n");
		fw.write("border:1px solid: #E8E8E8; \n");
		fw.write("width; 40px \n");
		fw.write("font-size: 13px; \n");
		fw.write("color: #08298A; \n");
		fw.write("text-align: center; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write(".displayFieldInfo {\n");
		fw.write("font-weight:bold; \n");
		fw.write("background-color: #E8E8E8; \n");
		fw.write("border:0px solid: #E8E8E8; \n");
		fw.write("width; 110px \n");
		fw.write("font-size: 13px; \n");
		fw.write("color: #000000; \n");
		fw.write("text-align: left; \n");
		fw.write("}\n");
		fw.write("\n");
		
		fw.write("--> \n");
		fw.write("</style> \n");
		
		fw.write("<script> \n");
		fw.write("function setValue(c,p,f,b,v,s,e) {\n");
		fw.write("document.getElementById(\"cField\").value=c; \n");
		fw.write("document.getElementById(\"pField\").value=p; \n");
		fw.write("document.getElementById(\"fField\").value=f; \n");
		fw.write("document.getElementById(\"browserField\").value=b; \n");
		fw.write("document.getElementById(\"versionField\").value=v; \n");
		fw.write("document.getElementById(\"startTime\").value=s; \n");
		fw.write("document.getElementById(\"endTime\").value=e; \n");
		fw.write("}\n");
		fw.write("</script> \n");
		
		fw.write("</head>\n");
		fw.write("<body>\n");
		fw.write("<form name=\"myForm>\" \n");
		fw.write("<div style = \"position:absolute; left:5px; padding:5px; spacing:5px; boarder: 1px solid #08298A; width: 1115px; height: 225px; background-color: #e8e8e8\"> \n");
		fw.write("<table width=\"1102\"> \n");
		fw.write("<tr> \n");
		fw.write("<td colspan=\"2\" class=\"aemCellGrey\" style=\"color:#0829A8; font-size:20px;\">SBT-Report</td> \n");
		fw.write("</tr> \n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellGrey\"> Short Description:&#160; </td><td class=\"aemCellGreyNormal\">SBT-Report-Regression-Test \n");
		fw.write("</tr> \n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellGrey\"> Execution Date:&#160; </td><td class=\"aemCellGreyNormal\"> \n");
		fw.write(currentDate);
		fw.write("</td> \n");
		fw.write("</tr> \n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellGrey\"> Test Object:&#160; </td><td class=\"aemCellGreyNormal\">"+proper.getPropValue(configFile, "projectname")+"</td> \n");
		fw.write("</tr> \n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellGrey\"> OS System:&#160; </td><td class=\"aemCellGreyNormal\"> \n");
		fw.write(System.getProperty("os.name"));
		fw.write("</td> \n");
		fw.write("</tr> \n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellGrey\"> JDK:&#160; </td><td class=\"aemCellGreyNormal\"> \n");
		fw.write(System.getProperty("java.runtime.version"));
		fw.write("</td> \n");
		fw.write("</tr> \n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellGrey\"> Browser:&#160; </td><td class=\"aemCellGreyNormal\"><input type=\"text\" id=\"browserField\" class=\"displayFieldInfo\" value=''\" \n");
		fw.write("</tr> \n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellGrey\"> Test Environment:&#160; </td><td class=\"aemCellGreyNormal\">"+proper.getPropValue(configFile, "targetEnv")
		+ "<input type='text' id='spacer' class='displayFieldInfo' value='' readonly style='width:252px;'/>"
		+ "<input type='text' id='startTimeLabel' class='displayFieldInfo' value='Start-Time' readonly style='width:70px;'/>"
		+ "<input type='text' id='startTime' class='displayFieldInfo' value='' readonly style='width:98px;'/>"
		+ "<input type='text' id='endTimeLabel' class='displayFieldInfo' value='End-Time' readonly style='width:65px;'/>"
		+ "<input type='text' id='endTime' class='displayFieldInfo' value='' readonly />"
		+ "</td>\n");
		fw.write("</tr> \n");
		fw.write("</table> \n");
		
		fw.write("<table width=\"1102\">\n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellGrey\" width=\"600\" style=\"color:#08298A; font-size:13px;\">&#160;</td> \n");
		fw.write("<td class=\"aemCellGrey\" width=\"0\" style=\"color:#08298A; font-size:13px;\">Checks: <input type=\"text\" id=\"cField\" class=\"displayField\" value='';</td> \n");
		fw.write("<td class=\"aemCellGrey\" width=\"0\" style=\"color:#08298A; font-size:13px; color: green\">Passed: <input type)\"text\" id=\"pField\" class=\"displayField\" value='';</td> \n");
		fw.write("<td class=\"aemCellGrey\" width=\"0\" style=\"color:#08298A; font-size:13px; color: red\">Failed: <input type)\"text\" id=\"fField\" class=\"displayField\" value='';</td> \n");
		fw.write("</tr> \n");
		fw.write("</table> \n");
		
		fw.write("</div>\n");
		fw.write("<br/>\n");
		fw.write("<div style = \"position:absolute; left:-1px; padding:5px; spacing:5px; boarder: 1px solid #08298A; width: 1115px; height: 225px; background-color: #e8e8e8\"> \n");
		fw.close();
		
		startTime = getDate("SDF1").substring(11);
		
	}
	
	/** 
	 * 
	 * generate the Report
	 * 
	 * */
	public static void createaemReportAdding(String methodname, String checkQuestion, String expectedStr, String foundStr, String errMsg) throws IOException {
		
		String mPassed = "PASSED";
		String mFailed = "FAILED";
		
		checkedCounter = checkedCounter +1;
		
		String fileName = "";
		
		fileName = aemReportPath +"screenshots" + File.separator + reportName;
		
		FileWriter fw = new FileWriter(fileName, true);
		
		fw.write("<table border=\"1\" class=\"fixed\">\n");
		fw.write("<col width=\"299px\"/>\n");
		fw.write("<col width=\"299px\"/>\n");
		fw.write("<col width=\"54px\"/>\n");
		fw.write("<col width=\"80px\"/>\n");
		fw.write("<col width=\"370px\"/>\n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellBlue\" colspan=\"5\">");
		fw.write(methodname);
		fw.write("</td> \n");
		fw.write("</tr> \n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellYellow\" colspan=\"5\">Check:");
		fw.write("&#160;");
		fw.write(checkQuestion);
		fw.write("</td> \n");
		fw.write("</tr> \n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellGrey\">Target State</td>\n");
		fw.write("<td class=\"aemCellGrey\">Current State</td>\n");
		fw.write("<td class=\"aemCellGrey\" style=\"text-align:center;\"> State</td>\n");
		fw.write("<td class=\"aemCellGrey\" style=\"text-align:center;\"> Screenshot</td>\n");
		fw.write("<td class=\"aemCellGrey\"> Error Msg</td>\n");
		fw.write("</tr> \n");
		fw.write("<tr> \n");
		fw.write("<td class=\"aemCellWhiteNormal\">");
		fw.write(expectedStr);
		fw.write("</td> \n");
		fw.write("<td class=\"aemCellWhiteNormal\">");
		fw.write(foundStr);
		fw.write("</td> \n");
		
		if(!foundStr.isEmpty()) {
			if (expectedStr.equals(foundStr)) {
				softAssertion.assertEquals(foundStr, expectedStr);
				// ====PASSED====
				passedCounter = passedCounter +1;
				fw.write("<td class=\"aemCellWhiteNormal\" style=\"text-align:center;\">");
				fw.write(mPassed);
				fw.write("</td> \n");
				fw.write("<td class=\"aemCellWhiteNormal\" style=\"text-align:center;\"> </td>\n");
				fw.write("<td class=\"aemCellWhiteNormal\">");
				fw.write(errMsg);
				fw.write("</td> \n");
			}else {
				softAssertion.assertEquals(foundStr, expectedStr);
				// ====FAIL====
				failedCounter = failedCounter +1;
				takeScreenshot("string_not_matched");
				fw.write("<td class=\"aemCellRedNormal\" style=\"text-align:center;\">");
				fw.write(mFailed);
				fw.write("</td> \n");
				fw.write("<td class=\"aemCellRedNormal\" style=\"text-align:center;\"><A TARGET =\"_blank\" HREF=\"");
				fw.write(screenshotFileLink);
				fw.write("\">Screenshot</A></td>\n");
				fw.write("<td class=\"aemCellRedNormal\">");
				fw.write(errMsg1);
				fw.write("</td> \n");
			}
		}else {
			failedCounter = failedCounter +1;
			fw.write("<td class=\"aemCellRedNormal\" style=\"text-align:center;\">");
			fw.write(mFailed);
			fw.write("<td class=\"aemCellRedNormal\" style=\"text-align:center;\"><A TARGET =\"_blank\" HREF=\"");
			fw.write(screenshotFileLink);
			fw.write("\">Screenshot</A></td>\n");
			fw.write("<td class=\"aemCellRedNormal\">");
			fw.write(errMsg1);
			fw.write("</td> \n");
		}
		fw.write("</tr> \n");
		fw.write("</table>\n");
		fw.write("\n");
		
		fw.close();
	}
	public static void createaemReportFooter() throws IOException {
		
		String fileName = "";
		
		fileName = aemReportPath + "screenshots" + File.separator + reportName;
		
		FileWriter fw = new FileWriter(fileName, true);
		endTime = getDate("SDF1").substring(11);
		
		fw.write("\n");
		fw.write("\n");
		fw.write("<scripts>");
		if (proper.getPropValue(configFile, "chromeHeadless").equalsIgnoreCase("true")) {
			fw.write("setValue(" + checkedCounter + "," + passedCounter + "," + failedCounter + "," + "'" + browserHeadLess + "'" + "," + "'" + bversion + "'" + "," + "'" + startTime + "'" + "," + "'");
		} else {
			fw.write("setValue(" + checkedCounter + "," + passedCounter + "," + failedCounter + "," + "'" + browser + "'" + "," + "'" + bversion + "'" + "," + "'" + startTime + "'" + "," + "'");
		}
		fw.write("</scripts>");
		fw.write("\n");
		fw.write("\n");
		fw.write("</div>");
		fw.write("</form>\n");
		fw.write("</body>\n");
		fw.write("</html>\n");
		fw.close();		
	}
	public static void createaemReportSeparator() throws IOException {
		
		String fileName = "";
		
		fileName = aemReportPath + "screenshots" + File.separator + reportName; 
		
		FileWriter fw = new FileWriter(fileName, true);
		
		fw.write("<hr-witdth=\"1106\" align=\"left\" style=\"border:solid #2EFEF7 5px;\" />\n\n");
		fw.close();
		
	}
	
	public static String getDate(String format) throws IOException {
		String myDate = "";
		
		if (format.equalsIgnoreCase("SDF1")) {
			myDate = SDF1.format(new Date());
		}else {
			myDate = SDF2.format(new Date());
		}
		return myDate;
	}
	
	public static void setReportName(String reportValue) throws IOException {
		reportName = reportValue;
	}
	
	/** 
	 * 
	 * takes fail screenshots
	 * 
	 * */
	public static void takeScreenshot(String myTestName) throws IOException {
		
		WebDriver driver = BaseBrowser.getDriver();
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		String filePath = "";
		
		filePath = aemReportPath + "screenshots" + File.separator;
		BaseReport.screenshotFile = filePath + myTestName + "_" + BaseReport.getDate("SDF2") + ".png";
		BaseReport.screenshotFileLink = myTestName + "_" + BaseReport.getDate("SDF2") + ".png";
		FileUtils.copyFile(srcFile, new File(BaseReport.screenshotFile));		
	}
	
	
	
}
