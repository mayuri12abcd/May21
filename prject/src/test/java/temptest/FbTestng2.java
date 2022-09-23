package temptest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
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
import utils.Utility;

public class FbTestng2 extends Base{
	private WebDriver driver;
	private Services services;
	private Login login;
	private int testID;
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			driver=Base.openChromeBrowser();
		}
		if(browserName.equals("FireFox"))
		{
			driver=Base.openFirefoxBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}	@BeforeClass
	public void createPOMobjects()
	{
		login = new Login(driver);
		services = new Services(driver);

	}
	
	@BeforeMethod
	public void openServices1()
	{
		driver.get("https://www.facebook.com/");
		login.openServices();
	}
	@Test
	public void sendkeyInEmail()
	{
		testID=1500;
		services.giveEmail();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean result = url.equals("https://www.facebook.com/biz/directory/") && title.equals("Facebook services directory");
		Assert.assertTrue(result);
	}
	@Test (priority=1)
	public void sendKeysInPassword()
	{
		testID=2500;
		services.givePassword();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean result = url.equals("https://www.facebook.com") && title.equals("Facebook");
		Assert.assertFalse(result);
		
	}
	@AfterMethod
	public void logout(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreenShot(driver, testID);
		}
		System.out.println("logout");
		
	}
	
	@AfterClass
	public void cleanPOMobjects()
	{
		login=null;
		services=null;
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}


}
