package basescripts;

import java.io.File;
import java.io.IOException;

//import org.codehaus.plexus.util.FileUtils;
import org.apache.commons.io.FileUtils;
//import org.apache.maven.shared.utils.io.FileUtils;
import org.testng.annotations.Test;

public class BaseSetupEnvStart {
	
	@Test(priority=1)
	public static void createReportFolder() throws IOException, InterruptedException {
		String sourceLoc1 = "";
		String targetLoc1 = "";
		
		sourceLoc1 = BaseReport.aemReportPath + "screenshots";
		targetLoc1 = BaseReport.aemReportPath + "screenshots_" + BaseReport.getDateBack("SDF4") ;
		
		File dir1 = new File(sourceLoc1);
		File newName1 = new File(targetLoc1);
		
		if (dir1.isDirectory()) {
			dir1.renameTo(newName1);
		}else {
			dir1.mkdir();
			dir1.renameTo(newName1);
		}
		dir1.mkdir();
		
		
		String sourceLocation1 = "";
		sourceLocation1 = BaseReport.pdfDownloadPath;
		
		String sourceLocation2 = "";
		sourceLocation2 =BaseReport.aemReportPath + "screenshots";
		
		File source1 = new File(sourceLocation1);
		File source2 = new File(sourceLocation2);
		File dest = new File(targetLoc1);
		
		try {
			FileUtils.copyDirectory(source1, dest);
			System.out.println("****************************************************************");
			System.out.println("******INFO: PDF BACKUP COPY SUCCESSFUL**************************");
			System.out.println("****************************************************************");
		}catch (IOException e) {
			System.out.println("****************************************************************");
			System.out.println("******INFO: PDF BACKUP COPY FAILED *****************************");
			System.out.println("****************************************************************");
			e.printStackTrace();
		}
		
		try {
			FileUtils.copyDirectory(source2, dest);
			System.out.println("****************************************************************");
			System.out.println("******INFO: REPORT BACKUP COPY SUCCESSFUL***********************");
			System.out.println("****************************************************************");
		}catch (IOException e) {
			System.out.println("****************************************************************");
			System.out.println("******INFO: REPORT BACKUP COPY FAILED **************************");
			System.out.println("****************************************************************");
			e.printStackTrace();
		}
	}
	
	@Test(priority=2)
	public void createaemReportOpen() throws IOException {
		BaseReport.createaemReportOpen(BaseReport.getDate("SDF1"));
		
		}
	
	@Test(priority=3)
	public void delaemLogFiles()throws IOException, InterruptedException {
		String filePath1 = BaseBrowser.getFileDir("logDir") + "aem.log";
		String filePath2 = BaseBrowser.getFileDir("logDir") + "testlog.log";
		String filePath3 = BaseBrowser.getFileDir("logDir") + "application.html";
		
		FileUtils.write(new File((filePath1)), "");
		FileUtils.write(new File((filePath2)), "");
		FileUtils.write(new File((filePath3)), "");
		
	}

}
