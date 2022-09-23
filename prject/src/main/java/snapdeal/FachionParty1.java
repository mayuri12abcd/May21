package snapdeal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FachionParty1 {
	@FindBy (xpath="//span[@class='catText']")
	private WebElement mensFashion;
	
	@FindBy (xpath="//span[text()='Casual Shoes']")
	private WebElement casualShoes;

	@FindBy (xpath="//label[@for='ShopbyOccasion_s-Party']")
	private WebElement party;

	@FindBy (xpath="(//picture[@class='picture-elem']//img)[1]")
	private WebElement partyShoes;

	public FachionParty1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void moveToMensFashion()
	{
		
	}
	public void checkCasualShoesIsDisplayedAndClick()
	{
		casualShoes.click();
	}
	public void clickParty()
	{
		party.click();
	}
	public void clickOnPartyShoes()
	{
		partyShoes.click();
	}
}
