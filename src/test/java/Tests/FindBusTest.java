package Tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.FindBusPage;


//this Class is used to check the Functionality of Find bus on Routes on site https://Redbus.com
public class FindBusTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(FindBusTest.class);

	@Test
	public void searchBuses() throws Throwable {
	
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
      String status =  reader.getRowTestData("Sheet1", "searchBuses").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
			// This Line of Code will INtilizt the Browser and Launch URL	
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		FindBusPage obj = new FindBusPage(driver);
		extentTest = extent.startTest("Testing Search Bus Funtionality ");

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		String SourceLocation = reader.getRowTestData("Sheet1", "searchBuses").get("Source");
		obj.sourceLocation(SourceLocation);
		String DestinationLocation = reader.getRowTestData("Sheet1", "searchBuses").get("Destination");
		obj.destinationLocation(DestinationLocation);
		obj.clickCalender();
		obj.chooseDate();
		obj.clickSearchBtn();
		Assert.assertTrue(driver.getTitle().contains("Search Bus Tickets"));
	
		logger.info("-----------searchBuses Scenario passed Succesfully-------------------");
	}
		else
		{
		extentTest = extent.startTest("searchBuses");
		// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		throw new SkipException("searchBuses Test Case has been Skipped");
		}
	}
}