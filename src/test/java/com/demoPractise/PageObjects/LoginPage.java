package com.demoPractise.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
	  this.driver = driver;	
	  PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Sign in']")
	WebElement buttonLogin;
	
	@FindBy(name= "username")
	WebElement txtusername;
	
	@FindBy(name="signin")
	WebElement nextButton;
	
	@FindBy(name ="password")
	WebElement password;
	
	@FindBy(name="verifyPassword")
	WebElement ButtonpasswordNext;
	
	public void clickSignIn()
	{
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.elementToBeClickable(this.buttonLogin));
		
		buttonLogin.click();
		
		
		
	}
	
	public void enterUserId(String uid)
	{
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.elementToBeClickable(this.txtusername));
		txtusername.sendKeys(uid);
	}
	
	public void enterpassword(String password)
	{
		WebDriverWait w = new WebDriverWait(driver, 30);
		w.until(ExpectedConditions.elementToBeClickable(this.password));
		
		this.password.sendKeys(password);
		
	}
	
	public void clickNextButton() 
	{
	  nextButton.click();	
	}
	
	public InboxPage clickPasswordNextButton()
	{
		ButtonpasswordNext.click();
		
		return new InboxPage(driver);
	}
	
}
