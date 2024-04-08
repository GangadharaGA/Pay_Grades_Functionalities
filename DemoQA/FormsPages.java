import java.awt.Point;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import Utils.Urls;

public class FormsPages extends Urls{

	 private WebDriver driver;
	 
	 @FindBy(how = How.XPATH, using ="(//div[@class='separator'])[2]")
	 private WebElement formButtonElement;
	 
	 @FindBy(how = How.XPATH, using = "//span[@class='text' and text()='Practice Form']")
	 private WebElement practiceformbuttonElement;

	public FormsPages(WebDriver driver) {
	    	super(driver);
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public String getTitle() {
	        return driver.getTitle();
	    }
	    
	    public String FormButton(WebDriverWait wait) throws InterruptedException {
	    	
//	    	WebElement formButtonElement=driver.findElement(By.xpath);
//	    	 WebElement thirdElement = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("span.pr-1"))).get(2);

//			formButtonElement.click();
//			thirdElement.click();
//	    	WebElement separator = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='separator'])[2]")));
//	    	separator.click();
	    	WebElement separator = driver.findElement(By.xpath("(//div[@class='separator'])[2]"));
	    	org.openqa.selenium.Point location = separator.getLocation();

	        // Print the offset coordinates
	        System.out.println("X Offset: " + location.getX());
	        System.out.println("Y Offset: " + location.getY());
	    	Actions actions = new Actions(driver);
	    	actions.moveToElement(separator, location.getX(),location.y).click().build().perform();

			Thread.sleep(3000);
			practiceformbuttonElement.click();
			Thread.sleep(3000);
			return "Form Button Clicked";
	    }
}
