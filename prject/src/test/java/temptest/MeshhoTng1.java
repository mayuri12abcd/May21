package temptest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import meshho.Color;
import meshho.Instagram;
import meshho.SearchSaree;
import meshho.WomenWestern;

public class MeshhoTng1 {
	private WebDriver driver;
	private SearchSaree searchSaree;
	private WomenWestern  womenWestern;
	private Color color;
	private ArrayList<String> addr;
	private Instagram instagram;
	@Parameters ("browser")
	@BeforeTest
	public void launchBrowser(String browserName)
	{
		if(browserName.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			driver = new ChromeDriver(option);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}
	
	@BeforeClass
	public void createPOMobjects()
	{
		searchSaree = new SearchSaree(driver);
		womenWestern = new WomenWestern(driver);
		color = new Color(driver);
		addr = new ArrayList<String>(driver.getWindowHandles());
		 instagram = new Instagram(driver);

	}
	@BeforeMethod
	public void beforeMethod() throws InterruptedException
	{
		System.out.println("before method");
		driver.get("https://www.meesho.com/");
		
		searchSaree.searchForSaree();
		Thread.sleep(3000);
		womenWestern.moveToWesternDress();
		Thread.sleep(2000);
		womenWestern.clickNightsuit();
		color.openInstagram();
		driver.switchTo().window(addr.get(1));

	}
	@Test
	public void test1()
	{
		System.out.println("test 1");
		instagram.sendKeysInSearch();
		String url = driver.getCurrentUrl();
		if(url.equals("https://www.instagram.com/meeshoapp/"));
		{
			System.out.println("test case pass");
		}
	}
		
	
	@AfterMethod
	public void cleanPOMobjects()
	{
		searchSaree=null;		
		womenWestern=null;
		color=null;
		addr=null;
		instagram=null;
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
		driver=null;
		System.gc();
	}

}
