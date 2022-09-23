package facebook;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Bulletin {
	@FindBy (xpath="(//a[@target='_self'])[7]")
	private WebElement lifestyle;
	@FindBy (xpath="//div[text()='Tune into new conversations.']")
	private WebElement text;
	@FindBy (xpath="(//input[@placeholder='Search Bulletin'])[2]")
	private WebElement search;
	private WebDriver driver;
	private WebDriverWait wait;
	public Bulletin(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait  = new WebDriverWait(driver,10);

	}
	
	public void clickOnLifestyle()
	{
		lifestyle.click();
	}
	public void getTextfront()
	{
		wait  = new WebDriverWait(driver,10);

		wait.until(ExpectedConditions.visibilityOf(text));
		String name =text.getText();
		System.out.println(name);
	}
	
	}

