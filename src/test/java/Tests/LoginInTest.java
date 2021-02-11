package Tests;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import CommonUtils.BaseClass;
import Pages.KnowTicketDetailsPage;
import Pages.LoginInPage;

//this class is used to check the functionality of Login page on site https://Redbus.com
public class LoginInTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(LoginInTest.class);
	
	@Test
	public void ValidSignIn() throws Throwable {
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
String status =  reader.getRowTestData("Sheet1", "ValidSignIn").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
			// This Line of Code will INtilizt the Browser and Launch URL
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		LoginInPage obj1 = new LoginInPage(driver);
		extentTest = extent.startTest("Valid Login with Facebook Test ");
		
		String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
		String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
		
		obj1.id();
		obj1.signIn();
		obj1.googlebtn();
		obj1.SwitchWindow(user_id,password);
		KnowTicketDetailsPage nm = new KnowTicketDetailsPage(driver);
		nm.RedBusLogoIsPresent();// Applying Assertion
	
		logger.info("-----------ValidSignIn Scenario passed Succesfully-------------------");
	}
		else
		{
		extentTest = extent.startTest("ValidSignIn");
		// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		throw new SkipException("ValidSignIn Test Case has been Skipped");
		}
	}

		
		
		

	@Test
	public void InValidSignIn() throws Throwable {
String status =  reader.getRowTestData("Sheet1", "InValidSignIn").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		LoginInPage obj2 = new LoginInPage(driver);
		extentTest = extent.startTest("Invalid Login with Facebook Test ");
		
		String user_id = reader.getRowTestData("Sheet1", "InValidSignIn").get("Username");
		String password = reader.getRowTestData("Sheet1", "InValidSignIn").get("Password");
		
	
		obj2.id();
		obj2.signIn();
		obj2.googlebtn();
		obj2.SwitchToWindow(user_id , password);
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(driver.getTitle().contains("Search Bus Tickets"));
		softAssert.assertAll();
		logger.info("-----------InValidSignIn Scenario failed-------------------");
		
		}
		else
		{
			extentTest = extent.startTest("InValidSignIn");
			throw new SkipException("InValidSignIn Test Case has been Skipped");
		}
	}
}

		

		
	
		

