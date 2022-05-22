package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderTab extends PageBase{
	
	public HeaderTab(WebDriver driver) {
		super(driver);
	}	
	
	@FindBy(id = "login2")
    WebElement loginbtn;
	
	@FindBy(id = "logout2")
    WebElement logoutbtn;
	
	@FindBy(id = "nava")
    WebElement homePageIcon;
	
	@FindBy(id = "cartur")
	WebElement showCartbtn;
	
	public void clickOnLogin() {
	    clickElement(loginbtn);
	}
	
	public void clickOnLogout() {
	    clickElement(logoutbtn);
	}
	
	public void goToHome() {
		clickElement(homePageIcon);
	}
	
	public void showCart() {
		clickElement(showCartbtn);
	}
}
