import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utils.Urls;

public class FillForm extends Urls{

	private WebDriver driver;
	 
	 @FindBy(how = How.XPATH, using ="//input[@id='firstName']" )
	 private WebElement firstnameElement;
	 
	 @FindBy(how = How.XPATH, using = "//input[@id='lastName']")
	 private WebElement lastnameElement;

	 @FindBy(how = How.XPATH, using = "//input[@id='userEmail']")
	 private WebElement emailElement;
	 
	 @FindBy(how = How.XPATH, using = "(//input[@id='gender-radio-1'])[1]")
	 private WebElement genderElement;
	 
	 @FindBy(how = How.XPATH, using = "//input[@id='userNumber']")
	 private WebElement usernumber;
	 
	 @FindBy(how = How.XPATH, using = "//input[@id='dateOfBirthInput']")
	 private WebElement dateofbirthElement;
//	 
	 @FindBy(how = How.XPATH, using = "//div[@class='subjects-auto-complete__control css-yk16xz-control']")
	 private WebElement subjectElement;
	 
	 @FindBy(how = How.XPATH, using = "//input[@id='uploadPicture']")
	 private WebElement choosefileelElement;
	 
	 @FindBy(how = How.XPATH, using = "//textarea[@id='currentAddress']")
	 private WebElement currentAddressElement;
	 
	 String addressString="plot no:45 California,USA";
	 
	 @FindBy(how = How.XPATH, using = "(//div[@class=' css-1wa3eu0-placeholder'])[1]")
	 private WebElement selectStateElement;
	 
	 String stateString="NCR";
	 
	 @FindBy(how = How.XPATH, using = "(//div[@class=' css-1wa3eu0-placeholder'])[2]")
	 private WebElement selectCityElement;
	
	 String cityString="Agra";
	 
	 @FindBy(how = How.XPATH, using = "//input[@id='hobbies-checkbox-1']")
	 private WebElement hobbiesElement;
	 
	 @FindBy(how = How.XPATH, using = "//button[@id='submit']")
	 private WebElement submittElement;
	 
	 
	 
	public FillForm(WebDriver driver) {
	    	super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	
	 public void selectFrmDrpDwn(String string, WebElement btn) throws InterruptedException {
			
		    btn.click();
		    Actions actions = new Actions(driver);
		    if ( btn.isDisplayed() &&  btn.isEnabled()) {
		    	btn.sendKeys(Keys.ARROW_DOWN);
		    	Thread.sleep(3000);
		    	while(! btn.getText().equals(string)) {
		    		actions.sendKeys(Keys.ARROW_DOWN).perform();
		    		Thread.sleep(3000);
		    	}
		    	actions.sendKeys(Keys.ENTER).perform();
		    }
	    }
	
	public String Details() throws InterruptedException {
		
		firstnameElement.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		Thread.sleep(2000);
		firstnameElement.sendKeys("Test");
		
		lastnameElement.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		Thread.sleep(2000);
		lastnameElement.sendKeys("case");
		
		emailElement.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		Thread.sleep(2000);
		emailElement.sendKeys("testcase@gmail.com");
		
//		genderElement.click();
		WebElement label = driver.findElement(By.cssSelector("label[for='gender-radio-1']"));
		label.click();

		System.out.println("Male");
		usernumber.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		Thread.sleep(2000);
		usernumber.sendKeys("080 96456");
		
//		dateofbirthElement.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
//		Thread.sleep(2000);
//		dateofbirthElement.sendKeys("5 April 2024");
		
		
		
		 WebElement inputField = driver.findElement(By.id("subjectsInput")); 
	     inputField.sendKeys("Your input text");
		System.out.println("Hockey");
		
		
//		WebElement sportsLabel = driver.findElement(By.xpath("//label[text()='Sports']"));
//		WebElement checkbox = driver.findElement(By.id("hobbies-checkbox-1"));
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
//		hobbiesElement.click();
		WebElement label1 = driver.findElement(By.xpath("//label[@for='hobbies-checkbox-1']"));
		label1.click();

		currentAddressElement.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
		Thread.sleep(3000);
		currentAddressElement.sendKeys(addressString);
		
		selectFrmDrpDwn(stateString, selectStateElement);
		System.out.println("State inserted");
		Thread.sleep(3000);
		selectFrmDrpDwn(cityString, selectCityElement);
		
		submittElement.click();
		
		return "Details Filled";
		
	}
}
