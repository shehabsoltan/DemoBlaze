package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
    protected WebDriver driver;
    protected WebDriverWait wait;

    PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, 5);
    }

    protected void visibilityWait(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }


    protected void clickElement(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected void sendText(WebElement element, String text) {
        visibilityWait(element);
        element.clear();
        element.sendKeys(text);
    }

    public String getAlertMessage() {
    	wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert().getText();
    }

    public void acceptAlert() {
    	wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

}
