package com.teon.tests;

import com.aventstack.extentreports.ExtentReports;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

import com.teon.browser.*;
import com.teon.automation.*;
import com.teon.util.PropertiesHandler;

public class TestBase {
	
	protected WebAutomator automator;
	protected PropertiesHandler mp;
	ExtentReports extent = new ExtentReports();

	public ExtentReports getExtent() {
		return extent;
	}


	@BeforeMethod

	public void setUpDriver(@Optional("CHROME")String browser, @Optional("false") Boolean isHeadless, @Optional("30") long max_wait) throws Exception 
	{
		//Initialize WebDriver
		Browser b = Browser.valueOf(browser);
		automator = new WebAutomator(b,isHeadless, true, max_wait);
		//Initialize property Manager
		mp = new PropertiesHandler();
	}
	
	public void setUpDriverParaIncognito(String browser, @Optional("30") long max_wait) throws Exception 
	{
		Browser b = Browser.valueOf(browser);
		automator = new WebAutomator(b, true, true, max_wait);		
	}
	
	@AfterClass
	public void tearDownDriver(@Optional("true") boolean closeBrowser) throws Exception {
		if (automator != null && closeBrowser) {
	        automator.closeBrowser();
	    }
	}
	
	@AfterMethod
	public void tearDownDriver() throws Exception {
		automator.closeAll();
	}

	protected WebAutomator getAutomator(){
		return this.automator;
	}

}
