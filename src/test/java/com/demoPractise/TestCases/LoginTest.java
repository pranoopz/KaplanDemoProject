package com.demoPractise.TestCases;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.demoPractise.PageObjects.*;
import com.google.common.base.Verify;
import com.demoPractise.DataProviders.*;

public class LoginTest extends BaseClass
{
   @Test
   public void logintest_TC01()
   {
	   HashMap<String, String> testDataMap = FileReaderManager.getInstance().getTestDataFileReader().getPropertyAsHashMap("Module_01");
		
	   for (Map.Entry<String,String> logindetails : testDataMap.entrySet())
	   {
		   driver.get(url);
		   LoginPage lp = new LoginPage(driver);
		  
		 //  lp.clickSignIn();
		   lp.enterUserId(logindetails.getKey());
		   lp.clickNextButton();
		   lp.enterpassword(logindetails.getValue());
		   InboxPage ip = lp.clickPasswordNextButton();   
		   Boolean loggedIn= ip.verifyuserloggedin();
		   if(loggedIn) 
		   {
			   int count = ip.getUnreadMails();
			   Assert.assertTrue(count>0,"There are no unread mails in the inbox for the login id "+ logindetails.getKey());
			   Boolean b = ip.verifyUnreadmail("Security alert");
			   Assert.assertTrue(b,"Unable to find the expected mail in the inbox for the login id "+ logindetails.getKey());
			   driver.close();
		   }
		  
	   }
	   
	   
	   
   }
}
