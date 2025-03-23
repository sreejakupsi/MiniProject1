package tests;

import org.testng.annotations.Test;

import base.ProjectBasicMethods;
import pages.ProductCategoriesPage;

public class TC_005ProductCategories extends ProjectBasicMethods {

	@Test
	public void productCategoriesTest() {
		ProductCategoriesPage obj= new ProductCategoriesPage(driver);
		obj.welcomeUserIsDisplayed();
		obj.homeMenuIsDisplayed();
		obj.contactMenuIsDisplayed();
		obj.aboutUsIsDisplayed();
		obj.cartIsDisplayed();
		obj.logoutDisplayed();
		obj.logoDisplayed();
		
	}
}
