package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


// this class is used to check the SignOut Functionality on site https://Redbus.com
public class SignOutPage {

	WebDriver driver;

	public SignOutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='signOutAllLink']")
	public WebElement Sign_Out_From_All_Devices_BUTTON;

	public void ClickOnSignOutFromAllDevices() {
		Sign_Out_From_All_Devices_BUTTON.click();
	}

}
