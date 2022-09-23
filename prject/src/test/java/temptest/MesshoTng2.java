package temptest;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import meshho.Carrier;
import meshho.SearchSaree;

public class MesshoTng2 {
	private WebDriver driver;
	private SoftAssert soft;
	private SearchSaree searchSaree;
	private Carrier carrier;
	private ArrayList<String> add;
	
	
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		
			System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);
		
	}
	@BeforeClass
	public void createPOMobjects()
	{
		searchSaree = new SearchSaree(driver);
		carrier = new Carrier(driver);
		add = new ArrayList<String>(driver.getWindowHandles());
	}
	@BeforeMethod
	public void Meesho()
	{
		System.out.println("before method");
		driver.get("https://www.meesho.com/");
		
		searchSaree.searchForSaree();
		searchSaree.gotoCarriers();
		soft = new SoftAssert();

	}
	@Test	(priority=2)
	public void clickOnHome()
	{
		System.out.println("Test 2");
		driver.switchTo().window(add.get(2));
		carrier.clickhome();
		String url = driver.getCurrentUrl();
		soft.assertEquals(url, "https://www.meesho.io/");
		String title = driver.getTitle();
		soft.assertEquals(title, "Meesho Careers Home | Software Engineer Jobs, Graphic Design Jobs");
		System.out.println("executed");
		soft.assertAll();
			}
	@Test (priority=1)
	public void clcikOnNews()
	{
		System.out.println("Test 1");
		driver.switchTo().window(add.get(1));
		carrier.clicknews();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean result = url.equals("https://www.meesho.io/") && title.equals("Meesho Careers Home | Software Engineer Jobs, Graphic Design Jobs");
		soft.assertFalse(result);
		System.out.println("correct");
		soft.assertAll();
			}
	@Test (dependsOnMethods= {"clickOnHome"})
	public void clickOnLifeAtMessho()
	{
		System.out.println("Test 3");
		driver.switchTo().window(add.get(3));
		carrier.clickLifeAtMessho();
		String url = driver.getCurrentUrl();
		String title = driver.getTitle();
		boolean result = url.equals("https://www.meesho.io/") && title.equals("Meesho Careers Home | Software Engineer Jobs, Graphic Design Jobs");
		soft.assertFalse(result);
		System.out.println("correct");
		soft.assertAll();
			}

	@AfterMethod
	public void cleanPOMobjects()
	{
		searchSaree=null;
		carrier=null;
		add=null;
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
		
	}
	

}
