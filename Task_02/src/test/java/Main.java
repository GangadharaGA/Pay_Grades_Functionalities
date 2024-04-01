

import java.util.List;
import java.util.concurrent.TimeUnit;

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
import Pages.HomePage;
import Pages.Userinfo;

public class Main {
	
	
	
	@Test
    public void OpenBrowserTest() throws InterruptedException {
        // Open browser
		 WebDriver driver = BrowserUtils.getDriver();
		
	       HomePage home= new HomePage(driver);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);       
       
        driver.get(Urls.getUrlstring());
       
        
        HomePage homePage = new HomePage(driver);
        Userinfo userinfo=new Userinfo();
        	
        String title = homePage.getAuthorization();
        System.out.println(homePage.getAdmin());
//        System.out.println(home.getAddPaygrade("AFN - Afghanistan Afghani"));
        System.out.println(home.getAddPaygrade(userinfo.getNameString(),userinfo.getCurrencyString()));
        System.out.println("Title of the page is: " + title);

        // Quit browser
        BrowserUtils.quitDriver();
    }
	
	//Running SucessFully
//	@Test
//	public void Deleteuser() throws InterruptedException {
//		
//		 WebDriver driver = BrowserUtils.getDriver();
//			
//		HomePage home= new HomePage(driver);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);       
//     
//        driver.get(Urls.getUrlstring());
//     
//      
//      HomePage homePage = new HomePage(driver);
//      Userinfo user=new Userinfo();
//      
//      System.out.println(homePage.getAuthorization());
//      System.out.println(homePage.getAdmin());
//
////      System.out.println(home.DeleteUser(user.getUpdateNameString()));
//      String[] nameStrings= {"h1","Goat2","Goat3","Harsh","Harsh111","Harsha1","Harsh1"};
//      
//      for(int i=0;i<nameStrings.length;i++) {
//    	  
//    	  System.out.println(home.DeleteUser(nameStrings[i])+" : "+nameStrings[i]);
//      }
//     
//      
//      driver.quit();
//		
//	}
	
	//Failing the Test Case
	@Test
	public void CancelDeleteUser() throws InterruptedException {
		
		 WebDriver driver = BrowserUtils.getDriver();
			
		HomePage home= new HomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);       
     
        driver.get(Urls.getUrlstring());
     
      
      HomePage homePage = new HomePage(driver);
      Userinfo user=new Userinfo();
      
      System.out.println(homePage.getAuthorization());
      System.out.println(homePage.getAdmin());

//      System.out.println(home.DeleteUser(user.getUpdateNameString()));
      String name="Grade 3";
//     System.out.println( home.DeleteUser(name)); 
     String cancelresponse=home.CancelUser(name);
     if(cancelresponse=="Not Found") {
    	 System.out.println("Test Failed");
     }else {
    	 
    	 System.out.println(cancelresponse);
    	 String responseString=home.searchname(name);
    	    
         if(name.equals(responseString)  ) {
//        	 fail("Intentional failure message");
       	  System.out.println("Name Still Exists After Cancelation");
         }
         else {
       	  System.out.println("Does Not Exist After Cancelation");
         }
     }
     
     
      
      driver.quit();
		
	}
	
	
//	Validate the Deleteion Again Check for Single User
	@Test
	public void DeleteSingleUser() throws InterruptedException {
		
		 WebDriver driver = BrowserUtils.getDriver();
			
		HomePage home= new HomePage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);       
     
        driver.get(Urls.getUrlstring());
     
      
      HomePage homePage = new HomePage(driver);
      Userinfo user=new Userinfo();
      
      System.out.println(homePage.getAuthorization());
      System.out.println(homePage.getAdmin());

//      System.out.println(home.DeleteUser(user.getUpdateNameString()));
      String nameString ="Grade 3";
      String deleteresponseString=homePage.DeleteUser(nameString);
      
      if(deleteresponseString=="Name Not Found") {
    	  
    	  System.out.println("Name Does Not Exist");
      }
      else {
		System.out.println(deleteresponseString);
		String responseString=homePage.searchname(nameString);
		
		if(nameString.equals(responseString)  ) {
	       	  System.out.println("Name Still Exists Deletion Operation Failed");
	         }
	         else {
	       	  System.out.println("Does Not Exist After Deletion");
	         }
	}
     
      
      driver.quit();
		
	}
	
	
	
	
	@Test
	public void EditUser() throws InterruptedException {
		

		WebDriver driver = BrowserUtils.getDriver();
			
		HomePage home= new HomePage(driver);
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);       
    
       driver.get(Urls.getUrlstring());
    
     
     HomePage homePage = new HomePage(driver);
     Userinfo updateuser=new Userinfo();
     
     
     System.out.println(homePage.getAuthorization());
     System.out.println(homePage.getAdmin());

     System.out.println(homePage.searchname("Grade 1"));
     System.out.println(homePage.Edit(updateuser.getUpdateNameString(),updateuser.getCurrencyString2()));
     Thread.sleep(3000);
//     System.out.println(homePage.getAddPaygrade("USD - United States Dollar"));
    
     
     driver.quit();
		
	}
	
	//Running Successfully For Adding Names
//	@Test
//	public void Error() throws InterruptedException {
//		Webtool w1=new Webtool();
//		WebDriver driver=w1.webbrowseDriver();
//		HomePage h1=new HomePage(driver);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		h1.getAuthorization();
//		h1.getAdmin();
//		
//		
////		System.out.println(h1.Error("Goat3"));
//		
//		//Under Test
//		String[] nameStrings= {"Goat2","Goat3","Harsh","Harsh111","Harsha1","Harsh1"};
//	      
//	      for(int i=0;i<nameStrings.length;i++) {
//	    	  
//	    	  if(i>0) {
//	    		  WebElement jobbuttonElement=driver.findElement(By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item' ])[2]"));
//	    	    	Thread.sleep(2000);
//	    	    	jobbuttonElement.click();
//	    	    	
//	    	    	WebElement paygradeElement=driver.findElement(By.xpath("(//a[@class='oxd-topbar-body-nav-tab-link' ])[2]"));
//	    	    	paygradeElement.click();
//	    	    	Thread.sleep(2000);
//	    	  }
//	    	  System.out.println(h1.Error(nameStrings[i])+" : "+nameStrings[i]);
//	      }
//		
//		driver.quit();
//	}
	
	//Under Test //For Adding Currency Also
	@Test
	public void Error() throws InterruptedException {
		Webtool w1=new Webtool();
		WebDriver driver=w1.webbrowseDriver();
		Userinfo u1=new Userinfo();
		HomePage h1=new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		h1.getAuthorization();
		h1.getAdmin();
		
		
//		System.out.println(h1.Error("Goat3"));
		
		//Under Test
//		String[] nameStrings= {"Test01","Goat2","Grade 1","Goat3","Harsh","Harsh111","Harsha1","Harsh1","Test02"};
	      
	      for(int i=0;i<2;i++) {
	    	  
	    	  String nameString=HomePage.generateRandomName(5);
	    	  if(i>0) {
	    		  WebElement jobbuttonElement=driver.findElement(By.xpath("(//span[@class='oxd-topbar-body-nav-tab-item' ])[2]"));
	    	    	Thread.sleep(2000);
	    	    	jobbuttonElement.click();
	    	    	
	    	    	WebElement paygradeElement=driver.findElement(By.xpath("(//a[@class='oxd-topbar-body-nav-tab-link' ])[2]"));
	    	    	paygradeElement.click();
	    	    	Thread.sleep(2000);
	    	  }
//	    	  System.out.println(h1.Error(nameStrings[i])+" : "+nameStrings[i]);
	    	  
	    	  String responseString=h1.Error(nameString);
	    	  if(responseString=="Name Inserted") {
	    		  System.out.println(nameString+" : "+responseString);
	    		  System.out.println(h1.AddCurrency(u1.getCurrencyString()));
	    	  }
	    	  else {
				System.out.println(responseString);
			}
	      }
		
		driver.quit();
	
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
