package reusableUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigPropExtractData {
	Properties prop = new Properties();
	
	public String getPropValueByKey(String key) throws IOException {
		String path = System.getProperty("user.dir")+"src\\test\\resources\\config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		String value = prop.get(key).toString();
		return value;		
	}

}
