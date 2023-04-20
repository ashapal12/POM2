package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;
	By homePageUserName = By.xpath("//div[@id='WelcomeContent']");
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	//get the user name from HomePage
	public String getHomePageUserName() {
		return driver.findElement(homePageUserName).getText();
	}
}
