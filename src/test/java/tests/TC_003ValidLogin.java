package tests;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.ProjectBasicMethods;
import pages.HomePage;

public class TC_003ValidLogin extends ProjectBasicMethods {
	
	@BeforeTest
	public void setup() {
		sheetname="ValidLogin";
	}
	
	@Test(dataProvider="readData")
	public void loginText(String username,String password){
		HomePage obj=new HomePage(driver);
		obj.openLoginPage().clickLoginValid(username, password);
	}
}
