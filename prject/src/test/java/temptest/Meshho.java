package temptest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;

import meshho.Color;
import meshho.Instagram;
import meshho.SearchSaree;
import meshho.WomenWestern;
public class Meshho {
	public static void main(String args[]) throws InterruptedException, IOException
	{
	System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	WebDriver driver = new ChromeDriver(option);
	driver.get("https://www.meesho.com/");
	driver.manage().window().maximize();
	
	SearchSaree searchSaree = new SearchSaree(driver);
	searchSaree.searchForSaree();
	Thread.sleep(3000);
	WomenWestern  womenWestern = new WomenWestern(driver);
	womenWestern.moveToWesternDress();
	Thread.sleep(2000);
	womenWestern.clickNightsuit();
	Color color = new Color(driver);
	color.openInstagram();
	ArrayList<String> addr = new ArrayList<String>(driver.getWindowHandles());
	driver.switchTo().window(addr.get(1));
	Thread.sleep(2000);
	
	}
}
