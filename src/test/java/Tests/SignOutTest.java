package Tests;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.MyProfileWindowPage;
import Pages.LoginInPage;
import Pages.SignOutPage;
import Pages.SavedWalletCardsPages;



//this class is used to check the SignOut Functionality on site https://Redbus.com
public class SignOutTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(SignOutTest.class);
	
	@Test
	public void ValidSignOutFromAllDevices() throws Throwable {
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
String status =  reader.getRowTestData("Sheet1", "ValidSignOut").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
			// This Line of Code will INtilizt the Browser and Launch URL
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		LoginInPage obj1 = new LoginInPage(driver);
		extentTest = extent.startTest("Testing Sign Out Funtionality From All Devices with passed Assertion");
		
		String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
		String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
		
		obj1.id();
		obj1.signIn();
		obj1.googlebtn();
		obj1.SwitchWindow(user_id ,password );
		MyProfileWindowPage win = new MyProfileWindowPage(driver);
		win.ClickOnProfileInfo();
		SignOutPage sign = new SignOutPage(driver);
		sign.ClickOnSignOutFromAllDevices();
		SavedWalletCardsPages wallet1 = new SavedWalletCardsPages(driver);
		wallet1.HelpBtNIsDisplayed();//Applying assertion
		
		logger.info("-----------ValidSignOutFromAllDevices Scenario passed Succesfully-------------------");
	}
		else
		{
		extentTest = extent.startTest("ValidSignOutFromAllDevices");
		// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		throw new SkipException("ValidSignOutFromAllDevices Test Case has been Skipped");
		}
	}
		
		
		
		
		
	@Test
	public void InValidSignOutFromAllDevices() throws Throwable {
String status =  reader.getRowTestData("Sheet1", "InValidSignOut").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));
		
		LoginInPage obj1 = new LoginInPage(driver);
		extentTest = extent.startTest("Testing SignOut From All Devices With Failed Assertion");
		
		String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
		String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
		
		obj1.id();
		obj1.signIn();
		obj1.googlebtn();
		obj1.SwitchWindow(user_id , password);
		MyProfileWindowPage win = new MyProfileWindowPage(driver);
		win.ClickOnProfileInfo();
		SignOutPage sign = new SignOutPage(driver);
		sign.ClickOnSignOutFromAllDevices();
		SavedWalletCardsPages wallet1 = new SavedWalletCardsPages(driver);
		wallet1.HelpBtNIsNotDisplayed();//Applying assertion Failed Test Case
		
		logger.info("-----------InValidSignOutFromAllDevices Scenario failed-------------------");
	}
		else
		{
		extentTest = extent.startTest("InValidSignOutFromAllDevices");
		// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		throw new SkipException("InValidSignOutFromAllDevices Test Case has been Skipped");
		}

	}
}
	

	

	
	
	

	
	
	
