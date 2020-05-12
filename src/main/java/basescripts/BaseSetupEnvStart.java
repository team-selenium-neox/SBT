package basescripts;

import java.io.File;
import java.io.IOException;

//import org.codehaus.plexus.util.FileUtils;
import org.apache.commons.io.FileUtils;
//import org.apache.maven.shared.utils.io.FileUtils;
import org.testng.annotations.Test;

public class BaseSetupEnvStart {
	
	@Test(priority=1)
	public void createReportFolder() throws IOException, InterruptedException {
		String sourceLoc1 = "";
		String targetLoc1 = "";
		
		sourceLoc1 = BaseReport.aemReportPath + "screenshots";
		targetLoc1 = BaseReport.aemReportPath + "screenshots_" + BaseReport.getDate("SDF2");
		
		File dir1 = new File(sourceLoc1);
		File newName = new File(targetLoc1);
		
		if (dir1.isDirectory()) {
			dir1.renameTo(newName);
		}else {
			dir1.mkdir();
			dir1.renameTo(newName);
		}
		dir1.mkdir();
		
		
		String sourceLocation = "";
		sourceLocation = BaseReport.pdfDownloadPath;
		
		File source = new File(sourceLocation);
		File dest = new File(targetLoc1);
		
		try {
			FileUtils.copyDirectory(source, dest);
			System.out.println("****************************************************************");
			System.out.println("******INFO: BACKUP COPY SUCCESSFUL******************************");
			System.out.println("****************************************************************");
		}catch (IOException e) {
			System.out.println("****************************************************************");
			System.out.println("******INFO: BACKUP COPY FAILED *********************************");
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
