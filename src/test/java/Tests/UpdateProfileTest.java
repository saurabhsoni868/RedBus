package Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CommonUtils.BaseClass;
import Pages.LoginInPage;
import Pages.UpdateProfilePage;


//this class is used to verify the Functionality of Update profile Page on site https://Redbus.com
public class UpdateProfileTest extends BaseClass {

	public final static Logger logger = Logger.getLogger(UpdateProfileTest.class);

	@Test(priority = 1)
	public void ValidUpdate() throws Throwable {
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
		String status = reader.getRowTestData("Sheet1", "ValidUpdate").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {

			// This Line of Code will INtilizt the Browser and Launch URL
			driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

			LoginInPage obj = new LoginInPage(driver);
			extentTest = extent.startTest("Update Profile Test ");
			
			String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");

			obj.id();
			obj.signIn();
			obj.googlebtn();
			obj.SwitchWindow(user_id , password);
			obj.id();
			UpdateProfilePage upd = new UpdateProfilePage(driver);
			upd.editProfile();
			String updatedName = reader.getRowTestData("Sheet1", "ValidUpdate").get("Rename");
			upd.editValidName(updatedName);
			upd.finalSelect();
			Assert.assertTrue(driver.findElement(By.id("nf_success")).isDisplayed());

			logger.info("-----------ValidUpdate Scenario passed Succesfully-------------------");
		} else {
			extentTest = extent.startTest("ValidUpdate");
			// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
			throw new SkipException("ValidUpdate Test Case has been Skipped");
		}
	}

	@Test(priority = 2)
	public void InvalidUpdate() throws Throwable {
		String status = reader.getRowTestData("Sheet1", "InvalidUpdate").get("ExecutionRequired");

		if (status.toLowerCase().trim().equals("yes")) {

			driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

			LoginInPage obj = new LoginInPage(driver);
			extentTest = extent.startTest("Update Profile Test ");

			String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
			String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
			
			obj.id();
			obj.signIn();
			obj.googlebtn();
			obj.SwitchWindow(user_id , password);
			obj.id();
			UpdateProfilePage upd = new UpdateProfilePage(driver);
			upd.editProfile();
			upd.editInvalidName();
			upd.finalSelect();
			logger.info("-----------InValidUpdate Scenario Failed-------------------");

		} else {
			// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
			extentTest = extent.startTest("InvalidUpdate");
			throw new SkipException("InvalidUpdate Test Case has been Skipped");
		}
	}
}
