package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import Utils.Urls;

public class Admin extends Urls{

	WebDriver driver;
	Paths paths=new Paths();
	
	public Admin(WebDriver driver) {
		super(driver);
		this.driver = driver;
        PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}


	public String AdminPage() throws InterruptedException {
		
		WebElement adminbuttonElement=driver.findElement(By.xpath(paths.adminbutton));
    	
    	adminbuttonElement.click();
    	Thread.sleep(2000);
    	WebElement jobbuttonElement=driver.findElement(By.xpath(paths.jobBttonString));
    	Thread.sleep(2000);
    	jobbuttonElement.click();
    	
    	WebElement paygradeElement=driver.findElement(By.xpath(paths.payGradeString));
    	paygradeElement.click();
    	Thread.sleep(2000);
    	
		return "You are At Admin Page ";
	}
}
