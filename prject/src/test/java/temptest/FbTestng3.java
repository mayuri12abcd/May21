package temptest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

import amazon.Amazon1;
import amazon.Cart;
import amazon.GetitToday;
import amazon.Mobilepage;
import facebook.Bulletin;
import facebook.Login;
import setup.Base;
import utils.Utility;

public class FbTestng3 extends Base{
	private WebDriver driver;
	private Login login;
	private Bulletin bulletin;
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
	bulletin= new Bulletin(driver);
}
@BeforeMethod
public void openBulletins()
{
	driver.get("https://www.facebook.com/");
	login.openBulletin();
	bulletin.clickOnLifestyle();
	bulletin.getTextfront();
	driver.navigate().back();
}
@Test
public void fillLoginDetails() throws IOException
{
	testID=100;
	String name = Utility.featchDatafromExcelSheet("Filee", 2, 0);
	String pass = Utility.featchDatafromExcelSheet("Filee", 3, 0);
	login.sendUsernameandPassword(name, pass);
}
@AfterMethod
public void logoutapplication(ITestResult result) throws IOException
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
	bulletin=null;
}
@AfterTest
public void closeBrowser()
{
	driver.close();
	driver=null;
	System.gc();
}
}
