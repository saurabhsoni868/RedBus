package Tests;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.BusPoolPage;

//this class is used to check the functionality of Pool bus tab on site https://Redbus.com
public class BusPoolTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(BusPoolTest.class);
	
	@Test
	public void carPool() throws Throwable {
		
	// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
		
   String status =  reader.getRowTestData("Sheet1", "BusPool").get("ExecutionRequired");
   System.out.println(status);
		
   
		if (status.toLowerCase().trim().equals("yes"))
		{
			// This Line of Code will INtilizt the Browser and Launch URL
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));
		BusPoolPage obj = new BusPoolPage(driver);
		extentTest = extent.startTest("rPool Test case ");
		obj.findRide();
		obj.offerRide();
		Assert.assertTrue(driver
				.findElement(By.xpath("//*[@id='howItWorks']/div/div/div[2]/div[5]/div/div/div[1]/ul/li[1]/span[2]"))
				.isDisplayed());
		
		logger.info("-----------carPool Scenario passed Succesfully-------------------");
	}
		else
		{
		extentTest = extent.startTest("Bus-Pool Test");
		// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		throw new SkipException("carPool Test Case has been Skipped");
		}
	
}}
		
	