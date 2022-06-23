package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.crm.qa.utilities.UtilClass;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties p;
	
	public BaseClass() throws IOException {
		p=new Properties();
		FileInputStream fi=new FileInputStream("/Users/rjghori/eclipse-workspace/SecondPOMProject/src/main/java/com/crm/qa/config/Config.properties");
		p.load(fi);
	}
	
	public void  init() {
		String browserName=p.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "/Users/rjghori/SeleniumJars/chromedriver");
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", "/Users/rjghori/SeleniumJars/geckodriver");
			driver=new FirefoxDriver();
		}else {
			System.setProperty("webdriver.safari.driver", "/Users/rjghori/SeleniumJars/safaridriver");
			driver=new SafariDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(UtilClass.PageLoadTime));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(UtilClass.ImplicitTime));
		
		driver.get(p.getProperty("baseurl"));
	}

}
