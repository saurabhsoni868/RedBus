package Tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.KnowTicketDetailsPage;

//this class is used to verify  the Functionality of Know ticket Details page on site https://Redbus.com
public class KnowTicketDetailsTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(KnowTicketDetailsTest.class);

	@Test(priority = 1)
	public void KnowMoreFuntionalityCheck() throws Throwable {
		
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
    String status =  reader.getRowTestData("Sheet1", "KnowMoreFeature").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{

			// This Line of Code will INtilizt the Browser and Launch URL	
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		KnowTicketDetailsPage more = new KnowTicketDetailsPage(driver);
		extentTest = extent.startTest("KnowMoreFeature Test ");

		more.clickSignin();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		String TicketNo = reader.getRowTestData("Sheet1", "KnowMoreFeature").get("TicketNO");
		more.EnterTicketNumber(TicketNo);
		String Email_Id = reader.getRowTestData("Sheet1", "KnowMoreFeature").get("Email_id");
		more.enterEmail(Email_Id);
		more.clickSubmitBtm();
		more.RedBusLogoIsPresent();// Applying Assertion that RedBus Logo is Present
		
		logger.info("-----------KnowMoreFuntionality Scenario passed Succesfully-------------------");
	}
		else
		{
		extentTest = extent.startTest("KnowMoreFeature Test ");
		// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		throw new SkipException("KnowMoreFeature Test Case has been Skipped");
		}
}
}
		
	
	
