package ankitredhu.seleniumPractice.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import ankitredhu.seleniumPractice.abstractComponents.AbstractComponent;

public class LaunchApplication extends AbstractComponent{
	
	WebDriver driver;
	LoginPage loginPage;
	public LaunchApplication(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public LoginPage launchApplication() {
		driver.get("https://demoblaze.com/");
		loginPage = new LoginPage(driver);
		return loginPage;
	}
	
	
	
	

}
