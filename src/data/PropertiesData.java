package data;

//import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesData {

	public String readProperty(String fileName, String property) throws Exception {
				
		// create Properties class object to access properties file
		Properties prop = new Properties();
		
		// read property file from class path
		InputStream in = this.getClass().getResourceAsStream(fileName);

		// load the properties file
		prop.load(in);
		
		// return the property value
		return prop.getProperty(property);
	}

	public void writeProperty(String outputFile, String property, String propertyValue) throws Exception{
		// create file output stream object for the properties file
		FileOutputStream fis = new FileOutputStream(outputFile);
		
		// create Properties class object to access properties file
		Properties prop = new Properties();
		
		// load the properties file
		// set the properties
		prop.setProperty(property, propertyValue);
		
		// store the file into local system
		prop.store(fis, null);
	}
}
