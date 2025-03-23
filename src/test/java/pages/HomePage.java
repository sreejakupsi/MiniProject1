package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    WebDriver driver;

    @FindBy(id = "signin2")
    WebElement signInBtn;
    
    @FindBy(id="login2")
    WebElement loginBtn;
    
    @FindBy(id="logout2")
	WebElement logoutBtn;

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Check if Sign Up button is visible and clickable
    public void signUpBtn() {
        if (signInBtn.isDisplayed() && signInBtn.isEnabled()) {
            System.out.println("The signUp button is visible and clickable.");
        } else {
            System.out.println("The signUp button is NOT visible");
        }
    }
   

    //Check if the signup page is opened
    public SignUpPage openSignUpWindow(){
    	signInBtn.click();
    	String signUpText= signInBtn.getText();
    	System.out.println(signUpText +" window is opened" );
    	return new SignUpPage(driver);
    }
    
    
    // Check if login button is visible and clickable
    public void loginBtn() {
    	if(loginBtn.isDisplayed() && loginBtn.isEnabled()) {
    		System.out.println("The login button is visible and clickable.");
    	}
    	else {
    		System.out.println("The login button is NOT visible");
    	}
    }
    
    //Check if the login page is opened
    public LoginPage openLoginPage() {
    	loginBtn.click();
    	String loginText=loginBtn.getText();
    	System.out.println(loginText +" window is opened");
    	return new  LoginPage(driver);
    }
    
    //Check if logout button is visible and clickable
    public void logoutBtn() {
    	if(logoutBtn.isDisplayed() && logoutBtn.isEnabled()) {
    		System.out.println("The logout button is visible and clickable");
    	}
    	else {
    		System.out.println("The logout button is NOT visible and clickable");
    	}
    }
    
    
    
}
