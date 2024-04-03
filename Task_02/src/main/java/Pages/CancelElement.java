package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import Utils.Urls;

public class CancelElement extends Urls{
	
	WebDriver driver;
	Paths paths=new Paths();
	AddPayGradePage addPayGradePage=new AddPayGradePage(driver);
	
	public CancelElement(WebDriver driver) {
		super(driver);
		this.driver = driver;
        PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	

}
