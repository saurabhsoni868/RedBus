
package Tests;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.MyTripsPage;
import Pages.LoginInPage;


//this class is used to verify the MyTrips page Functionalities on site https://Redbus.com
public class MyTripsTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(MyTripsTest.class);
	
	@Test
	public void MyTripsWindow() throws Throwable {
		
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
String status =  reader.getRowTestData("Sheet1", "MyTrips").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
			// This Line of Code will INtilizt the Browser and Launch URL
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		LoginInPage obj1 = new LoginInPage(driver);
		MyTripsPage win = new MyTripsPage(driver);
		extentTest = extent.startTest("Testing My Trips Button Funtionnality with passed assertion ");

		String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
		String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
		
		obj1.id();
		obj1.signIn();
		obj1.googlebtn();
		obj1.SwitchWindow(user_id ,password );
		win.ClickOnUserIconBtn();
		win.ClickOnMyTripsBtn();
		win.CompletedBtNIsDisplayed();// Appling Assertion That Completed trips button is displayed
		
		logger.info("-----------MyTripsWindow Scenario passed Succesfully-------------------");
	}
		else
	{
			// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
	extentTest = extent.startTest("MyTrips Test");
	throw new SkipException("MyTrips Test Case has been Skipped");
	}
	}
		
		
		
		
		
		

	@Test
	public void MyTripsWindowFailed() throws Throwable {
String status =  reader.getRowTestData("Sheet1", "MyTripsFailedTest").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		LoginInPage obj1 = new LoginInPage(driver);
		MyTripsPage win = new MyTripsPage(driver);
		extentTest = extent.startTest("Testing My Trips Button Funtionnality with failed assertion ");

		String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
		String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
		
		obj1.id();
		obj1.signIn();
		obj1.googlebtn();
		obj1.SwitchWindow(user_id ,password );
		win.ClickOnUserIconBtn();
		win.ClickOnMyTripsBtn();
		win.CompletedBtNIsNotDisplayed();// Appling Assertion(Failed) that completed trips button is not displayed
		
		logger.info("-----------MyTripsWindow Scenario failed-------------------");
	}
		else
		{
		extentTest = extent.startTest("MyTripsFailedTest");
		throw new SkipException("MyTripsWindow Test Case has been Skipped");
		}
	}
}
		
	
		
		
	
		
