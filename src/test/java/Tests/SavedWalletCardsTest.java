package Tests;

import org.apache.log4j.Logger;
import org.testng.SkipException;
import org.testng.annotations.Test;

import CommonUtils.BaseClass;
import Pages.MyProfileWindowPage;
import Pages.LoginInPage;
import Pages.SavedWalletCardsPages;

//this Class is used to Verify the SavedWallet Functionality page on on site https://Redbus.com
public class SavedWalletCardsTest extends BaseClass{
	
	public final static Logger logger = Logger.getLogger(SavedWalletCardsTest.class);
	
	@Test
	public void SavedCardInWallet() throws Throwable{
String status =  reader.getRowTestData("Sheet1", "SavedWalletCards").get("ExecutionRequired");
		
		if (status.toLowerCase().trim().equals("yes"))
		{
		driverInitialize(prop.getProperty("Browser") , prop.getProperty("BrowserMode"));
		
		LoginInPage obj1 = new LoginInPage(driver);
		extentTest = extent.startTest("Displaying saved cards in wallet ");
		
		String user_id = reader.getRowTestData("Sheet1", "ValidSignIn").get("Username");
		String password = reader.getRowTestData("Sheet1", "ValidSignIn").get("Password");
		
		obj1.id();
		obj1.signIn();
		obj1.googlebtn();
		obj1.SwitchWindow(user_id ,password );
		MyProfileWindowPage win = new MyProfileWindowPage(driver);
		win.ClickOnProfileInfo();
		SavedWalletCardsPages wallet = new SavedWalletCardsPages(driver);
		wallet.ClickOnWalletCardBtN();
		wallet.HelpBtNIsDisplayed();//Applying assertion that help button is displayed
		
		logger.info("-----------SavedCardInWallet Scenario passed Succesfully-------------------");
	}
		else
		{
			extentTest = extent.startTest("SavedCardInWallet");
			throw new SkipException("SavedCardInWallet Test Case has been Skipped");
		}
}
}
		

	
	
		