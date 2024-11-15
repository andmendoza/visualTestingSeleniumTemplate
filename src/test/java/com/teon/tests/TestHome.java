package com.teon.tests;

import org.testng.annotations.Test;
import com.teon.config.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.Status;

public class TestHome extends TestBase {
	

    @Test
    public void testHomePage() throws InterruptedException {
    	
    	//Reportes con Extent
		ExtentSparkReporter spark = new ExtentSparkReporter(Config.REPORTS_PATH + "ReporteCaptureElement.html");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);
		ExtentTest test = extent.createTest("TestCaptureElement");
		this.automator.setTitulo("CaptureElement");
		
		String urlAutomation = "https://www.mapfre.com.mx/particulares/";

		
		test.log(Status.INFO, "Directing to page: " + urlAutomation);
		this.automator.goTo(urlAutomation);
		this.automator.maximizeWindows();
		Thread.sleep(7000);
		
		test.log(Status.PASS, "Test Finished...");
		Thread.sleep(2000);
		extent.flush();
    }

}
