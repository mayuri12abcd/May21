package temptest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import amazon.GetitToday;
import amazon.Mobilepage;
import amazon.Purse;
import setup.Base;
import utils.Utility;

public class AmazonTng2 extends Base{
	private WebDriver driver;
	private Amazon1 amazon1;
	private  Purse purse;
	private GetitToday getitToday;
	private int testID;
	private SoftAssert soft;
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
		amazon1=new Amazon1(driver);
        purse = new Purse(driver);
		getitToday = new GetitToday(driver);

	}
	@BeforeMethod
	public void openPurse() throws IOException
	{
		
		System.out.println("before method");
		driver.get("https://www.amazon.in/");
		String data = Utility.featchDatafromExcelSheet("Filee", 1, 0);
		soft = new SoftAssert();
		amazon1.sendKeysasPurse(data);
	}
	@Test
	public void pursecolorChoose()
	{
		testID=1000;

		System.out.println("Test 1");
		purse.colorOfPurse();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
	}
	@Test
	public void gotoAcc()
	{
		testID=2000;

		System.out.println("Test 2");

		getitToday.acc();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);
		boolean result = title.equals("Amazon.in : Purse");
		
		soft.assertTrue(result);
		soft.assertAll();
	}
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
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
		amazon1=null;
		purse=null;
		getitToday=null;
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}


}
