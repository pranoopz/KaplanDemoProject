package com.demoPractise.Utilities;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Properties;
import java.util.Map.Entry;

public class TestDataFileReader {
	private String propertyFileName = null;
	private Properties props;
	private String propertyFilePath= "TestData\\";

	/**
	 * private method created to load property file
	 */
	private void loadProperty(String propertyName) {
		try {
			props = new Properties();
			FileInputStream fis = new FileInputStream(propertyFilePath + propertyName + ".properties");
			props.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Public method created to access outside class.This method load property file
	 	and store Property file data in HashMap
	 */
	public HashMap<String, String> getPropertyAsHashMap(String propertyName) {
		propertyFileName = propertyName;
		loadProperty(propertyName);
		HashMap<String, String> map = new HashMap<String, String>();

		for (Entry<Object, Object> entry : props.entrySet()) {
			map.put((String) entry.getKey(), (String) entry.getValue());
		}
		return map;
	}
}
