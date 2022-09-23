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
import org.testng.asserts.SoftAssert;

import facebook.Login;
import facebook.MessengerPage;
import facebook.RoomsPage;
import setup.Base;
import utils.Utility;

public class FbTestng extends Base{
	private WebDriver driver;
	private RoomsPage roomsPage;
	private Login login;
	private MessengerPage messengerPage;
	private SoftAssert soft;
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

	}
	@BeforeClass
	public void createPOMobjects()
	{
		login = new Login(driver);
		roomsPage = new RoomsPage(driver);
		messengerPage = new MessengerPage(driver);

	}
	@BeforeMethod
	public void openRoomsPage()
	{
		driver.get("https://www.facebook.com/");
		login.messengeropen();
		messengerPage.openRomms();
		soft = new SoftAssert();

	}
	@Test
	public void verifyGoBackToMessenger()
	{
		testID=1000;
		roomsPage.goBacktomessger();
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.messenger.com/");
		System.out.println("hiiiiiiiiii");
		String title = driver.getTitle();
		soft.assertEquals(title, "Messenger","messenger title is not verified");
		soft.assertAll();
	}
	@Test
	public void verifyVisitOurHelpCentre()
	{
		testID=2000;
		roomsPage.visitOurHelpCentre();
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.messenger.com/help");
		soft.assertNotEquals(driver.getTitle(), "Messenger")	;	
		soft.assertAll();
	}
	@AfterMethod
	public void logOutfromApplication(ITestResult result) throws IOException
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
		login =null;
		roomsPage=null;
		messengerPage=null;
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}
	
}
