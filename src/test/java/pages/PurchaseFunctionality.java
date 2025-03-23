package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectBasicMethods;

public class PurchaseFunctionality extends ProjectBasicMethods {

	WebDriver driver;
	@FindBy(xpath="//button[contains(text(),'Place Order')]")
	WebElement placeOrder;
	
	@FindBy(id="name")
	WebElement nameField;
	
	@FindBy(id="country")
	WebElement countryField;
	
	@FindBy(id="city")
	WebElement cityField;
	
	@FindBy(id="card")
	WebElement creditCardField;
	
	@FindBy(id="month")
	WebElement monthField;
	
	@FindBy(id="year")
	WebElement yearField;
	
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	WebElement purchase;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement okBtn;
	
	public PurchaseFunctionality(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	public void redirectionToPlaceOrderWindow() {
		placeOrder.click();
		System.out.println("The page is redirected to: "+placeOrder.getText()+" window from cart page");
	}
	
	public void nameFieldIsDisplayed() {
		if(nameField.isDisplayed()) {
			System.out.println("The name field is displayed");
		}
		else {
			System.out.println("The name field is NOT displayed");
		}
	}
	
	public void countryFieldIsDisplayed() {
		if(countryField.isDisplayed()) {
			System.out.println("The country field is displayed");
		}
		else {
			System.out.println("The country field is NOT displayed");
		}
	}
	
	public void cityFieldIsDisplayed() {
		if(cityField.isDisplayed()) {
			System.out.println("The city field is displayed");
		}
		else {
			System.out.println("The city field is NOT displayed");
		}
	}
	
	public void creditCardFieldIsDisplayed() {
		if(creditCardField.isDisplayed()) {
			System.out.println("The credit card field is displayed");
		}
		else {
			System.out.println("The credit card field is NOT displayed");
		}
	}
	
	public void monthFieldIsDisplayed() {
		if(monthField.isDisplayed()) {
			System.out.println("The month field is displayed");
		}
		else {
			System.out.println("The month field is NOT displayed");
		}
	}
	
	public void yearFieldIsDisplayed() {
		if(yearField.isDisplayed()) {
			System.out.println("The year field is displayed");
		}
		else {
			System.out.println("The year field is NOT displayed");
		}
	}
	
	public void fillOrderDetails(String name,String country,String city, String creditCard, String month, String year) {
		nameField.sendKeys(name);
		countryField.sendKeys(country);
		cityField.sendKeys(city);
		creditCardField.sendKeys(creditCard);
		monthField.sendKeys(month);
		yearField.sendKeys(year);
		purchase.click();
		
	}	
	
	public void openPopUp() {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("sweet-alert")));
		WebElement popup=driver.findElement(By.className("sweet-alert"));
		String popuptxt=popup.getText();
		System.out.println("popupMsg: "+popuptxt);
		
		if(okBtn.isDisplayed()) {
			System.out.println("OK button is displayed");
		}
		else {
			System.out.println("OK button is NOT displayed");
		}
		okBtn.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Home ']")));
	
	}
	
	public void reClick() {
		purchase.click();
		okBtn.click();
	}
}
