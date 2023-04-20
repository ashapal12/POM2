package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageFactory.HomePage;
import pageFactory.Login;

public class TestLoginWithPageFactory {

	WebDriver driver;
	Login objLogin;
	HomePage objHomePage;
	
	@BeforeClass
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/001AK9744/Documents/chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}
	
	@Test
	public void test_Home_Page_Appear_Correct() {
		objLogin = new Login(driver);
		
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		objLogin.loginToApplication("Admin", "admin123");
		//go to next page
		objHomePage = new HomePage(driver);
		//verify the home page
				String loginPageMessage = objLogin.verifyDashboardPage();
				Assert.assertTrue(loginPageMessage.contains("Dashboard"));
		
	}
}
