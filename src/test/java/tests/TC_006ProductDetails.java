package tests;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectBasicMethods;
import pages.HomePage;
import pages.ProductDetails;

public class TC_006ProductDetails extends ProjectBasicMethods {

	
	@BeforeTest
	public void setup() {
		sheetname="ValidLogin";
	}
	
	@Test(dataProvider="readData")
	public void productDetailsTest(String username,String password) {
		
		HomePage homePage=new HomePage(driver);
		homePage.openLoginPage().clickLoginValid(username, password);
		System.out.println("Login successfull for the user: "+username);
		
		//checks the product details
		ProductDetails obj = new ProductDetails(driver);
	    obj.productDetailsPage();
	    
	    //Assertion for product price
	    String actualPrice = obj.priceDetails();
	    String expectedPrice = "$360";
	    System.out.println("Displayed Price: " + actualPrice);
	    Assert.assertEquals(actualPrice, expectedPrice, "Incorrect Price");
	    
	    //Assertion for product name
	    String actualName=obj.productName();
	    String expectedName="Samsung galaxy s6";
	    System.out.println("Displayed Name: "+ actualName);
	    Assert.assertEquals(actualName,expectedName,"Incorrect Name");
	    
	    obj.productDescriptionText();
	    
	    //Assertion for product description
	    String actualDescription=obj.productDescription().replace("Product description", "").trim();//removes unwanted text 'Product decscription is also included'
	    String expectedDescription="The Samsung Galaxy S6 is powered by 1.5GHz octa-core Samsung Exynos 7420 processor and it comes with 3GB of RAM. The phone packs 32GB of internal storage cannot be expanded.";
	    System.out.println("Displayed description: "+ actualDescription);
	    Assert.assertEquals(actualDescription, expectedDescription,"Incorrect Description");
	    

	    
	    //alert msg for cart added
	    String actualCartText=obj.addToCart();
	    String expectedCartText="Product added.";
	    System.out.println(actualCartText);
	    Assert.assertEquals(actualCartText,expectedCartText,"Product not added to cart");
	    
	    //navigate back to home page to add another product to cart
	    obj.homePage();
	    
	    //add another product
	    obj.addAnotherProductToCart();
	    
	    //product count 
	    obj.cartBtn();
	    
	    //calculate total price
	    obj.totalPrice();
	    
	    //delete product
	    obj.deleteItemsfromCart();
	    
	    //calculate total price after deleting
	    obj.totalPriceAfterDeleting();;
	    
	}
}
