package Utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import Pages.HomePage;

public class Webtool {

	
	
	
	 public Webtool() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WebDriver webbrowseDriver() {
	    	
	    	WebDriver driver = BrowserUtils.getDriver();
			
			HomePage home= new HomePage(driver);
	       driver.manage().window().maximize();
	       driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);       
	    
	       driver.get(Urls.getUrlstring());
	       
	       return driver;
	    }
}
