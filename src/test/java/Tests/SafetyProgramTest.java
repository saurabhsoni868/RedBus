package Tests;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.SafetyProgramPage;
import Pages.SavedWalletCardsPages;


//this class is used to verify the Functionality of Safety Program Function tab on site https://Redbus.com
public class SafetyProgramTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(SafetyProgramTest.class);
	

	@Test
	public void SafetyProgramFuntionalityCheck() throws Throwable {
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
String status =  reader.getRowTestData("Sheet1", "SafetyFuntionality").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{

			// This Line of Code will INtilizt the Browser and Launch URL
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		SafetyProgramPage safety = new SafetyProgramPage(driver);
		extentTest = extent.startTest("Testing Safety Program Funtionality");
		safety.ClickOnSafetyKnowMore();
		safety.ClickOnViewSafetyBtn();
		SavedWalletCardsPages ab = new SavedWalletCardsPages(driver);
		ab.HelpBtNIsDisplayed();// Applying Assertion that help btn is displayed
		
		logger.info("-----------SafetyProgramFuntionalityCheck Scenario passed Succesfully-------------------");	
	}
		else
		{
			// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		extentTest = extent.startTest("SafetyProgramFuntionalityCheck");
		throw new SkipException("SafetyProgramFuntionalityCheck Test Case has been Skipped");
		}
	
}
}

		
