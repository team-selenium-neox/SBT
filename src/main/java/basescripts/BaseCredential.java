package basescripts;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;


public class BaseCredential {
	
	public static BaseProperties proper = new BaseProperties();
	public String getDecodeUser(String option) throws IOException {
		byte[] decryptedString = null;
		
		if (option.equalsIgnoreCase("user1")) {
			decryptedString = Base64.decodeBase64(proper.getPropValue("useridfile.properties", "user1"));
		} else if(option.equalsIgnoreCase("user2")) {
			decryptedString = Base64.decodeBase64(proper.getPropValue("useridfile.properties", "user2"));
		} else if (option.equalsIgnoreCase("user3")) {
			decryptedString = Base64.decodeBase64(proper.getPropValue("useridfile.properties", "user3"));
		} else {
			System.out.println("getDecodeUser");
		}
		return new String(decryptedString);
	}
	
	public static String getDecoded(String encodedString) {
		byte[] decryptedPWD = null;
		
		decryptedPWD = Base64.decodeBase64(encodedString);
		return new String(decryptedPWD);
		
	}
	
	public void encodeCredential() throws IOException, InterruptedException, AWTException {
		String cred = "xxxx";
		
		String cryptedString = Base64.encodeBase64String(cred.getBytes());
		System.out.println(cryptedString);
	}

}
