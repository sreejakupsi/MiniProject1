package tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectBasicMethods;
import pages.HomePage;
import pages.ProductDetails;
import pages.PurchaseFunctionality;

public class TC_007PurchaseFunctionality extends ProjectBasicMethods {

	@BeforeTest
	public void setup() {
		sheetname="PlaceOrderDetails";
	}
	

	
	@Test(dataProvider="readData")
	public void readDataFromExcel(String username,String password,String name,String country,String city,String creditCard, String month, String year )  {
	    HomePage homePage = new HomePage(driver);
	    homePage.openLoginPage().clickLoginValid(username, password);
	    System.out.println("Login successful for the user: " + username);

	    ProductDetails prdobj = new ProductDetails(driver);
	    prdobj.productDetailsPage();
	    prdobj.addToCart();
	    prdobj.homePage();
	    prdobj.addAnotherProductToCart();
	    prdobj.cartBtn();

	    PurchaseFunctionality obj = new PurchaseFunctionality(driver);
	    obj.redirectionToPlaceOrderWindow();
	    obj.nameFieldIsDisplayed();
	    obj.countryFieldIsDisplayed();
	    obj.cityFieldIsDisplayed();
	    obj.monthFieldIsDisplayed();
	    obj.yearFieldIsDisplayed();
	    obj.creditCardFieldIsDisplayed();
	    obj.fillOrderDetails(name, country, city, creditCard, month, year);
	    System.out.println("The details given to place order: " + name + ", " + country + ", " + city + ", " + creditCard + ", " + month + ", " + year);
	    obj.openPopUp(); 
	    System.out.println("Purchase completed successfully.");
	    obj.reClick();
	}

}
