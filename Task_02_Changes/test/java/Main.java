

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.sound.midi.Soundbank;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

import Utils.BrowserUtils;
import Utils.Urls;
import Utils.Webtool;
import dev.failsafe.internal.util.Assert;
import io.opentelemetry.api.internal.Utils;
import Pages.AddPayGradePage;
import Pages.Admin;
import Pages.DeleteUser;
import Pages.EditPayGrade;
import Pages.HomePage;
import Pages.JobPage;
import Pages.Userinfo;

public class Main {
	
	
	

	
	// 1/4/2024
	@Test
	public void AdminTest() throws InterruptedException {
		WebDriver driver = BrowserUtils.getDriver();
		
	       HomePage home= new HomePage(driver);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);       
    
     driver.get(Urls.getUrlstring());
    
     
     HomePage homePage = new HomePage(driver);
     Admin admin=new Admin(driver);
     JobPage jobPage=new JobPage(driver);
     AddPayGradePage addPayGradePage=new AddPayGradePage(driver);
     
     System.out.println(homePage.getAuthorization());
     System.out.println(admin.AdminPage());
     System.out.println(jobPage.AddElement());
     System.out.println(addPayGradePage.AddPayGrade());
     
     driver.close();
	}
	
	
	// 2/4/24
	@Test
	public void EditUserPayGrade() throws InterruptedException {
		
		WebDriver driver = BrowserUtils.getDriver();
		
        HomePage home= new HomePage(driver);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);       
 
	    driver.get(Urls.getUrlstring());
		 
		  
		  HomePage homePage = new HomePage(driver);
		  Admin admin=new Admin(driver);
		  JobPage jobPage=new JobPage(driver);
		  EditPayGrade editPayGrade=new EditPayGrade(driver);
		  
		  System.out.println(homePage.getAuthorization());
		  System.out.println(admin.AdminPage());
		  boolean flag=jobPage.Edituser("Gangstar");
		  
		  if(flag!=false) {
			  System.out.println(editPayGrade.EditUser("ibDp", "AFN - Afghanistan Afghani"));
			  System.out.println(admin.AdminPage());
			  System.out.println(homePage.searchname("ibDp"));
			  System.out.println("Edit has been Successfully verified");
			  Thread.sleep(3000);
		  }
		  else {
			  System.out.println("Name Not Found Please Check Again");
		}
		  
		  driver.close();
	}
	
	// 2/04/24
	@Test
	public void DeletePayGrade() throws InterruptedException {
		WebDriver driver = BrowserUtils.getDriver();
		
        HomePage home= new HomePage(driver);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);       
 
	    driver.get(Urls.getUrlstring());
		 
		  
		  HomePage homePage = new HomePage(driver);
		  Admin admin=new Admin(driver);
		  JobPage jobPage=new JobPage(driver);
		 DeleteUser user=new DeleteUser(driver);
		  
		  System.out.println(homePage.getAuthorization());
		  System.out.println(admin.AdminPage());
		  boolean flag=jobPage.DeleteUser("Gangstar");
		  if(flag) {
			  System.out.println(user.DeleteUser("Gangstar"));
//			  System.out.println();
		  }
		  else {
			  System.out.println("Username Not Found");
		  }
		  
		  driver.close();
	}

	@Test
	public void Login() {
		
		 WebDriver driver = BrowserUtils.getDriver();
	     driver.get(Urls.getUrlstring());
	     HomePage homePage = new HomePage(driver);
//	     WebElement userElement=driver.we
	     
	     String h1=homePage.getAuthorization();
	     System.out.println(h1);	
	}
	
	
}
