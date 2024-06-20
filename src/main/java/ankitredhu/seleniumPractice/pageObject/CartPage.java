package ankitredhu.seleniumPractice.pageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ankitredhu.seleniumPractice.abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//items in the cart
	@FindBy(xpath="//tbody[@id='tbodyid']//td[2]")
	List<WebElement> allItemsInCart;
	
	//place order button
	@FindBy(xpath="//button[normalize-space()='Place Order']")
	WebElement placeOrderButton;
	
	//Form fields
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="card")
	WebElement creditCard;
	
	@FindBy(id="month")
	WebElement month;
	
	@FindBy(id="year")
	WebElement year;
	
	//purchage button
	@FindBy(xpath="//button[@onclick='purchaseOrder()']")
	WebElement purchage;
	
	//conformation message
	@FindBy(xpath="//h2[normalize-space()='Thank you for your purchase!']")
	WebElement conformationMessage;
	
	public void checkItem(String item) {
		for(WebElement itemPlaceHolder: allItemsInCart) {
			if(itemPlaceHolder.getText().equals(item)){
				placeOrderButton.click();				
				return;
			}
		}
	}
	
	public void fillForm() {
		name.sendKeys("Ankit");
		country.sendKeys("AUS");
		city.sendKeys("Melborn");
		creditCard.sendKeys("2342323432324242");
		month.sendKeys("June");
		year.sendKeys("1998");
		purchage.click();
	}
	
	public String orderConfromationMessage() {
		waitForTheElementToAppear(conformationMessage);
		return conformationMessage.getText();
	}

}
