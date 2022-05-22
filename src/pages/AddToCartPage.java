package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class AddToCartPage extends HeaderTab{
	
	public AddToCartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(className = "name")
    WebElement productName;
	
	@FindBy(xpath = "//*[@onclick='addToCart(2)']")
    WebElement addToCartbtn;
	
	public String addedItemName () {
				
		clickElement(addToCartbtn);
		return productName.getText();
	}
}
