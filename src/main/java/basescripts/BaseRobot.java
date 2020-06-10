package basescripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseRobot {
	
	public WebDriver testDriver = null;
	/** 
	 * 
	 * Arrow Key Settings
	 * 
	 * */
	public void scrollByKeyArrow(WebDriver testDriver, String direction, Integer iteration) throws AWTException, InterruptedException {
		if (testDriver instanceof ChromeDriver) {
			Integer i = 0;
			
			if (direction.equalsIgnoreCase("down")) {
				for (i=0; i<iteration; i++) {
					doTypeKey("down");
				}
			} else if (direction.equalsIgnoreCase("up")) {
				for (i=0; i<iteration; i++) {
					doTypeKey("up");
				}
			} else if (direction.equalsIgnoreCase("left")) {
				for (i=0; i<iteration; i++) {
					doTypeKey("left");
				}
			} else if (direction.equalsIgnoreCase("right")) {
				for (i=0; i<iteration; i++) {
					doTypeKey("right");
				}
			}
			BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot);
		}
	}
//	public void scrollByKeyArrows(WebDriver testDriver, String direction, Integer iteration) throws AWTException, InterruptedException {
//		if (testDriver instanceof ChromeDriver) {
//			Integer i = 0;
//			
//			if (direction.equalsIgnoreCase("down")) {
//				for (i=0; i<iteration; i++) {
//					doTypeKeys("down");
//				}
//			} else if (direction.equalsIgnoreCase("up")) {
//				for (i=0; i<iteration; i++) {
//					doTypeKeys("up");
//				}
//			} else if (direction.equalsIgnoreCase("left")) {
//				for (i=0; i<iteration; i++) {
//					doTypeKeys("left");
//				}
//			} else if (direction.equalsIgnoreCase("right")) {
//				for (i=0; i<iteration; i++) {
//					doTypeKeys("right");
//				}
//			}
//			BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot);
//		}
//	}
	/** 
	 * 
	 * IE Authentication 
	 * 
	 * */
	public void authenticate(WebDriver testDriver, String user, String pwd) throws IOException, InterruptedException {
		try {
			BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot);
			StringSelection username = new StringSelection("user");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
			doTypeKey("paste");
			doTypeKey("tab");
			
			StringSelection myPWD = new StringSelection(pwd);
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(myPWD, null);
			doTypeKey("paste");
			
			BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot);
			doTypeKey("enter");
			BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot);
		} catch (Exception ex) {
			System.err.println("ROBOT ERROR");
		}
	}
	/** 
	 * 
	 * Zooming Method
	 * 
	 * */
	public void zoomInOut (WebDriver testDriver, String zoomOption, Integer iteration) throws IOException, InterruptedException, AWTException {
		Integer i = 0;
		
		if(zoomOption.equalsIgnoreCase("zoomOut")) {
			for (i=0; i<iteration; i++) {
				doTypeKey("zoomOut");
			}
		} else if(zoomOption.equalsIgnoreCase("zoomIn")) {
			for (i=0; i<iteration; i++) {
				doTypeKey("zoomIn");
			}
		} else {
			System.out.println("Info: zoomInOut: do nothing");
		}
		
	}
	public void doTypeChar(char character) throws InterruptedException, AWTException {
		Robot robot = new Robot();
		
		switch (character) {
		case 'a': robot.keyPress(KeyEvent.VK_A); robot.keyRelease(KeyEvent.VK_A); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'b': robot.keyPress(KeyEvent.VK_B); robot.keyRelease(KeyEvent.VK_B); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'c': robot.keyPress(KeyEvent.VK_C); robot.keyRelease(KeyEvent.VK_C); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'd': robot.keyPress(KeyEvent.VK_D); robot.keyRelease(KeyEvent.VK_D); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'e': robot.keyPress(KeyEvent.VK_E); robot.keyRelease(KeyEvent.VK_E); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'f': robot.keyPress(KeyEvent.VK_F); robot.keyRelease(KeyEvent.VK_F); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'g': robot.keyPress(KeyEvent.VK_G); robot.keyRelease(KeyEvent.VK_G); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'h': robot.keyPress(KeyEvent.VK_H); robot.keyRelease(KeyEvent.VK_H); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'i': robot.keyPress(KeyEvent.VK_I); robot.keyRelease(KeyEvent.VK_I); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'j': robot.keyPress(KeyEvent.VK_J); robot.keyRelease(KeyEvent.VK_J); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'k': robot.keyPress(KeyEvent.VK_K); robot.keyRelease(KeyEvent.VK_K); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'l': robot.keyPress(KeyEvent.VK_L); robot.keyRelease(KeyEvent.VK_L); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'm': robot.keyPress(KeyEvent.VK_M); robot.keyRelease(KeyEvent.VK_M); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'n': robot.keyPress(KeyEvent.VK_N); robot.keyRelease(KeyEvent.VK_N); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'o': robot.keyPress(KeyEvent.VK_O); robot.keyRelease(KeyEvent.VK_O); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'p': robot.keyPress(KeyEvent.VK_P); robot.keyRelease(KeyEvent.VK_P); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'q': robot.keyPress(KeyEvent.VK_Q); robot.keyRelease(KeyEvent.VK_Q); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'r': robot.keyPress(KeyEvent.VK_R); robot.keyRelease(KeyEvent.VK_R); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 's': robot.keyPress(KeyEvent.VK_S); robot.keyRelease(KeyEvent.VK_S); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 't': robot.keyPress(KeyEvent.VK_T); robot.keyRelease(KeyEvent.VK_T); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'u': robot.keyPress(KeyEvent.VK_U); robot.keyRelease(KeyEvent.VK_U); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'v': robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_V); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'w': robot.keyPress(KeyEvent.VK_W); robot.keyRelease(KeyEvent.VK_W); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'x': robot.keyPress(KeyEvent.VK_X); robot.keyRelease(KeyEvent.VK_X); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'y': robot.keyPress(KeyEvent.VK_Y); robot.keyRelease(KeyEvent.VK_Y); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'z': robot.keyPress(KeyEvent.VK_Z); robot.keyRelease(KeyEvent.VK_Z); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'A': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_A); robot.keyRelease(KeyEvent.VK_A); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'B': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_B); robot.keyRelease(KeyEvent.VK_B); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'C': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_C); robot.keyRelease(KeyEvent.VK_C); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'D': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_D); robot.keyRelease(KeyEvent.VK_D); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'E': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_E); robot.keyRelease(KeyEvent.VK_E); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'F': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_F); robot.keyRelease(KeyEvent.VK_F); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'G': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_G); robot.keyRelease(KeyEvent.VK_G); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'H': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_H); robot.keyRelease(KeyEvent.VK_H); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'I': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_I); robot.keyRelease(KeyEvent.VK_I); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'J': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_J); robot.keyRelease(KeyEvent.VK_J); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'K': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_K); robot.keyRelease(KeyEvent.VK_K); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'L': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_L); robot.keyRelease(KeyEvent.VK_L); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'M': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_M); robot.keyRelease(KeyEvent.VK_M); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'N': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_N); robot.keyRelease(KeyEvent.VK_N); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'O': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_O); robot.keyRelease(KeyEvent.VK_O); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'P': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_P); robot.keyRelease(KeyEvent.VK_P); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'Q': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_Q); robot.keyRelease(KeyEvent.VK_Q); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'R': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_R); robot.keyRelease(KeyEvent.VK_R); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'S': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_S); robot.keyRelease(KeyEvent.VK_S); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'T': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_T); robot.keyRelease(KeyEvent.VK_T); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'U': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_U); robot.keyRelease(KeyEvent.VK_U); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'V': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_V); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'W': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_W); robot.keyRelease(KeyEvent.VK_W); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'X': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_X); robot.keyRelease(KeyEvent.VK_X); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'Y': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_Y); robot.keyRelease(KeyEvent.VK_Y); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case 'Z': robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_Z); robot.keyRelease(KeyEvent.VK_Z); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '0': robot.keyPress(KeyEvent.VK_0); robot.keyRelease(KeyEvent.VK_0); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '1': robot.keyPress(KeyEvent.VK_1); robot.keyRelease(KeyEvent.VK_1); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '2': robot.keyPress(KeyEvent.VK_2); robot.keyRelease(KeyEvent.VK_2); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '3': robot.keyPress(KeyEvent.VK_3); robot.keyRelease(KeyEvent.VK_3); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '4': robot.keyPress(KeyEvent.VK_4); robot.keyRelease(KeyEvent.VK_4); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '5': robot.keyPress(KeyEvent.VK_5); robot.keyRelease(KeyEvent.VK_5); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '6': robot.keyPress(KeyEvent.VK_6); robot.keyRelease(KeyEvent.VK_6); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '7': robot.keyPress(KeyEvent.VK_7); robot.keyRelease(KeyEvent.VK_7); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '8': robot.keyPress(KeyEvent.VK_8); robot.keyRelease(KeyEvent.VK_8); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '9': robot.keyPress(KeyEvent.VK_9); robot.keyRelease(KeyEvent.VK_9); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '-': robot.keyPress(KeyEvent.VK_MINUS); robot.keyRelease(KeyEvent.VK_MINUS); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '=': robot.keyPress(KeyEvent.VK_EQUALS); robot.keyRelease(KeyEvent.VK_EQUALS); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case '`': robot.keyPress(KeyEvent.VK_BACK_QUOTE); robot.keyRelease(KeyEvent.VK_BACK_QUOTE); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
			
		}
	}
	public void doTypeKey(String keyStr) throws InterruptedException, AWTException {
		Robot robot = new Robot();
		
		switch(keyStr) {
		case "@":robot.keyPress(KeyEvent.VK_AT);
		case "%":robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_5); robot.keyRelease(KeyEvent.VK_5); robot.keyRelease(KeyEvent.VK_SHIFT);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "&":robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_AMPERSAND); robot.keyRelease(KeyEvent.VK_AMPERSAND); robot.keyRelease(KeyEvent.VK_SHIFT);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "bTab":robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_SHIFT);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "tab":robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "enter":robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "up":robot.keyPress(KeyEvent.VK_UP); robot.keyRelease(KeyEvent.VK_UP); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "down":robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "left":robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "right":robot.keyPress(KeyEvent.VK_RIGHT); robot.keyRelease(KeyEvent.VK_RIGHT); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "save":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_S); robot.keyRelease(KeyEvent.VK_S); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "copy":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_C); robot.keyRelease(KeyEvent.VK_C); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "paste":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "zoomIn":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_SUBTRACT); robot.keyRelease(KeyEvent.VK_SUBTRACT); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "zoomOut":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_ADD); robot.keyRelease(KeyEvent.VK_ADD); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "f4":robot.keyPress(KeyEvent.VK_ALT); robot.keyPress(KeyEvent.VK_F4); robot.keyRelease(KeyEvent.VK_F4); robot.keyRelease(KeyEvent.VK_ALT);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "refresh":robot.keyPress(KeyEvent.VK_F5); robot.keyRelease(KeyEvent.VK_F5); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "iePDFDownload":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_ADD); robot.keyRelease(KeyEvent.VK_ADD); robot.keyRelease(KeyEvent.VK_SHIFT); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "closeFF":robot.keyPress(KeyEvent.VK_ALT); robot.keyPress(KeyEvent.VK_F4); robot.keyRelease(KeyEvent.VK_ALT); robot.keyRelease(KeyEvent.VK_F4);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		case "space":robot.keyPress(KeyEvent.VK_SPACE); robot.keyRelease(KeyEvent.VK_SPACE); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
		
		default:
			throw new IllegalArgumentException("cannot type character" + keyStr);
		
		}
	}
//	public static void doTypeKeys(String keyStr) throws InterruptedException, AWTException {
//		Robot robot = new Robot();
//		
//		switch(keyStr) {
//		case "@":robot.keyPress(KeyEvent.VK_AT);
//		case "%":robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_5); robot.keyRelease(KeyEvent.VK_5); robot.keyRelease(KeyEvent.VK_SHIFT);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "&":robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_AMPERSAND); robot.keyRelease(KeyEvent.VK_AMPERSAND); robot.keyRelease(KeyEvent.VK_SHIFT);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "bTab":robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_SHIFT);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "tab":robot.keyPress(KeyEvent.VK_TAB); robot.keyRelease(KeyEvent.VK_TAB); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "enter":robot.keyPress(KeyEvent.VK_ENTER); robot.keyRelease(KeyEvent.VK_ENTER); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "up":robot.keyPress(KeyEvent.VK_UP); robot.keyRelease(KeyEvent.VK_UP); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "down":robot.keyPress(KeyEvent.VK_DOWN); robot.keyRelease(KeyEvent.VK_DOWN); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "left":robot.keyPress(KeyEvent.VK_LEFT); robot.keyRelease(KeyEvent.VK_LEFT); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "right":robot.keyPress(KeyEvent.VK_RIGHT); robot.keyRelease(KeyEvent.VK_RIGHT); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "save":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_S); robot.keyRelease(KeyEvent.VK_S); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "copy":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_C); robot.keyRelease(KeyEvent.VK_C); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "paste":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_V); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "zoomIn":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_SUBTRACT); robot.keyRelease(KeyEvent.VK_SUBTRACT); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "zoomOut":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_ADD); robot.keyRelease(KeyEvent.VK_ADD); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "f4":robot.keyPress(KeyEvent.VK_ALT); robot.keyPress(KeyEvent.VK_F4); robot.keyRelease(KeyEvent.VK_F4); robot.keyRelease(KeyEvent.VK_ALT);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "refresh":robot.keyPress(KeyEvent.VK_F5); robot.keyRelease(KeyEvent.VK_F5); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "iePDFDownload":robot.keyPress(KeyEvent.VK_CONTROL); robot.keyPress(KeyEvent.VK_SHIFT); robot.keyPress(KeyEvent.VK_ADD); robot.keyRelease(KeyEvent.VK_ADD); robot.keyRelease(KeyEvent.VK_SHIFT); robot.keyRelease(KeyEvent.VK_CONTROL);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "closeFF":robot.keyPress(KeyEvent.VK_ALT); robot.keyPress(KeyEvent.VK_F4); robot.keyRelease(KeyEvent.VK_ALT); robot.keyRelease(KeyEvent.VK_F4);BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		case "space":robot.keyPress(KeyEvent.VK_SPACE); robot.keyRelease(KeyEvent.VK_SPACE); BaseLibrary.sleep(BaseLibrary.sleepTimeMiniShortRobot); break;
//		
//		default:
//			throw new IllegalArgumentException("cannot type character" + keyStr);
//		
//		}
//	}

}
