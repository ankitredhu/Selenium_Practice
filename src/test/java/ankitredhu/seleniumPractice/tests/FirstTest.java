package ankitredhu.seleniumPractice.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ankitredhu.seleniumPractice.abstractComponents.AbstractComponent;
import ankitredhu.seleniumPractice.pageObject.CartPage;
import ankitredhu.seleniumPractice.pageObject.HomePage;
import ankitredhu.seleniumPractice.pageObject.LaunchApplication;
import ankitredhu.seleniumPractice.pageObject.LoginPage;
import ankitredhu.seleniumPractice.pageObject.ProductDescripationPage;
import ankitredhu.seleniumPractice.testComponents.BaseTest;

public class FirstTest extends BaseTest{
	
	WebDriver driver;
	LoginPage loginPage;
	
	
	@Test(dataProvider="getData")
	public void goTo(HashMap<String,String> input) throws IOException, InterruptedException {
	 LaunchApplication launchApplication = initialSetUp();
	 loginPage = launchApplication.launchApplication();
	 HomePage homePage = loginPage.logIn(input.get("email"),input.get("password"));
	 homePage.goToHome();
	 Thread.sleep(5000);
	 ProductDescripationPage productDescripationPage = homePage.getProductByName("MacBook Pro");
	 CartPage cartPage = productDescripationPage.addToCart();
	 Assert.assertEquals("Product added.", productDescripationPage.addToCartConformaton());
	 productDescripationPage.goToCart();
	 cartPage.checkItem("MacBook Pro");
	 cartPage.fillForm();
	 Assert.assertEquals(cartPage.orderConfromationMessage(), "Thank you for your purchase!");

	 
	}
	
	@DataProvider
	public Object[][] getData() throws IOException{

		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\ankitredhu\\seleniumPractice\\data\\loginCred.json");
		return new Object[][] {{data.get(0)}};
	}

}
	

