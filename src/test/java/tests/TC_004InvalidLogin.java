package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectBasicMethods;
import pages.HomePage;
import pages.LoginPage;

public class TC_004InvalidLogin extends ProjectBasicMethods {
	@BeforeTest
	public void setup() {
		sheetname="InvalidLogin";
	}
	
	@Test(dataProvider="readData")
	public void loginText(String username,String password){
		HomePage obj=new HomePage(driver);
		obj.openLoginPage().clickLoginInvalid(username, password);
	}
}
