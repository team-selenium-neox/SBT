package basescripts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	public static String configFile = "aem_config.properties";
	
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
		fw.write("<div style = \"position:absolute; left:5px; pedding:5px; spacing:5px; boarder: 1px solid #08298A; width: 1115px; height: 225px; background-color: #e8e8e8\"> \n");
//kack leerstell
	}
}
