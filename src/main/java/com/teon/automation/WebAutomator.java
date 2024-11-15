package com.teon.automation;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.teon.browser.*;
import com.teon.config.*;
import com.teon.exceptions.NoValidBrowserException;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class WebAutomator {
	//WebDriver Wrapper
	private WebDriver driver;
	
	//WebDriver wait
	private WebDriverWait wait;
	
    private String titulo;
	
	
    @SuppressWarnings("deprecation")
	public WebAutomator(Browser browser,boolean isHeadless, boolean isIncognito, long max_wait) throws NoValidBrowserException {
		switch (browser) {
		case CHROME: {		
			System.setProperty("webdriver.chrome.driver", Config.DRIVER_PATH + "chromedriver.exe");
			driver = new ChromeDriver();
			break;
		}
		case FIREFOX:{			
			DriverManagerType  firefox = DriverManagerType.FIREFOX;
			WebDriverManager.getInstance(firefox).setup();			
			driver = new FirefoxDriver();
			break;
		}
			
		case EDGE:{
			DriverManagerType edge = DriverManagerType.EDGE;
			WebDriverManager.getInstance(edge).setup();			
			driver = new EdgeDriver();
			break;
		}
			
		case IEXPLORER:{
			DriverManagerType iexplore = DriverManagerType.IEXPLORER;
			WebDriverManager.getInstance(iexplore).setup();			
			driver = new InternetExplorerDriver();
			break;
		}
			
			
		default:
			throw new NoValidBrowserException(browser.toString());
			
		}
		wait = new WebDriverWait(driver, Duration.ofSeconds(max_wait));
		
	}
	    
	
		
		
		//Getters y Setters
		public WebDriver getDriver() {
			return this.driver;
		}
		
		//Browser API
		public void maximizeWindows() {
			this.driver.manage().window().maximize();
		}
		
		
		//Method that closes the browser and ends the active session of the WebDriver
		public void closeAll(){
			if(driver!=null)
			{
				this.driver.quit();
			}
			
		}

		public void back() {
			this.driver.navigate().back();
		}
		
		public void forward() {
			this.driver.navigate().forward();
		}
		
		public void refresh() {
			this.driver.navigate().refresh();
		}
		
		public void goTo(String url) {
			this.driver.get(url);
		}
		
		public void closeBrowser() {
			this.driver.quit();
		}
		
		public void closeCurrentTab() {
			this.driver.close();
		}
		
		public String getCurrentUrl() {
			return this.driver.getCurrentUrl();
		}
		
		public String getTitulo() {
			return titulo;
		}

		public void setTitulo(String titulo) {
			this.titulo = titulo;
		}
		
		
		public void visibleElement(By elem) {
			
			 JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		     WebElement element = driver.findElement(elem);
		     jsExecutor.executeScript("arguments[0].style.visibility=''", element);
		}
		
		public void hiddenElement(By elem) {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
			WebElement ignore = this.driver.findElement(elem);
	        jsExecutor.executeScript("arguments[0].style.visibility='hidden'", ignore);
		}

}
