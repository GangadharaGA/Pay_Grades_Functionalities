package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import Utils.Urls;

public class AddPayGradePage extends Urls{

	WebDriver driver;
	Paths paths=new Paths();
	HomePage homePage=new HomePage(driver);
	 Userinfo userinfo=new Userinfo();
	
	public AddPayGradePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
        PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public String AddPayGrade() throws InterruptedException {
		
		String nameString=homePage.generateRandomName(4);
		
		System.out.println(AddName(nameString));
		System.out.println(AddCurrency(userinfo.getCurrencyString()));
		
		return "Added PayGrade Sucessfully";
		
	}
	
	
	public String AddName(String name) throws InterruptedException {
		
    	WebElement addnameElement=driver.findElement(By.xpath(paths.addnameElementString));
    	addnameElement.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
    	Thread.sleep(3000);
    	addnameElement.sendKeys(name);
    	Thread.sleep(2000);
    	
    	WebElement saveElement=driver.findElement(By.xpath(paths.saveElementString));
    	saveElement.click();
    	Thread.sleep(5000);
    	
    	return "Added Name Successfully";
	}
	
	 public String AddCurrency(String currency) throws InterruptedException {
	    	
	    	WebElement addcurrencyElement=driver.findElement(By.xpath(paths.addCurrencyElementString));
	    	addcurrencyElement.click();
	    	
	    	String currencyString=currency;
	    	WebElement currencyinputElement=driver.findElement(By.xpath(paths.currencyInputElementString2));
	    	selectFrmDrpDwn(currencyString,currencyinputElement);
	    	Thread.sleep(4000);
	    	
	    	WebElement minimumsalaryElement=driver.findElement(By.xpath(paths.minimumSalaryString));
	    	WebElement maximumsalaryElement=driver.findElement(By.xpath(paths.maximumString));
	    	minimumsalaryElement.sendKeys("20000");
	    	maximumsalaryElement.sendKeys("40000");
	    	Thread.sleep(4000);
	    	WebElement savecurrencyElement=driver.findElement(By.xpath(paths.saveCurrencyElementString));
	    	savecurrencyElement.click();
	    	Thread.sleep(4000);
	    	
	    	return "Currency Added Successfully";
			
		}
	 
	 public void selectFrmDrpDwn(String string, WebElement btn) {
			
		    btn.click();
		    Actions actions = new Actions(driver);
		    if ( btn.isDisplayed() &&  btn.isEnabled()) {
		    	btn.sendKeys(Keys.ARROW_DOWN);
		    	while(! btn.getText().equals(string)) {
		    		actions.sendKeys(Keys.ARROW_DOWN).perform();
		    	}
		    	actions.sendKeys(Keys.ENTER).perform();
		    }
	    }
	
	
}
