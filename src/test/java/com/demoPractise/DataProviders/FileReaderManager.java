package com.demoPractise.DataProviders;

import com.demoPractise.Utilities.*;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static TestDataFileReader testDataFileReader;
	
	private FileReaderManager() {
	}
	
	/**
	 * Method to get the instance for FileReaderManager
	 */
	public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	
	 
	 /**
		 * Method to get the object for TestDataFileReader
		 */
	 public TestDataFileReader getTestDataFileReader() {
		 return (testDataFileReader == null) ? new TestDataFileReader() : testDataFileReader;
	 }
}
