package tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectBasicMethods;
import pages.HomePage;
import pages.SignUpPage;


public class TC_001ValidSignup extends ProjectBasicMethods {

	@BeforeTest
	public void setup() {
		sheetname="ValidSignup";
	}
	
    @Test(dataProvider="readData")
    public void signUpTest(String Username, String Password,String testType,String expectedText)  {
        //Signup details
        HomePage obj = new HomePage(driver);
        obj.openSignUpWindow().clickSignUp(Username,Password);
        
        SignUpPage signup=new SignUpPage(driver);
        signup.signupValidation(testType,expectedText);

    }
}
