package pages;
import java.time.Duration;
import java.util.List;


import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectBasicMethods;

public class ProductDetails extends ProjectBasicMethods{
	WebDriver driver;
	@FindBy(xpath="//a[contains(text(),'Samsung galaxy s6')]")
	WebElement productPage;
	@FindBy(css=".price-container")
	WebElement priceDetails;
	@FindBy(css=".name")
	WebElement productName;
	@FindBy(xpath="//div/strong")
	WebElement prdDecriptionHeading;
	@FindBy(xpath="//div/p[contains(text(),'The Samsung')]")
	WebElement productDescription;
	@FindBy(xpath="//a[text()='Add to cart']")
	WebElement addToCart;
	@FindBy(id="cartur")
	WebElement cartBtn;
	@FindBy(xpath="//table/tbody//tr")
	List<WebElement> cartCount;
	@FindBy(xpath="//a[contains(text(),'Nokia lumia 1520')]")
	WebElement product2;
	@FindBy(xpath = "//a[text()='Home ']")
	WebElement homeMenu;
	@FindBy(id= "totalp")
	WebElement totalPrice;
	public ProductDetails(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	//product detail page
	public void productDetailsPage() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    try {
	        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Samsung galaxy s6')]")));
	        product.click();
	    } catch (StaleElementReferenceException e) {
	        System.out.println("Element became stale, retrying...");
	        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Samsung galaxy s6')]")));
	        product.click();
	    }
	}


	//price details check
	public String priceDetails() {
		String displayPrice= priceDetails.getText().split("\\*")[0].trim();
		return displayPrice;
	}
	
	//product name check
	public String productName() {
		String displayName=productName.getText();
		return displayName;
	}
	
	//product description text check
	public void productDescriptionText() {
		if(prdDecriptionHeading.isDisplayed()) {
			System.out.println("Product description text is displayed");
		}
		else {
			System.out.println("Product description text is not displayed");
		}
	}
	
	//product description check
	public String productDescription() {
		String displayDescription= productDescription.getText();
		return displayDescription;
	}
	
	
	
	
	//adding a product to cart
	public String addToCart() {
		addToCart.click();
		
	//Explicitly wait
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
	//Alert message
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		alert.accept();
		return alertMsg;
	}
	

	
	
	//back to home page
	public void homePage() {
		homeMenu.click();
	}
	
	//adding another product to cart page
	public String addAnotherProductToCart() {
		product2.click();
		addToCart.click();
		
		//Explicitly wait
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.alertIsPresent());
		
		//Alert message
		Alert alert=driver.switchTo().alert();
		String alertMsg=alert.getText();
		alert.accept();
		return alertMsg;
	}
	
	//product count increment in cart page
	 public void cartBtn() {
		 cartBtn.click();
		 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	       wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table/tbody/tr")));
		 
	//count products in cart
	System.out.println("Total products in cart: "+cartCount.size() );
	 }
	 
		public void totalPrice() {
			System.out.println("Total Price: "+totalPrice.getText());
		}
	 
	//delete items from cart
		public void deleteItemsfromCart() {
		  if(!cartCount.isEmpty()) {
			  WebElement lastItem=cartCount.get(cartCount.size()-1);
			  WebElement deleteBtn=lastItem.findElement(By.xpath("//td/a[contains(text(),'Delete')]"));
			  deleteBtn.click();
			  
			  // Wait until the item is removed
		        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		        wait.until(ExpectedConditions.stalenessOf(lastItem));
		        
		        // Refresh cart count after deletion
		        cartCount = driver.findElements(By.xpath("//table/tbody/tr"));
		        System.out.println("Total products after deleting: " + cartCount.size());
		  }
		  else {
			  System.out.println("The cart is empty...!!");
		  }
		  System.out.println("Total product after deleting: "+cartCount.size());
		}
		
		
		
		public void totalPriceAfterDeleting() {
			System.out.println("Total price after deleting item from cart: "+totalPrice.getText());
		}
		 
}
