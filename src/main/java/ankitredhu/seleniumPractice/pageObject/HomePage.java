package ankitredhu.seleniumPractice.pageObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ankitredhu.seleniumPractice.abstractComponents.AbstractComponent;

public class HomePage extends AbstractComponent {

	WebDriver driver;
	ProductDescripationPage productDescripationPage;

	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	// Laptops WebElement
	@FindBy(linkText = "Laptops")
	WebElement laptopsLink;

	// Phones WebElement
	@FindBy(linkText = "Phones")
	WebElement phonesLink;

	// Monitors WebElement
	@FindBy(linkText = "Monitors")
	WebElement monitorsLink;
	
	//Next page button
	@FindBy(id="next2")
	WebElement nextButton;
	
	@FindBy(css=".hrefch")
	List<WebElement> allProducts;
	
	

	// Go to Laptops page
	public void goToLaptopsList() {
		waitForTheElementToAppear(laptopsLink);
		laptopsLink.click();
	}

	// Go to Phones page
	public void goToPhonesList() {
		waitForTheElementToAppear(phonesLink);
		phonesLink.click();
	}

	// Go to Monitors page
	public void goToMonitorsList() {
		waitForTheElementToAppear(monitorsLink);
		monitorsLink.click();
	}
	
	// Method to get all products from current page
    public List<WebElement> getAllProducts() {
    	for (WebElement button : allProducts) {
          //System.out.println(button.getText());
  	}
        return allProducts;
    }
	
 // Method to check if there is a next page
    public boolean hasNextPage() {
        try {
            // Check visibility, enabled status, or specific attributes
            return nextButton.isDisplayed() && nextButton.isEnabled();
        } catch (Exception e) {
            return false;
        }
    }
    
 // Method to navigate to the next page
    public void goToNextPage() {
        if (hasNextPage()) {
            nextButton.click();
        }
    }
	
    
    public ProductDescripationPage getProductByName(String productName) throws InterruptedException {
    	List<WebElement> allProducts = new ArrayList<>();
    	do {
    		
    		Thread.sleep(2000);
    		List<WebElement> productsOnPage = getAllProducts();
    		allProducts.addAll(productsOnPage);
    		goToNextPage();
    		
    	}while(hasNextPage());
    	
    	  	
    	 WebElement prod = null;
    	    for (WebElement product : allProducts) {
    	        try {
    	            // Refresh the reference to the product element
    	            WebElement refreshedProduct = product.findElement(By.xpath("."));
    	            if (refreshedProduct.getText().equals(productName)) {
    	                prod = refreshedProduct;
    	                break;
    	            }
    	        } catch (StaleElementReferenceException e) {
    	            // Element became stale, skip to the next one
    	        }
    	    }
    	    prod.click();
    	    
    	    productDescripationPage = new ProductDescripationPage(driver);
    	    
    	    
    	    
    	    return productDescripationPage;
    }
    
    
    
    
    
   

    
	
	

}
