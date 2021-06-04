package com.api.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.log4j.xml.DOMConfigurator;

public class SingleTonClass {

	private static Properties prop = new Properties();
	private static String env;
	private static SingleTonClass obj = null;

	private SingleTonClass() {
	}

	public static final SingleTonClass getInstance() {
		if (obj == null) {
			obj = new SingleTonClass();
		}
		return obj;
	}

	// Set the environment
	public void setSetUp() {
		try {
			DOMConfigurator.configure("log4j.xml");
			setEnv();
			loadProp();
//			ExcelUtils.setExcelFile(Constant.Path_TestData + Constant.File_TestData, Constant.SheetName);
		} catch (Exception e) {
			Log.info("Environment setup getting trouble...");
		}

	}

	public void getSetUp() {
		setSetUp();
	}

	// Set the environment
	public void setEnv() {
		env = "STAGING";
	}

	public String getEnv() {
		return env;
	}

	public void loadProp() {
		try {
			if (getEnv().equals("STAGING")) {
				getProp().load(new FileInputStream("src/test/resources/TestData/Read_Data.properties"));
			} else if (getEnv().equals("PROD")) {
				getProp().load(new FileInputStream("src/test/resources/TestData/data_PROD.properties"));
			}
		} catch (FileNotFoundException e) {
			Log.error("Error File not found", e);
			e.printStackTrace();
		} catch (IOException e) {
			Log.error("Error IO exception", e);
			e.printStackTrace();
		}
	}

	// Saving property with system
	public void setProp(String key, String value) {
		prop.setProperty(key, value);
	}

	// Saving property with data sheet
	public void setProp1(String key, String value) throws IOException {
		FileOutputStream out = new FileOutputStream("src/test/resources/TestData/Write_Data.properties");
		prop.setProperty(key, value);
		prop.store(out, null);
		out.close();
	}

	// Saving property with data sheet
	public void updateProp(String key, String value) throws IOException, ConfigurationException {
		PropertiesConfiguration conf = new PropertiesConfiguration("src/test/resources/TestData/Read_Data.properties");
		conf.setProperty(key, value);
		conf.save();
		conf.clear();
	}

	// Getting data from data sheet
	public Properties getProp() {
		return prop;
	}

	// Getting data from data sheet with parameter
	public String getProp(String parameter) throws IOException {
		getProp().load(new FileInputStream("src/test/resources/TestData/Read_Data.properties"));
		return prop.getProperty(parameter);
	}

	public Properties setProp() {
		return prop;
	}

}
