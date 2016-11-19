package com.apex.ecommerce.page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.apex.ecommerce.constants.LoginPageConstants;

//code to identify the elements, set the data  and perform the actions 
public class LoginPagePOM implements LoginPageConstants {

	WebDriver driver;
	@FindBy(how = How.ID, id = EMAIL_ID_LOCATOR)
	private WebElement email;

	// driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	@FindBy(how = How.ID, id = PASSWORD_LOCATOR)
	private WebElement password;

	@FindBy(how = How.ID, id = NEXT_BTN_LOCATOR)
	private WebElement nextBtn;

	@FindBy(how = How.ID, id = SIGN_IN_LOCATOR)
	private WebElement signInBtn;
	
	public LoginPagePOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setEmailData(String uname) {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		email.sendKeys(uname);
		nextBtn.click();
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public void setPwdData(String pwd) {
		password.sendKeys(pwd);
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void clickOnSignInBtn() {

		signInBtn.click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}



	public void textValidation() {
		String title = driver.getTitle();
		Assert.assertEquals(title.contains("Inbox"), true);
	}

	public void emailErrorValidation() {
		String msg = "Please enter your email.";
		WebElement errmsg = driver.findElement(By.id("errormsg_0_Email"));
		String expmsg = errmsg.getText();
		Assert.assertEquals(msg, expmsg);
	}
	
	public void pwdErrorValidation(){
		String msg = "Please enter your password.";
	    WebElement errmsg= driver.findElement(By.id("errormsg_0_Passwd"));
	    String expmsg = errmsg.getText();
	    Assert.assertEquals(msg, expmsg);
	}

}
