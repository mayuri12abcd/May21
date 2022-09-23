package temptest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
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
import setup.Base;
import utils.Utility;

public class AmazonTng1 extends Base{
	private WebDriver driver;
	private Mobilepage mobilepage;
	private Amazon1 amazon1;
	private GetitToday getitToday;
	private SoftAssert soft;
	private Cart cart;
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
		amazon1=new Amazon1(driver);
		mobilepage= new Mobilepage(driver);
		getitToday = new GetitToday(driver);
		cart = new Cart(driver);

	}
	@BeforeMethod
	public void openMobile() throws IOException
	{
		System.out.println("before method");
		driver.get("https://www.amazon.in/");
		
		String data = Utility.featchDatafromExcelSheet("Filee", 0, 0);
		amazon1.sendKeysInSearch(data);
		soft = new SoftAssert();

	}
	@Test
	public void selectVivo()
	{
		testID=100;
		System.out.println("Test 1");
		mobilepage.vivo();
		getitToday.getItToday();
		String title = driver.getTitle();
		if(title.equals("Amazon.in : Mobile"))
		{
			System.out.println("correct");
		}
		else
		{
			soft.fail();
		}
		soft.assertAll();
	}
	@Test
	public void selectOppo()
	{
		testID=200;
		System.out.println("Test 2");
		mobilepage.oppo();
		getitToday.getItToday();
		String title = driver.getTitle();
		if(title.equals("Amazon.in : Mobile"))
		{
			System.out.println("correct");
		}
		else
		{
			soft.fail();
		}
		soft.assertAll();
	}

	@AfterMethod
	public void gotoCart()
	{
		System.out.println("logout");
		getitToday.acc();
		//Thread.sleep(3000);
		getitToday.clickonWishList();
		cart.gotoCart();
	}
	@AfterClass
	public void cleanPOMobjects()
	{
		amazon1=null;
		mobilepage=null;
		getitToday=null;
		cart=null;
	}
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}

	

}
