package basescripts;

import java.io.IOException;

import org.testng.annotations.Test;

public class BaseSetupEnvEnd {

	@Test(priority=1)
	public  void createaemReportClose() throws IOException, InterruptedException {
		BaseReport.createaemReportFooter();
	}
	
	public static void killAllGeckoProcess() throws IOException, InterruptedException {
		
		Runtime runtime = Runtime.getRuntime();
		Process process1, process2, process3, process4;
		
		try {
			process1 = Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe /F");
			process2 = Runtime.getRuntime().exec("taskkill /F /IM chrome.exe /F");
			process3 = Runtime.getRuntime().exec("taskkill /F /IM firefox.exe /F");
			process4 = runtime.exec("taskkill /F /IM geckodriver.exe /F");
			
			System.out.println("TASK KILL process1=" + process1);
			System.out.println("TASK KILL process2=" + process2);
			System.out.println("TASK KILL process3=" + process3);
			System.out.println("TASK KILL process4=" + process4);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void cClose(String cCount1) throws IOException, InterruptedException {
		//Integer cCount = null;
		//return BaseReport.checkedCount(cCount.toString());
		
	}
}
