package w3table;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Table1 {
	@FindBy  (xpath="//table[@id='customers']//td")
	private List<WebElement> cells;
	
	public Table1(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void fetchdataInTable()
	{
		int size =cells.size();
		for(int i=0;i<size;i++)
		{
		String text=cells.get(i).getText();
		System.out.println(text);
		}
	}
}
