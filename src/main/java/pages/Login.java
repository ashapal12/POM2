package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

	WebDriver driver;
	
	private By user = By.name("username");
	private By password = By.name("password");
	private By message=By.xpath("//p[contains(text(),'Please enter')]");
	private By login = By.name("signon");
	
	public Login(WebDriver driver) {
		this.driver = driver;
	}
	
	//set username in textbox
	public void setUserName(String strUserName) {
		driver.findElement(user).sendKeys(strUserName);
	}
	
	//set password in textbox
	public void setPasssword(String strPasswprd) {
		driver.findElement(password).clear();
		driver.findElement(password).sendKeys(strPasswprd);
	}
	
	//Click on login button
	public void clickLogin() {
		driver.findElement(login).click();
	}
	
	//get the message of the login page
	public String getLoginMessage() {
		return driver.findElement(message).getText();
	}
	
	//This POM method will be exposed in test cases to login to application
	
	public void loginToApplication(String strUserName, String strPasswprd) {
		//Fill user name
		this.setUserName(strUserName);
		//Fill password
		this.setPasssword(strPasswprd);
		//click login button
		this.clickLogin();
	}
}
