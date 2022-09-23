package amazon;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Purse {
	private WebDriver driver;
 @FindBy (xpath="(//div[@class='colorsprite aok-float-left'])[7]")
 private WebElement colorchoose;
 private JavascriptExecutor js;
 
 public Purse(WebDriver driver)
 {
	 PageFactory.initElements(driver, this);
	 this.driver=driver;
 }
 
 public void colorOfPurse()
 {
	 js =(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView(true);", colorchoose);
	 colorchoose.click();
 }
}
