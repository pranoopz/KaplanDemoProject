package com.demoPractise.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.google.common.base.Verify;

public class InboxPage {
	
	WebDriver driver;
	
	public  InboxPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[contains(text(),\"Inbox\")]")
	WebElement Inbox;
	
	@FindAll(@FindBy(xpath="//ul[@aria-label=\"Message list\"]//a[@data-test-read=\"false\"]"))
	List<WebElement> MailList;

	public int getUnreadMails() {
		
		return MailList.size();

	}

	public Boolean verifyUnreadmail(String subject) {
		// TODO Auto-generated method stub
		List<WebElement> expectedmails = driver.findElements(By.xpath("//ul[@aria-label=\"Message list\"]//a[@data-test-read=\"false\" and contains(@aria-label,\""+subject+"\")]"));
		return expectedmails.size()>0?true:false;
	}

	public Boolean verifyuserloggedin() {
		
	Verify.verify(driver.findElements(By.xpath("//span[contains(text(),\"Inbox\")]")).size()>0,"User is not logged in as expected");
	
	return driver.findElements(By.xpath("//span[contains(text(),\"Inbox\")]")).size()>0?true:false;
	}
	

}
