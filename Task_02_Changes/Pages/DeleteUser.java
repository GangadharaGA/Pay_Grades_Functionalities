package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Urls;

public class DeleteUser extends Urls{
	
	
	WebDriver driver;
	Paths paths=new Paths();
	AddPayGradePage addPayGradePage=new AddPayGradePage(driver);
	
	public DeleteUser(WebDriver driver) {
		super(driver);
		this.driver = driver;
        PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	 public String DeleteUser(String name) throws InterruptedException {
	    	
	   	 String paygradenameString=name;
//	        String xpath = String.format("//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][1]" ,paygradenameString);
	        String xpath = String.format(paths.usernameString ,paygradenameString);
	        try {
	        	WebElement delete = driver.findElement(By.xpath(xpath));
	            delete.click();
	            Thread.sleep(3000);
	            WebElement deleteButtonElement=driver.findElement(By.xpath(paths.deleteButtonString));
	            deleteButtonElement.click();
	        }catch (Exception e) {
				// TODO: handle exception
	        	return "Name Not Found";
			}     
			return "Successfully Deleted:";
		}
	
}
