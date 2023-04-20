package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	WebDriver driver;
	//All webelements are identified by @FindBy Annotation
	
	@FindBy(name="username")
	@CacheLookup
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	WebElement verifyDashboard;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement login;
	
	@FindBy(xpath="//div[@class='orangehrm-login-branding']")
	WebElement verifyLoginPage;
	
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); //this init Elements will create all webelemets
	}
	
	//set username in textbox
	public void setUserName(String strUserName) {
		username.sendKeys(strUserName);
	}
	
	//set password in textbox
	public void setPasssword(String strPasswprd) {
		password.clear();
		password.sendKeys(strPasswprd);
	}
	
	//Click on login button
	public void clickLogin() {
		login.click();
	}
	
	//get the message of the login page
	public String verifyDashboardPage() {
		return verifyDashboard.getText();
	}
	public String verifyLoginPage() {
		System.out.print("++++++++++"+verifyLoginPage.getText());
		return verifyLoginPage.getText();
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
