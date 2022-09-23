package temptest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import facebook.Login;
import facebook.Services;
import setup.Base;

public class TestNGClass2  {
	private WebDriver driver;
	private Services services;
	private Login login;

	
		@BeforeClass
	public void createPOMobjects()
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	}
	
	@BeforeMethod
	public void openServices1()
	{
		driver.get("https://www.facebook.com/");
		login.openServices();
		login = new Login(driver);
		services = new Services(driver);

	}
	@Test
	public void sendkeyInEmail()
	{
		services.giveEmail();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean result = url.equals("https://www.facebook.com/biz/directory/") && title.equals("Facebook services directory");
		Assert.assertTrue(result);
	}
	@Test (priority=1)
	public void sendKeysInPassword()
	{
		services.givePassword();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean result = url.equals("https://www.facebook.com") && title.equals("Facebook");
		Assert.assertFalse(result);
		
	}
	@AfterMethod
	public void logout()
	{
		System.out.println("logout");
	}
	
	@AfterClass
	public void cleanPOMobjects()
	{
		driver.close();
	}


}
