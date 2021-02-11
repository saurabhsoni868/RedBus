package Tests;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.CancelBookedTicketPage;

//this class is used to check the Functionality of Cancel the Tickets on on site https://Redbus.com 
public class CancelBookedTicketTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(CancelBookedTicketTest.class);
	
	@Test
	public void CancelTicketFuntion() throws Throwable {
		
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
		String status =  reader.getRowTestData("Sheet1", "CancelBusTicket").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
			// This Line of Code will INtilizt the Browser and Launch URL
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));
		CancelBookedTicketPage can = new CancelBookedTicketPage(driver);
		extentTest = extent.startTest("Cancel Ticket Funtionality ");
		Thread.sleep(5000);
		can.ClickOnManageIcon();
		Thread.sleep(2000);
		can.ClickOnCancelIcon();
		Thread.sleep(2000);

		String TicketNo = reader.getRowTestData("Sheet1", "CancelBusTicket").get("TicketNO");
		can.EnterTicketNumber(TicketNo);
		Thread.sleep(2000);
		String Email_Id = reader.getRowTestData("Sheet1", "CancelBusTicket").get("Email_id");
		can.EnterEmailId(Email_Id);
		Thread.sleep(2000);
		can.ClickOnSelectPassenger();
		Thread.sleep(2000);
		can.WarningMsgIsDisplayed();// Applying Assertion Warning Message is displayed
		logger.info("-----------CancelTicket Scenario passed Succesfully-------------------");
		
		
		}
		
		else
		{
		extentTest = extent.startTest("Cancel Ticket Funtionality  ");
		// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		throw new SkipException("Cancel Ticket Funtionality  Test Case has been Skipped");

		}
		
		
		
		
	}
}