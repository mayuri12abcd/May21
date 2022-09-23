package temptest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import facebook.Login;
import facebook.MessengerPage;
import facebook.RoomsPage;

public class Fb {
	public static void main(String args[]) throws  IOException, InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","E:\\Selenium\\geckodriver-v0.31.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Login login = new Login(driver);
		//login.sendUsername();
		//login.password();
		boolean result =login.clickonLogin();
		System.out.println(result);
		login.messengeropen();
		
		
		MessengerPage messengerPage = new MessengerPage(driver);
		messengerPage.openRomms();
		
		String text1 = driver.getCurrentUrl();
		System.out.println(text1);
		
		RoomsPage roomsPage = new RoomsPage(driver);
		roomsPage.goBacktomessger();
		
		String text2 = driver.getCurrentUrl();
		System.out.println(text2);

	}
}
