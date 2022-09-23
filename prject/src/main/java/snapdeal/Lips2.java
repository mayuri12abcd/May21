package snapdeal;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class Lips2 {
	@FindBy (xpath="//ul[@id='bx-slider-left-image-panel']//img")
	private WebElement lipstick;
	
	@FindBy (xpath="//span[@class='intialtext']")
	private WebElement buyNow;
	
	public Lips2(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void zoomLipstick()
	{
		
	}
	public void clickBuyNow()
	{
		buyNow.click();
	}
}
