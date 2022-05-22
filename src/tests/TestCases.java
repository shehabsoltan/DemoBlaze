package tests;

import static org.testng.Assert.assertTrue;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.Cart;
import pages.HeaderTab;
import pages.HomePage;
import pages.LoginPage;

public class TestCases extends TestBase{
	
	HeaderTab header;
	LoginPage loginPage;
	HomePage homePageObj;
	AddToCartPage addCartPageObj;
	Cart cart;
	
	@BeforeClass
	public void login() throws InterruptedException{
		header = new HeaderTab(driver);
		header.clickOnLogin();
		
		loginPage = new LoginPage(driver);  
		loginPage.login("test", "test");	
		Thread.sleep(3000);
	}

	@Test
	public void firstScenario() {

		homePageObj = new HomePage(driver);
		homePageObj.addSecondItem();
		
		addCartPageObj = new AddToCartPage(driver);
		String addItem = addCartPageObj.addedItemName();
		
		assertTrue(addItem.contains("Nokia"));
		
		assertTrue(addCartPageObj.getAlertMessage().contains("Product added"));
		addCartPageObj.acceptAlert();
	}
	
	
	@Test
	public void secondScenario() throws InterruptedException {
		
		header = new HeaderTab(driver);
		header.goToHome();
		
		homePageObj = new HomePage(driver);
		homePageObj.addfirstItem();
		
		addCartPageObj = new AddToCartPage(driver);
		String addedItem = addCartPageObj.addedItemName();
		addCartPageObj.acceptAlert();
		
		header = new HeaderTab(driver);
		header.showCart();
		
		Thread.sleep(3000);
		cart = new Cart(driver);
		Assert.assertTrue(cart.getFirstProductName().contains(addedItem));	
		Assert.assertTrue(cart.getTotalPrice()==cart.getActualTotalPrice());
	}
	
	
	@AfterClass
	public void logout() {
		header = new HeaderTab(driver);
		header.clickOnLogout();
	}
	
	
	

}
