package com.apex.ecommerce.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.ecommerce.constants.CommonConstants;
import com.apex.ecommerce.constants.LoginPageConstants;
import com.apex.ecommerce.page.LoginPagePOM;
import com.apex.ecommerce.page.LoginPagePOM;


public class GoogleLoginPOM extends BaseEcommerceTest implements LoginPageConstants,CommonConstants {

	@Test
	public void testSuccessLogin(){
		//WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		
		//create the page
		LoginPagePOM loginPage = new LoginPagePOM(driver);
	   //set the data
		loginPage.setEmailData("vrunda94ankoliya@gmail.com");
		loginPage.setPwdData("needhelp");
		
		//perform action 
		loginPage.clickOnSignInBtn();
		//validation 
        //Assert.assertEquals(title.contains("Inbox"), true);	
 	  String title = driver.getTitle();
	  Assert.assertEquals(title.contains("Inbox"), true);
	driver.close();
	
	}
	
	@Test
	public void emailEmptyTest(){
		//create a page
		LoginPagePOM loginpage = new LoginPagePOM(driver);
		//set the data
		loginpage.setEmailData("");
	    //validation
		loginpage.emailErrorValidation();
	    
	
	}
	
	



}
