package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


// this class is used to verify the Functionality of Safety Program Function tab on site https://Redbus.com
public class SafetyProgramPage {

	WebDriver driver;

	public SafetyProgramPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//div[@id='safetyplusClick']")
	public WebElement Safety_Know_More_BTN;

	@FindBy(how = How.XPATH, using = "//div[@class='bc']")
	public WebElement View_Safety_Plus_Btn;

	public void ClickOnSafetyKnowMore() throws Throwable {
		Safety_Know_More_BTN.click();
		Thread.sleep(2000);
	}

	public void ClickOnViewSafetyBtn() throws Throwable {
		View_Safety_Plus_Btn.click();
		Thread.sleep(2000);
	}
}