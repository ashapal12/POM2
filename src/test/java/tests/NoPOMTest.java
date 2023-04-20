package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NoPOMTest {

	@Test
	public void test_Home_Page_Appear_Correct() {
		System.setProperty("webdriver.chrome.driver", "C:/Software/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://petstore.octoperf.com/actions/Account.action?signonForm=");
		driver.findElement(By.name("username")).sendKeys("j2ee");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("j2ee");
		driver.findElement(By.name("signon")).click();
		
		String homeText = driver.findElement(By.xpath("//div[@id='WelcomeContent']")).getText();
		System.out.println(homeText);
		//verify login success
		Assert.assertTrue(homeText.contains("Welcome"));
		
	}
}
