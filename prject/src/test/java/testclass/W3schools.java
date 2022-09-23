package testclass;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import w3schools.Childpopup;
import w3schools.Home;
public class W3schools {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","E:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.get("https://www.w3schools.com/js/js_popup.asp");
		driver.manage().window().maximize();
		
		Home home = new Home(driver);
		home.clickTryit();
		
		ArrayList<String> childb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(childb.get(1));
		
		WebElement frame = driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
		driver.switchTo().frame(frame);
		
		Childpopup childpopup= new Childpopup(driver);
		childpopup.tyitInFrame();
		Thread.sleep(3000);
		Alert alt = driver.switchTo().alert();
		alt.accept();
		
		driver.switchTo().parentFrame();
		childpopup.changeColorTheme();
		driver.switchTo().window(childb.get(0));
		//Home home1 = new Home(driver);
		home.clicknavigator();

		
	}
}
