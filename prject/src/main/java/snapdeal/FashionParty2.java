package snapdeal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class FashionParty2 {
	@FindBy (xpath="//div[@id='bx-pager-left-image-panel']//a")
	private WebElement spshoe;
	
	@FindBy (xpath="//span[text()='add to cart']")
	private WebElement addToCart;

	@FindBy (xpath="//div[text()='View Cart']")
	private WebElement viewCart;

	public FashionParty2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void viewCart()
	{
		spshoe.click();
		addToCart.click();
		viewCart.click();
	}
}
