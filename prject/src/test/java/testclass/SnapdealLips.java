package testclass;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import snapdeal.Lips1;
import snapdeal.Lips1_5;
public class SnapdealLips {
	public static void main(String args[]) throws  IOException, InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.snapdeal.com/");
		
		Lips1 lips1 = new Lips1(driver);
		lips1.searchLips();
		lips1.lipsclick();
		Lips1_5 lips1_5 = new Lips1_5(driver);
		lips1_5.openLips();
}
}
