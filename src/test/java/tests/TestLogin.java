package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Login;


public class TestLogin {

	WebDriver driver;
	Login objLogin;
	HomePage objHomePage;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/001AK9744/Documents/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
	}
	
	@Test
	public void test_Home_Page_Appear_Correct() {
		objLogin = new Login(driver);
		//verify the message on login page
		String loginPageMessage = objLogin.getLoginMessage();
		Assert.assertTrue(loginPageMessage.contains("Please enter"));
		
		objLogin.loginToApplication("j2ee", "j2ee");
		//go to next page
		objHomePage = new HomePage(driver);
		//verify the home page
		Assert.assertTrue(objHomePage.getHomePageUserName().contains("Welcome"));
	}
}
