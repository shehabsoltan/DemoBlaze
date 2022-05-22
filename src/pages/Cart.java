package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cart extends HeaderTab{

	public Cart(WebDriver driver) {
		super(driver);
		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='btn btn-success']")));
		
	}
	
	@FindBy(xpath = "(//tr[@class='success']/td[2])[1]")
    WebElement firstProductName;
	
	@FindBy(xpath = "//tr[@class='success']/td[3]")
	List<WebElement> pricesList;
	
	@FindBy(id = "totalp")
    WebElement actualTotalPrice;
	
	int totalPrice = 0;
	
	public String getFirstProductName() {
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("totalp")));
		return firstProductName.getText();
	}
	
    public int getTotalPrice() {
        for (WebElement price : pricesList) {
             totalPrice += Integer.parseInt(price.getText());
        }
        return totalPrice;
    }
    
    public int getActualTotalPrice() {
    	return Integer.valueOf(actualTotalPrice.getText());
     }
	

}
