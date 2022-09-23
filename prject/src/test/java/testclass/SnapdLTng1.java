package testclass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import snapdeal.Lips1;
import snapdeal.Lips1_5;

public class SnapdLTng1 {
	private WebDriver driver;
	private Lips1_5 lips1_5;
	@BeforeClass
	public void launchBrowser()
	{
		System.out.println("Before class");
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}
	@BeforeMethod
	public void openLipstick()
	{
		System.out.println("before method");
		driver.get("https://www.snapdeal.com/");
		
		Lips1 lips1 = new Lips1(driver);
		lips1.searchLips();
		lips1.lipsclick();
		lips1_5 = new Lips1_5(driver);

	}
	@Test(priority=1)	
	public void kurtiSet() throws InterruptedException
	{
		System.out.println("Test 1");
		Thread.sleep(3000);
		lips1_5.openLips();
		String url = driver.getCurrentUrl();
		System.out.println(url);
		String title = driver.getTitle();
		System.out.println(title);

	}
	@Test(priority=2)
	public void signIn1() throws InterruptedException
		{
			System.out.println("test 2");
			Thread.sleep(3000);
			lips1_5.signIn1();
			String url = driver.getCurrentUrl();
			System.out.println(url);
			String title = driver.getTitle();
			System.out.println(title);
		}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("after method");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("after class");
	}
	
	

}
