package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import Utils.Urls;

public class EditPayGrade extends Urls{
	
	WebDriver driver;
//	Paths paths=new Paths();
	AddPayGradePage addPayGradePage=new AddPayGradePage(driver);
	String addnameElementString="(//input[@class='oxd-input oxd-input--active'])[2]";
	String saveElementString="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' ])";
	String addCurrencyElementString="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
	String currencyInputElementString2="//div[@class='oxd-select-text-input']";
	String minimumSalaryString="(//input[@class='oxd-input oxd-input--active'])[3]";
	String maximumString="(//input[@class='oxd-input oxd-input--active'])[4]";
	String saveCurrencyElementString="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[2]";

	public EditPayGrade(WebDriver driver) {
		super(driver);
		this.driver = driver;
        PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public String EditUser(String nameString , String Currency) throws InterruptedException {
		
		System.out.println(AddName(nameString));
		System.out.println(AddCurrency(Currency));
		
		return "SucessFully Edited";
	}
	
	public String AddName(String name) throws InterruptedException {
		
    	WebElement addnameElement=driver.findElement(By.xpath(addnameElementString));
    	addnameElement.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
    	Thread.sleep(3000);
    	addnameElement.sendKeys(name);
    	Thread.sleep(2000);
    	
    	WebElement saveElement=driver.findElement(By.xpath(saveElementString));
    	saveElement.click();
    	Thread.sleep(5000);
    	
    	return "Added Name Successfully";
	}
	
	 public String AddCurrency(String currency) throws InterruptedException {
	    	
	    	WebElement addcurrencyElement=driver.findElement(By.xpath(addCurrencyElementString));
	    	addcurrencyElement.click();
	    	
	    	String currencyString=currency;
	    	WebElement currencyinputElement=driver.findElement(By.xpath(currencyInputElementString2));
	    	selectFrmDrpDwn(currencyString,currencyinputElement);
	    	Thread.sleep(4000);
	    	
	    	WebElement minimumsalaryElement=driver.findElement(By.xpath(minimumSalaryString));
	    	WebElement maximumsalaryElement=driver.findElement(By.xpath(maximumString));
	    	minimumsalaryElement.sendKeys("20000");
	    	maximumsalaryElement.sendKeys("40000");
	    	Thread.sleep(4000);
	    	WebElement savecurrencyElement=driver.findElement(By.xpath(saveCurrencyElementString));
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
