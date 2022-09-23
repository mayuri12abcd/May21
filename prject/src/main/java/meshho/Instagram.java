package meshho;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Instagram {
	@FindBy (xpath="//span[text()='Meesho  @meeshoapp']")
	private WebElement meshholink;
	
	@FindBy (xpath="(//img[@class='_aa8j'])[1]")
	private WebElement meshhoimage;
	@FindBy (xpath="//input[@aria-label='Search input']")
	private WebElement instaSearch;
	@FindBy (xpath="(//button[@class='_acan _acap _acat'])[2]")
	private WebElement follow;
	public Instagram(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void getTextofInsta()
	{
		String text = meshholink.getText();
		String text1 = meshhoimage.getText();
		System.out.println(text+ " text of link");
		System.out.println(text1 + " text of image");
	}
	public void sendKeysInSearch()
	{
		instaSearch.sendKeys("Hello");
	}
	public void findTagnameofFollow()
	{
		String text = follow.getTagName();
		System.out.println(text);
	}
}
