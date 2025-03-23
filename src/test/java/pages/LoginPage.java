package pages;



import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectBasicMethods;

public class LoginPage extends ProjectBasicMethods {

	@FindBy(xpath="//a[text()='Log in']")
	WebElement loginMenu;
	
	@FindBy(id="loginusername")
	WebElement usernameField;
	
	@FindBy(id="loginpassword")
	WebElement passwordField;
	
	@FindBy(xpath="//button[text()='Log in']")
	WebElement loginBtn;
	
	WebDriver driver;
	
	//Constructor
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//Valid login details
	public void clickLoginValid(String username,String password){
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
	}
	
	//Invalid login details
	public String clickLoginInvalid(String username,String password) {
		
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginBtn.click();
		
		//Explicite wait
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.alertIsPresent());

		//Alert message
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		System.out.println("AlertMsg: "+ alertMsg);
		alert.accept();
		return alertMsg;
		
	}
	
	
	
}
