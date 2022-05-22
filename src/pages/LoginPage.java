package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends HeaderTab{
	          	
	public LoginPage(WebDriver driver) {
		super(driver);		
	}
	
    @FindBy(id = "loginusername")
    WebElement usernametxtField;

    @FindBy(id = "loginpassword")
    WebElement passwordtxtField;

    @FindBy(xpath = "//*[@onclick='logIn()']")
    WebElement loginbtn;

    public void login(String username, String password) {
        sendText(usernametxtField, username);
        sendText(passwordtxtField, password);
        clickElement(loginbtn);
    }
}    