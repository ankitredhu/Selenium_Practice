package ankitredhu.seleniumPractice.pageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ankitredhu.seleniumPractice.abstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="login2")
	WebElement loginButton;
	
	@FindBy(id="loginusername")
	WebElement userName;
	
	@FindBy(id="loginpassword")
	WebElement userPassword;
	
	@FindBy(css="button[onclick='logIn()']")
	WebElement login;
	
	By byUsername = By.id("loginusername");
	By byPassword = By.id("loginpassword");
	
	public HomePage logIn(String inputUserName, String inputPassword) throws InterruptedException {
		
		loginButton.click();
		waitForTheElementToAppear(userName);
		userName.sendKeys(inputUserName);
		waitForTheElementToAppear(userPassword);
		userPassword.sendKeys(inputPassword);
		login.click();
		return new HomePage(driver);
		
		
	}
	

}
