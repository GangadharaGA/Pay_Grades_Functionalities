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
    

    
}

