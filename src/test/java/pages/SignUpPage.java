package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectBasicMethods;

public class SignUpPage extends ProjectBasicMethods {
	WebDriver driver;
	
	@FindBy(id="sign-username")
	WebElement userNameField;
	
	@FindBy(id="sign-password")
	WebElement passwordFiled;
	
	@FindBy(xpath="//button[text()='Sign up']")
	WebElement signUpbtn;
	
	//Constructor
	public SignUpPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//signup field
	public void clickSignUp(String Username,String Password) {
		userNameField.sendKeys(Username);
		passwordFiled.sendKeys(Password);
		signUpbtn.click();
		
	}
	
	public String getValidationMsg() {
		//Explicite wait
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());

		//Alert message
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		System.out.println("AlertMsg: "+alertMsg);
		alert.accept();
		return alertMsg;
	}
	
	
	public SignUpPage signupValidation(String testType,String expectedText) {
		
		if(testType.equalsIgnoreCase("ValidSignup")) {
			String actualText=getValidationMsg();
			Assert.assertEquals(actualText,expectedText);
		}
		else if(testType.equalsIgnoreCase("InvalidUsernameInvalidPassword")) {
			String actualText=getValidationMsg();
			Assert.assertEquals(actualText,expectedText);
		}
		else if(testType.equalsIgnoreCase("InvalidUsername")) {
			String actualText=getValidationMsg();
			Assert.assertEquals(actualText,expectedText);
		}
		else if(testType.equalsIgnoreCase("InvalidPassword")) {
			String actualText=getValidationMsg();
			Assert.assertEquals(actualText,expectedText);
		}
		return this;
	}
}
