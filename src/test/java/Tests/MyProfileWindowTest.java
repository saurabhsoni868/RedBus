package Tests;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.MyProfileWindowPage;
import Pages.LoginInPage;


//this class is used to verify the Myprofile page on site https://Redbus.com
public class MyProfileWindowTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(MyProfileWindowTest.class);
	
	@Test
	public void ProfileWindowCheck() throws Throwable {
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
String status =  reader.getRowTestData("Sheet1", "ProfileCheck").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
			// This Line of Code will INtilizt the Browser and Launch URL
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		MyProfileWindowPage win = new MyProfileWindowPage(driver);
		LoginInPage obj3 = new LoginInPage(driver);

		extentTest = extent.startTest("Testing My Profile Info ");
		
		String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
		String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
		
		obj3.id();
		obj3.signIn();
		obj3.googlebtn();
		obj3.SwitchWindow(user_id , password);
		win.ClickOnProfileInfo();
		win.ClickOnMyProfile();
		win.EditBtNIsDisplayed();// assertion applied
		
		logger.info("-----------ProfileWindowCheck Scenario passed Succesfully-------------------");
	}
		else
		{
			// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		extentTest = extent.startTest("ProfileCheck Test");
		throw new SkipException("ProfileWindowCheck Test Case has been Skipped");
		}
	
}
}

		
		
		
		
		
		