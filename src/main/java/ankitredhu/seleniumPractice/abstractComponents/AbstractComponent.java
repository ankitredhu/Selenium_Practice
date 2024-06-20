package ankitredhu.seleniumPractice.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ankitredhu.seleniumPractice.pageObject.CartPage;

public class AbstractComponent {
	
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); 
	}
	
	//Go to home
	@FindBy(xpath ="//a[@href='index.html'] [contains(normalize-space(),'Home')]")
	WebElement homeLink;
	
	//Go to cart
	@FindBy(id="cartur")
	WebElement cartLink;
	
	By homeLinkBy = By.xpath("//a[@href='index.html'] [contains(normalize-space(),'Home')]");
	By logOutBy = By.cssSelector("#logout2");
	By addToCartWait = By.xpath("//a[normalize-space()='Add to cart']");
	
	
	public void goToHome() throws InterruptedException {
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.visibilityOfElementLocated(homeLinkBy));
		//wait.until(ExpectedConditions.elementToBeClickable(homeLink));
		wait.until(ExpectedConditions.refreshed(
			    ExpectedConditions.visibilityOfElementLocated(logOutBy)
			));
		homeLink.click();
	}
	
	public void goToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.refreshed(
			    ExpectedConditions.visibilityOfElementLocated(logOutBy)
			));
		cartLink.click();
		
	}
	
	public void waitForTheElementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForAlert() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
	//learning purpose no use in this project can be removed
	public void wasteMethod() {
		System.out.println("This method can be removed");
		
	}
	
	public void secondWasteMethod() {
		
	}
	
	public void brancTest() {
		
	}
	

}
