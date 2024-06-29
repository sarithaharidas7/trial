package com.company.testbase;

import java.awt.desktop.SystemSleepEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.company.util.Util;


public class TestBase
{
	
	public  Properties prop;
	// private WebDriver driver;
    private static final Logger log = LogManager.getLogger(TestBase.class);
    private ThreadLocal<WebDriver> dr=new ThreadLocal<>();
    
    public WebDriver getDriver() 
    {
    	return dr.get();
    }
    
    public void setDriver(WebDriver driver) 
    {
    	dr.set(driver);
    }
    
    static {
        // Configure Log4j programmatically to set the log level
        Logger.getRootLogger().setLevel(Level.DEBUG);
        PropertyConfigurator.configure("C:\\Users\\sarit\\eclipse-workspace\\E2E\\src\\main\\resources\\log4j.properties");
    }

	
	public TestBase() 
	{
		try 
		{
			 prop = new Properties();
			 FileInputStream ip=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\company\\config\\config.properties");
			 prop.load(ip);
		
		
		}
		catch( FileNotFoundException e)
		{
		
			e.printStackTrace();
            log.error("Configuration file not found", e);
		}
		catch( IOException e)
		{
		
			e.printStackTrace();
			log.error("IOException",e);
		}
	}
	
	public void Initialization()
	
	{
		String Browser=System.getProperty("browser")!=null ?System.getProperty("browser"):prop.getProperty("browser");
		
	//	String Browser=prop.getProperty("browser");
		if(Browser.equals("chrome"))
		{
			//ChromeOptions option=new ChromeOptions();
		//	option.addArguments("headless");
			
		System.setProperty("webdriver.Chrome.driver", "C:\\Users\\sarit\\Downloads\\Automation jars\\chromedriver-win64\\chromedriver.jar");

	//	 driver=new ChromeDriver(option);
			
			//WebDriverManager.chromedriver().setup();
			setDriver(new ChromeDriver());

	
		}
		
		if(Browser.equals("firefox"))
		{
			
			setDriver(new FirefoxDriver());

	
		}
        log.info("Browser initialized: " + Browser);
		System.out.println(" TestBase driver is "+ getDriver());


		getDriver().manage().window().maximize();
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Util.ImplicitWait);
		getDriver().manage().timeouts().pageLoadTimeout(Util.pageLoadTimeout);
		getDriver().get(prop.getProperty("URL"));
        log.info("Navigated to URL: " + prop.getProperty("URL"));

		
		
	}
	
	
	
public void Initializationcucu(String browser)
	
	{
		String Browser=browser;
		
		if(Browser.equals("chrome"))
		{
		
			
		System.setProperty("webdriver.Chrome.driver", "C:\\Users\\sarit\\Downloads\\Automation jars\\chromedriver-win64\\chromedriver.jar");


			setDriver(new ChromeDriver());

	
		}
		
		if(Browser.equals("firefox"))
		{
			
			setDriver(new FirefoxDriver());

	
		}
		System.out.println(" TestBase driver is "+ getDriver());


		getDriver().manage().window().maximize();
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().timeouts().implicitlyWait(Util.ImplicitWait);
		getDriver().manage().timeouts().pageLoadTimeout(Util.pageLoadTimeout);
		getDriver().get("https://practicetestautomation.com/practice-test-login/");

		
		
	}
	
	

}
