package Tests;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.CancelBookedTicketPage;
import Pages.KnowTicketDetailsPage;
import Pages.ShowMyTicketPage;


//this class is used to verify the Functionality of Show my Tickets Page on on site https://Redbus.com
public class ShowMyTicketTest extends BaseClass {
	
	public final static Logger logger = Logger.getLogger(ShowMyTicketTest.class);

	@Test
	public void ShowMyTicket() throws Throwable {
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
String status =  reader.getRowTestData("Sheet1", "ShowMyTicket").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
			// This Line of Code will INtilizt the Browser and Launch URL
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));
		
		CancelBookedTicketPage can = new CancelBookedTicketPage(driver);
		extentTest = extent.startTest("Cancel Ticket Funtionality ");
		can.ClickOnManageIcon();
		ShowMyTicketPage show = new ShowMyTicketPage(driver);
		show.ShowMyTicketBtn();
		String NoTicket = reader.getRowTestData("Sheet1", "ShowMyTicket").get("TicketNO");
		show.EnterTicketNo(NoTicket);
		String id_Email = reader.getRowTestData("Sheet1", "ShowMyTicket").get("Email_id");
		show.EnterEmailId(id_Email);
		show.ClickOnSearchBtn();
		KnowTicketDetailsPage obj1 = new KnowTicketDetailsPage(driver);
		obj1.RedBusLogoIsPresent();// Applying Assertion that redbus logo is present
		
		logger.info("-----------Show_My_Ticket_Test Scenario passed Succesfully-------------------");
	}
		else
		{
		extentTest = extent.startTest("ShowMyTicket");
		// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
		throw new SkipException("ShowMyTicket Test Case has been Skipped");
		}
}
}

		


	
		