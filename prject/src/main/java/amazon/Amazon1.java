package amazon;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.Utility;

public class Amazon1 {
	private WebDriver driver;

	@FindBy (xpath="//input[@id='twotabsearchtextbox']")
	private WebElement search;
	
	public Amazon1(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sendKeysInSearch(String value) throws IOException
	{
		search.sendKeys(value);
		search.sendKeys(Keys.ENTER);
	}
	public void sendKeysasPurse(String value)
	{
		search.sendKeys(value);
		search.sendKeys(Keys.ENTER);

	}

}
