package Pages;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.BaseClass;


// this class is used to check the functionality of Login page on site https://Redbus.com
public class LoginInPage extends BaseClass {

	WebDriver driver;

	public LoginInPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "sign-in-icon-down")
	public WebElement Id;

	@FindBy(how = How.ID, using = "hc")
	public WebElement signIn;

	@FindBy(how = How.CLASS_NAME, using = "modalIframe")
	public WebElement frame;

	@FindBy(how = How.ID, using = "newFbId")
	public WebElement facebookBtn;

	@FindBy(how = How.ID, using = "email")
	public WebElement facebookEmail;

	@FindBy(how = How.ID, using = "pass")
	public WebElement facebookPass;

	@FindBy(how = How.ID, using = "loginbutton")
	public WebElement LoginBtn;

	@FindBy(how = How.XPATH, using = "//button[@name='__CONFIRM__']")
	public WebElement confirm;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-close']")
	public WebElement close;

	public void id() throws InterruptedException {
		Thread.sleep(5000);
		Id.click();
		Thread.sleep(2000);
	}

	public void signIn() throws Throwable {
		signIn.click();
		Thread.sleep(2000);
	}

	public void googlebtn() throws InterruptedException {
		driver.switchTo().frame(frame);
		Thread.sleep(2000);
	}

	public void SwitchWindow(String userId , String password) throws InterruptedException {

		String parentwindow = driver.getWindowHandle();

		facebookBtn.click();
		Set<String> allWindows = driver.getWindowHandles();

		int count = allWindows.size();

		for (String child : allWindows) {
			if (!parentwindow.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				facebookEmail.sendKeys(userId);
				facebookPass.sendKeys(password);
				Thread.sleep(2000);
				LoginBtn.click();
			}

		}
		Thread.sleep(5000);

		driver.switchTo().window(parentwindow);
		Thread.sleep(2000);

	}

	public void SwitchToWindow(String userId , String password) throws InterruptedException {

		String parentwindow = driver.getWindowHandle();

		facebookBtn.click();
		Set<String> allWindows = driver.getWindowHandles();

		int count = allWindows.size();

		for (String child : allWindows) {
			if (!parentwindow.equalsIgnoreCase(child)) {

				driver.switchTo().window(child);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				facebookEmail.sendKeys(userId);
				facebookPass.sendKeys(password);
				Thread.sleep(2000);
				LoginBtn.click();
				Thread.sleep(2000);

			}

		}

	}
}
