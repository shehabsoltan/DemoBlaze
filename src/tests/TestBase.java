package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestBase {
	
	protected WebDriver driver;
	
	@BeforeSuite
	public void startDriver() {
		
		String dPath = System.getProperty("user.dir") + "\\drivers\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", dPath);

		driver = new ChromeDriver();
		
		driver.get("https://www.demoblaze.com");
		driver.manage().window().maximize();
	}
	
	@AfterSuite
	public void quit()
	{
		driver.quit();
	}
	


}
