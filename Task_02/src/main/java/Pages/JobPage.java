package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Urls;

public class JobPage extends Urls{

	WebDriver driver;
	Paths paths=new Paths();
	AddPayGradePage addPayGradePage=new AddPayGradePage(driver);
	String addButtonElementString="(//i[@class='oxd-icon bi-plus oxd-button-icon' ])";
	
	public JobPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
        PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	//Search the Name Here
	public boolean searchname(String name) throws InterruptedException {
    	
    	String paygradenameString=name;
    	String xpath = String.format("//div[contains(@class, 'oxd-table-cell oxd-padding-cell') and .//div[contains(text(), '%s')]]" ,paygradenameString);
    	Thread.sleep(3000);
    	try {
    		WebElement findnameDriver=driver.findElement(By.xpath(xpath));
             System.out.println(findnameDriver.getText());
             return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}

    	
    }
	
	
	
	public String AddElement() throws InterruptedException {
		
		WebElement addbuttonElement=driver.findElement(By.xpath(addButtonElementString));
	   	
   		addbuttonElement.click();
   		Thread.sleep(3000);
   		
   		
   		return "Navigating to Adding a UsersPayGrade";
   		
   		
	}
	
	public boolean Edituser(String Name) throws InterruptedException {
		
		boolean responseString=searchname(Name);
		
		if(responseString!=false) {
			
			String xpath = String.format("//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][2]" ,Name);
	        WebElement Edit = driver.findElement(By.xpath(xpath));
	        Edit.click();
	        Thread.sleep(3000);
	        System.out.println("Name Found and Navigating to EditPayGrade Page");
	       return true;
		}
		else {
			System.out.println("Name Not Found");
			return false;
		}
		
	}
	
	public boolean DeleteUser(String Name) throws InterruptedException {
		
		boolean flag=searchname(Name);
		
		if (flag) {
//			String xpath = String.format("//div[contains(@class, 'oxd-table-row') and .//div[contains(text(), '%s')]]//button[contains(@class, 'oxd-icon-button')][1]" ,Name);
//	        WebElement Delete = driver.findElement(By.xpath(xpath));
//	        Delete.click();
//	        Thread.sleep(3000);
	        System.out.println("Name Found and Navigating to DeleteUser Page");
			return true;
		}
		else {
			System.out.println("Name Not Found");
			return false;
		}
	}
	
	
}
