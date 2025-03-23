package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import base.ProjectBasicMethods;

public class ProductCategoriesPage extends ProjectBasicMethods {

	WebDriver driver;
	@FindBy(id = "nameofuser")
	WebElement userName;
	@FindBy(xpath = "//a[text()='Home ']")
	WebElement homeMenu;
	@FindBy(xpath="//a[text()='Contact']")
	WebElement contactMenu;
	@FindBy(xpath="//a[text()='About us']")
	WebElement aboutUsMenu;
	@FindBy(xpath="//a[text()='Log out']")
	WebElement logoutMenu;
	@FindBy(xpath="//a[text()='Cart']")
	WebElement cartMenu;
	@FindBy(xpath="//a[text()='Phones']")
	WebElement phoneCategorie;
	@FindBy(xpath="//a[text()='Laptops']")
	WebElement lapCategorie;
	@FindBy(xpath="//a[text()='Monitors']")
	WebElement monitorsCategorie;
	@FindBy(id="nava")
	WebElement logo;
	
	public ProductCategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	
	//Check welcome user is displayed
	public void welcomeUserIsDisplayed() {
		if (userName.isDisplayed()) {
			System.out.println("Welcome user is displayed");
		} else {
			System.out.println("Welcome user is NOT displayed");
		}

	}

	//check home menu is displayed
	public void homeMenuIsDisplayed() {
		if(homeMenu.isDisplayed()) {
			System.out.println("Home menu is displayed");
		}
		else {
			System.out.println("Home menu is NOT displayed");
		}
	}
	
	//check contact menu is displayed
	public void contactMenuIsDisplayed() {
		if(contactMenu.isDisplayed()) {
			System.out.println("Contact menu is displayed");
		}
		else {
			System.out.println("Contact menu is NOT displayed");
		}
	}
	
	//check aboutUs is displayed
	public void aboutUsIsDisplayed() {
		if(aboutUsMenu.isDisplayed()) {
			System.out.println("About us menu is displayed");
		}
		else {
			System.out.println("About us menu is NOT displayed");
		}
	}
	
	//check cart is displayed
		public void cartIsDisplayed() {
			if(cartMenu.isDisplayed()) {
				System.out.println("Cart menu is displayed");
			}
			else {
				System.out.println("Cart menu is NOT displayed");
			}
		}

	//check cart is displayed
	public void logoutDisplayed() {
		if(logoutMenu.isDisplayed()) {
			System.out.println("Logout menu is displayed");
			}
			else {
				System.out.println("Logout menu is NOT displayed");
			}
		}
	
	//check phone categorie is displayed
	public void phoneDisplayed() {
		if(phoneCategorie.isDisplayed()) {
			System.out.println("Logout menu is displayed");
			}
			else {
				System.out.println("Logout menu is NOT displayed");
			}
		}

	//check lap categorie is displayed
	public void lapDisplayed() {
		if(lapCategorie.isDisplayed()) {
			System.out.println("Logout menu is displayed");
			}
			else {
				System.out.println("Logout menu is NOT displayed");
			}
		}
	
	//check monitor categorie is displayed
	public void monitorDisplayed() {
		if(monitorsCategorie.isDisplayed()) {
			System.out.println("Logout menu is displayed");
			}
			else {
				System.out.println("Logout menu is NOT displayed");
			}
		}
	
	//check logo is displayed
		public void logoDisplayed() {
			if(logo.isDisplayed()) {
				System.out.println("LOGO is displayed");
				}
				else {
					System.out.println("LOGO is NOT displayed");
				}
			}
	}
