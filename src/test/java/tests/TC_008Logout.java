package tests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectBasicMethods;
import pages.HomePage;
import pages.LogoutPage;

public class TC_008Logout extends ProjectBasicMethods {

	@BeforeTest
	public void setup() {
		sheetname="ValidLogin";
	}
	
	@Test(dataProvider="readData")
	public void logoutTest(String username, String password) {
	    HomePage homePage = new HomePage(driver);
	    homePage.openLoginPage().clickLoginValid(username, password);
	    System.out.println("Login successful for the user: " + username);
	

	    // Re-initialize the LogoutPage object
	    LogoutPage logout = new LogoutPage(driver);
	    logout.clickLogout();
	}

}
