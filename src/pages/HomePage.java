package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends HeaderTab{
	
	
	public HomePage(WebDriver driver) {
		super(driver);
				
	}
	
	@FindBy(xpath = "(//*[@href='prod.html?idp_=2'])[2]")
    WebElement secondItemInList;
	
	@FindBy(xpath = "(//*[@href='prod.html?idp_=2'])[1]")
    WebElement firstItemInList;
	 
	
	public void addSecondItem () {
        clickElement(secondItemInList);
	}
	
	public void addfirstItem() {
		clickElement(firstItemInList);
	}

}
