package temptest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import amazon.Amazon1;
import amazon.Cart;
import amazon.GetitToday;
import amazon.Mobilepage;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS );
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		Amazon1 amazon1=new Amazon1(driver);
		//amazon1.sendKeysInSearch();
		Thread.sleep(2000);
		Mobilepage mobilepage= new Mobilepage(driver);
		mobilepage.vivo();
		GetitToday getitToday = new GetitToday(driver);
		getitToday.getItToday();
		getitToday.acc();
		Thread.sleep(3000);
		getitToday.clickonWishList();
		Cart cart = new Cart(driver);
		cart.gotoCart();
	}
}
