package ankitredhu.seleniumPractice.pageObject;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ankitredhu.seleniumPractice.abstractComponents.AbstractComponent;

public class ProductDescripationPage extends AbstractComponent{
	WebDriver driver;
	

	public ProductDescripationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	Alert alert;
	
	@FindBy(xpath="//a[normalize-space()='Add to cart']")
	WebElement addToCartButton;
	
	public CartPage addToCart() throws InterruptedException {
		waitForTheElementToAppear(addToCartButton);
		addToCartButton.click();
		return new CartPage(driver);
		
		
	}
	
	public String addToCartConformaton() {
		waitForAlert();
		alert  = driver.switchTo().alert();
		
		String confirmationMessage = alert.getText();
		alert.accept();
		return confirmationMessage;
	}

}
