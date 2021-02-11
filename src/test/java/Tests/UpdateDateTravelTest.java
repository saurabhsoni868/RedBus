package Tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.UpdateDateTravelPage;
import Pages.FindBusPage;


//this class is used to Check the Functionality of Update travel date Page on site https://Redbus.com
public class UpdateDateTravelTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(UpdateDateTravelTest.class);
	
	@Test
	public void modifyPage() throws Throwable {
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
String status =  reader.getRowTestData("Sheet1", "UpdatePageinfo").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
			// This Line of Code will INtilizt the Browser and Launch URL
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		FindBusPage obj = new FindBusPage(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		extentTest = extent.startTest("UpdatePageinfo Test ");
		String SourceLocations = reader.getRowTestData("Sheet1", "UpdatePageinfo").get("Source");
		obj.sourceLocation(SourceLocations);
		String DestinationLocations = reader.getRowTestData("Sheet1", "UpdatePageinfo").get("Destination");
		obj.destinationLocation(DestinationLocations);
		obj.clickCalender();
		obj.chooseDate();
		obj.clickSearchBtn();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		UpdateDateTravelPage page = new UpdateDateTravelPage(driver);
		page.modify();
		page.switchButton();
		page.searchBtn();
		Assert.assertTrue(driver.getTitle().contains("Search Bus Tickets"));
		
		logger.info("-----------modifyPage Scenario passed Succesfully-------------------");
	}
		else
		{
			// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		extentTest = extent.startTest("UpdatePageinfo Test ");
		throw new SkipException("modifyPage Test Case has been Skipped");
		}
	}	
}
		

	
	
	