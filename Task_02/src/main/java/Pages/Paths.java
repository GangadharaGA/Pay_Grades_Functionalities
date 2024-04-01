package Pages;

public class Paths  {
	
	
//	WebDriver driver;
	
	
	
	String adminbutton= "(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' ])[1]";
	
	String jobBttonString="(//span[@class='oxd-topbar-body-nav-tab-item' ])[2]";
	
	String payGradeString = "(//a[@class='oxd-topbar-body-nav-tab-link' ])[2]";
	
	//AdminButton
//	public WebElement adminbuttonElement = driver.findElement(By.xpath("(//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' ])[1]"));
//	
//	//JobButtonElement
//	public WebElement  jobbuttonElement = driver.findElement(By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item' ])[2]"));
//	
//	//PayGradeELemnt
//	public WebElement paygradeElement = driver.findElement(By.xpath("(//a[@class='oxd-topbar-body-nav-tab-link' ])[2]"));
	
	//Add Name Buttons
	String addnameElementString="(//input[@class='oxd-input oxd-input--active'])[2]";
	
	String saveElementString="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' ])";
	
	//WebElement addnameElement=driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
//	WebElement saveElement=driver.findElement(By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' ])"));
	
	
	//Add PayGrade Elements
	String addButtonString="(//i[@class='oxd-icon bi-plus oxd-button-icon' ])";
	String addCurrencyString="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
	String currencyInputElementString="//div[@class='oxd-select-text-input']";
	String minimumSalaryString="(//input[@class='oxd-input oxd-input--active'])[3]";
	String maximumString="(//input[@class='oxd-input oxd-input--active'])[4]";
	String saveCurrencyElementString="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space'])[2]";
	
	//Add Currency
	String addCurrencyElementString="//button[@class='oxd-button oxd-button--medium oxd-button--secondary']";
	String currencyInputElementString2="//div[@class='oxd-select-text-input']";
	
	
	//DeleteUser String Name
	String usernameString="//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][1]";
	String deleteButtonString="//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']";
	
	 //For Failing the Test Case and Cancels the Delete Operation
//	String xpath = String.format("//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][1]" ,paygradenameString);
	
	//Testing
	String addButtonElementString="(//i[@class='oxd-icon bi-plus oxd-button-icon' ])";
	String addNameString="(//input[@class='oxd-input oxd-input--active'])[2]";
	String saveElementString2="(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' ])";
	String errormessageString="//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']";

}
