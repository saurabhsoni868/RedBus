package Tests;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.LoginInPage;
import Pages.SavedWalletCardsPages;
import Pages.WalletMoneyPage;


//this class is used to Verify the Functionality of WalletMoney Page on on site https://Redbus.com
public class WalletMoneyTest extends BaseClass {

	public final static Logger logger = Logger.getLogger(WalletMoneyTest.class);

	@Test
	public void WalletBalanceCheck() throws Throwable {
		// this Line will get data from XL sheet about to Run the Test Case Or Not from Test Execution Column
String status =  reader.getRowTestData("Sheet1", "WalletBalance").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
			// This Line of Code will INtilizt the Browser and Launch URL
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));

		LoginInPage obj2 = new LoginInPage(driver);
		WalletMoneyPage obj = new WalletMoneyPage(driver);
		extentTest = extent.startTest(" Wallet Money Checking Funtionality");

		
		String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
		String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
		
		obj2.id();
		obj2.signIn();
		obj2.googlebtn();
		obj2.SwitchWindow(user_id ,password );
		obj.ClickOnProfileBtn();
		obj.ClickOnWalletBtN();
		SavedWalletCardsPages obj1 = new SavedWalletCardsPages(driver);
		obj1.HelpBtNIsDisplayed();//Applying Assertion 
		
		logger.info("-----------SavedCardInWallet Scenario passed Succesfully-------------------");
	}
		else
		{
			extentTest = extent.startTest("WalletBalanceCheck");
			// This Line of Code will Skip the Test Case if  The  Test Execution Is "No" Given  in XL-sheet Test Execution Column
			throw new SkipException("WalletBalanceCheck Test Case has been Skipped");
		}
}
}






	