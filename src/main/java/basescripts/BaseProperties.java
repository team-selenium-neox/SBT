package basescripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BaseProperties {
	
	public String getPropValue(String properfile, String keyName) throws IOException {
		
		String rootPath = Stream.of(System.getProperty("user.dir"), "src", "main", "recources")
				.collect(Collectors.joining(File.separator));
		
		String propFilePath = rootPath + File.separator + properfile;
		Properties proper = new Properties();
		
		FileInputStream input = new FileInputStream(new File(propFilePath));
		proper.load(new InputStreamReader(input, Charset.forName("UTF-8")));
		
		return proper.getProperty(keyName);
	}

}
