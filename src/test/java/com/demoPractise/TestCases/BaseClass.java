package com.demoPractise.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	
	public String url ="https://login.yahoo.com/?.src=ym&pspid=159600001&activity=mail-direct&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd";
	public String username = "pranoop_kumar";
	public String password ="Yandapatel1986!";
	public static WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe" );
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--disable-web-security", "--allow-running-insecure-content");

		driver = new ChromeDriver(options);
		
	}

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
}
