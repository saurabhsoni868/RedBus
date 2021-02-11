package Tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.BusOperatorsPage;


//this  class is used to Perform Bus operation on site https://Redbus.com
public class BusOperatorsTest extends BaseClass {
	public final static Logger logger = Logger.getLogger(BusOperatorsTest.class);

	@Test
	public void searchBusesWithTopOperator() throws Throwable {

		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
		String status = reader.getRowTestData("Sheet1", "searchBusesWithTopOperator").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes")) {
			
			// This Line of Code will INtilizt the Browser and Launch URL
			driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			BusOperatorsPage obj = new BusOperatorsPage(driver);
			extentTest = extent.startTest("SEARCH WITH OPERATOR");
			obj.clickOneTopOperator();
			obj.selectBusRoute();
			obj.clickCloseIcon();
			Assert.assertTrue(driver.getTitle().contains("Pune to Bangalore"));
		} 
		else 
		{
			
			extentTest = extent.startTest("SEARCH WITH OPERATOR");
			// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
			throw new SkipException("Search Buses With Top Operator, Test Case has been Skipped");
		}
		logger.info("Buses found successfully");
	}
	

	@Test
	public void findAllBusOperators() throws Throwable {

		String status = reader.getRowTestData("Sheet1", "findAllBusOperators").get("ExecutionRequired");
		if (status.toLowerCase().trim().equals("yes"))
{
			driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserType"));
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			BusOperatorsPage obj = new BusOperatorsPage(driver);
			extentTest = extent.startTest("FIND ALL BUS OPERATOR");
			obj.clickAllOperators();
			obj.switchWindow();
			Assert.assertTrue(driver.getTitle().contains("Abhimanyu"));
		} else {
			extentTest = extent.startTest("FIND ALL BUS OPERATOR");
			throw new SkipException("FIND ALL BUS OPERATOR, Test Case has been Skipped");
		}
		logger.info("Bus operators found successfully");
	}
}
