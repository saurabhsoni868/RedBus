package Pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import CommonUtils.BaseClass;

// this class is used to verify the functionalities of check the Completed Trips on site https://Redbus.com
public class CompleteTripsWindowPage {

	WebDriver driver;

	public CompleteTripsWindowPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//*[@id='Completed']")
	public WebElement Completed_Trips_BUTTON;

	@FindBy(how = How.XPATH, using = "//*[@id='Upcoming']")
	public WebElement Upcoming_Trips_BUTTON;

	public void ClickOnCompletedTripsBTN() throws Throwable {
		Completed_Trips_BUTTON.click();
		Thread.sleep(2000);
	}

	public void UpComingTripBtnIsPresent() {
		Assert.assertEquals(true, Upcoming_Trips_BUTTON.isDisplayed());// Assertion
	}

	public void UpComingTripBtnIsNotPresent() throws Throwable {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertFalse(Upcoming_Trips_BUTTON.isDisplayed());
		
		softAssert.assertAll();
	}

}