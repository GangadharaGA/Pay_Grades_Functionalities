package Pages;



import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import Utils.Urls;



public class HomePage extends Urls {
   
	private WebDriver driver;
    
	Paths paths=new Paths();
	
    @FindBy(how = How.CSS, using = "[name= username]")
    private WebElement usernameField;

    @FindBy(how = How.CSS, using = "[name= password]")
    private WebElement passwordField;

    @FindBy(how = How.CSS, using = "[type= submit]")
    private WebElement loginButton;
    
    @FindBy(how = How.CSS ,using = "[name= Name]")
    private WebElement namElement;
    

   
    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();   
    }

    public HomePage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }
    
    public String getAuthorization(){  	
    	WebElement usernamElement=driver.findElement(By.name("username"));
		usernamElement.sendKeys("Admin");
		WebElement userpwd=driver.findElement(By.name("password"));
		userpwd.sendKeys("admin123");
		WebElement loginButton = driver.findElement(By.className("orangehrm-login-button"));
		loginButton.click();
    	
    	return "Logged IN Successfully";
    }
    
    
    public String searchname(String name) throws InterruptedException {
    	
    	String paygradenameString=name;
    	String xpath = String.format("//div[contains(@class, 'oxd-table-cell oxd-padding-cell') and .//div[contains(text(), '%s')]]" ,paygradenameString);
    	Thread.sleep(3000);
    	try {
    		WebElement findnameDriver=driver.findElement(By.xpath(xpath));
            return "Name Found: "+findnameDriver.getText();
		} catch (Exception e) {
			// TODO: handle exception
			return "Name Not Found";
		}
//        return "Found";
    	
    }
    
    //Random String Generator
    public  String generateRandomName(int length) {
        
        String allowedChars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        
        StringBuilder randomName = new StringBuilder();

        
        Random random = new Random();

        
        for (int i = 0; i < length; i++) {
            
            int randomIndex = random.nextInt(allowedChars.length());

           
            randomName.append(allowedChars.charAt(randomIndex));
        }

        
        return randomName.toString();
    }
    
//    public String getAdmin() throws InterruptedException {
//    	WebElement adminbuttonElement=driver.findElement(By.xpath(paths.adminbutton));
//    	
//    	adminbuttonElement.click();
//    	Thread.sleep(2000);
//    	WebElement jobbuttonElement=driver.findElement(By.xpath(paths.jobBttonString));
//    	Thread.sleep(2000);
//    	jobbuttonElement.click();
//    	
//    	WebElement paygradeElement=driver.findElement(By.xpath(paths.payGradeString));
//    	paygradeElement.click();
//    	Thread.sleep(2000);
//    	
//    	return "Admin and Job Pages Opened Successfully";
//    }
//    
//    public String AddName(String name) throws InterruptedException {
//		
//    	WebElement addnameElement=driver.findElement(By.xpath(paths.addnameElementString));
//    	addnameElement.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
//    	Thread.sleep(3000);
//    	addnameElement.sendKeys(name);
//    	Thread.sleep(2000);
//    	
//    	WebElement saveElement=driver.findElement(By.xpath(paths.saveElementString));
//    	saveElement.click();
//    	Thread.sleep(5000);
//    	
//    	return "Added Name Successfully";
//	}
//    
//    
//    public String  getAddPaygrade(String name, String currency) throws InterruptedException {
//		
//    	WebElement addbuttonElement=driver.findElement(By.xpath(paths.addButtonString));
//    	
//    	addbuttonElement.click();
//    	
//    	String nameString=name;
//    	System.out.println(AddName(nameString));
//    	
//    	WebElement addcurrencyElement=driver.findElement(By.xpath(paths.addCurrencyString));
//    	addcurrencyElement.click();
//    	Thread.sleep(2000);
//    	String currencyString=currency;
//    	
//    	WebElement currencyinputElement=driver.findElement(By.xpath(paths.currencyInputElementString));
//    	selectFrmDrpDwn(currencyString,currencyinputElement);
//    	Thread.sleep(4000);
//    	
//    	WebElement minimumsalaryElement=driver.findElement(By.xpath(paths.minimumSalaryString));
//    	WebElement maximumsalaryElement=driver.findElement(By.xpath(paths.maximumString));
//    	minimumsalaryElement.sendKeys("20000");
//    	maximumsalaryElement.sendKeys("40000");
//    	Thread.sleep(4000);
//    	WebElement savecurrencyElement=driver.findElement(By.xpath(paths.saveCurrencyElementString));
//    	savecurrencyElement.click();
//    	Thread.sleep(4000);
//    	return "Inserted a PayGrade For the User: Boss";
//	}
//    
//    public String AddCurrency(String currency) throws InterruptedException {
//    	
//    	WebElement addcurrencyElement=driver.findElement(By.xpath(paths.addCurrencyElementString));
//    	addcurrencyElement.click();
//    	
//    	String currencyString=currency;
//    	WebElement currencyinputElement=driver.findElement(By.xpath(paths.currencyInputElementString2));
//    	selectFrmDrpDwn(currencyString,currencyinputElement);
//    	Thread.sleep(4000);
//    	
//    	WebElement minimumsalaryElement=driver.findElement(By.xpath(paths.minimumSalaryString));
//    	WebElement maximumsalaryElement=driver.findElement(By.xpath(paths.maximumString));
//    	minimumsalaryElement.sendKeys("20000");
//    	maximumsalaryElement.sendKeys("40000");
//    	Thread.sleep(4000);
//    	WebElement savecurrencyElement=driver.findElement(By.xpath(paths.saveCurrencyElementString));
//    	savecurrencyElement.click();
//    	Thread.sleep(4000);
//    	
//    	return "Currency Added Successfully";
//		
//	}
    
//    public void selectFrmDrpDwn(String string, WebElement btn) {
//		
//	    btn.click();
//	    Actions actions = new Actions(driver);
//	    if ( btn.isDisplayed() &&  btn.isEnabled()) {
//	    	btn.sendKeys(Keys.ARROW_DOWN);
//	    	while(! btn.getText().equals(string)) {
//	    		actions.sendKeys(Keys.ARROW_DOWN).perform();
//	    	}
//	    	actions.sendKeys(Keys.ENTER).perform();
//	    }
//    }
    
    //Running Sucessfully
//    public String DeleteUser(String name) throws InterruptedException {
//    	
//    	 String paygradenameString=name;
//         String xpath = String.format("//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][1]" ,paygradenameString);
//         WebElement delete = driver.findElement(By.xpath(xpath));
//         delete.click();
//         Thread.sleep(3000);
//         WebElement deleteButtonElement=driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']"));
//         deleteButtonElement.click();
//		return "Successfully Deleted:";
//	}
    
    //Running Sucessfully for Deleting String List
//    public String DeleteUser(String name) throws InterruptedException {
//    	
//   	 String paygradenameString=name;
////        String xpath = String.format("//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][1]" ,paygradenameString);
//        String xpath = String.format(paths.usernameString ,paygradenameString);
//        try {
//        	WebElement delete = driver.findElement(By.xpath(xpath));
//            delete.click();
//            Thread.sleep(3000);
//            WebElement deleteButtonElement=driver.findElement(By.xpath(paths.deleteButtonString));
//            deleteButtonElement.click();
//        }catch (Exception e) {
//			// TODO: handle exception
//        	return "Name Not Found";
//		}     
//		return "Successfully Deleted:";
//	}
//    
//    //For Failing the Test Case and Cancels the Delete Operation
//    public String CancelUser(String name) throws InterruptedException {
//    	
//   	 String paygradenameString=name;
////        String xpath = String.format("//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][1]" ,paygradenameString);
//        String xpath = String.format(paths.usernameString ,paygradenameString);
//
//        try {
//        	WebElement delete = driver.findElement(By.xpath(xpath));
//            delete.click();
//            Thread.sleep(3000);
//            return "Cancelled Delete Operation";
//		} catch (Exception e) {
//			// TODO: handle exception
//			return "Not Found";
//		}
//
//        
//		
//	}
//    
//    
    
    
    
//    public String  Edit(String updatedname,String addcurrency) throws InterruptedException {
//    	
////    	String paygradenameString="Boss";
////    	String xpath = String.format("//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][2]" ,paygradenameString);
////        WebElement Edit = driver.findElement(By.xpath(xpath));
////        Edit.click();
////        Thread.sleep(3000);
//        String nameString=updatedname;
//        System.out.println(AddName(nameString));
//        System.out.println(AddCurrency(addcurrency));
//        
//        return "SuccessFully Updated";
//	}
    
    
    //Running Successfully for Single Element
//   public String Error(String name) throws InterruptedException {
//	   
//	   WebElement addbuttonElement=driver.findElement(By.xpath("(//i[@class='oxd-icon bi-plus oxd-button-icon' ])"));
//   	
//   		addbuttonElement.click();
//   		
//   		WebElement addnameElement=driver.findElement(By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"));
//    	addnameElement.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
//    	Thread.sleep(3000);
//    	addnameElement.sendKeys(name);
//   	
//    	
//    	WebElement saveElement=driver.findElement(By.xpath("(//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space' ])"));
//    	saveElement.click();
//    	
//    	try {
//    		
//    		WebElement errormsgElement=driver.findElement(By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']"));
//    		String errorString=errormsgElement.getText();
////    		System.out.println(errorString);
//    		if(errorString.isEmpty()) {
//    			
//    			System.out.println("Name does Not Exists");
//    			driver.quit();
//    		}
//    		else {
//    			System.out.println(errorString);
//    			driver.quit();
//    		}
//			
//		} catch (Exception e) {
//			
//			// TODO: handle exception
//			
//			System.out.println("Name Inserted");
//			driver.quit();
//		}
//    	
//    	return "Error function completed";
//    		   
//   }
   
   //Testing
// public String Error(String name) throws InterruptedException {
//	   
//	   WebElement addbuttonElement=driver.findElement(By.xpath(paths.addButtonElementString));
//   	
//   		addbuttonElement.click();
//   		
//   		WebElement addnameElement=driver.findElement(By.xpath(paths.addNameString));
//    	addnameElement.sendKeys(Keys.CONTROL+"a",Keys.DELETE);
//    	Thread.sleep(3000);
//    	addnameElement.sendKeys(name);
//   	
//    	
//    	WebElement saveElement=driver.findElement(By.xpath(paths.saveElementString2));
//    	saveElement.click();
//    	
//    	try {
//    		
//    		WebElement errormsgElement=driver.findElement(By.xpath(paths.errormessageString));
//    		String errorString=errormsgElement.getText();
////    		System.out.println(errorString);
//    		if(errorString.isEmpty()) {
//    			
//    			System.out.println("Name does Not Exists");
//    			
//    		}
//    		else {
//    			System.out.println(errorString);
//    			
//    		}
//			
//		} catch (Exception e) {
//			
//			// TODO: handle exception
//			
////			System.out.println("Name Inserted");
//			return "Name Inserted";
//			
//		}
//    	
//    	return "Name Already Exists  : Error function completed";
//    		   
//   }
    
}

