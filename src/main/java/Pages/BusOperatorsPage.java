package Pages;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

 // this  class is used to Perform Bus operation on site https://Redbus.com

public class BusOperatorsPage {

 

    WebDriver driver;

 

    public BusOperatorsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

 

    @FindBy(how = How.XPATH, using = "//a[text()='Rajdhani Express']")
    public WebElement top_operator;

 

    @FindBy(how = How.XPATH, using = "//a[text()='Pune to Bangalore Bus']")
    public WebElement bus_route;

 

    @FindBy(xpath = "//div[@class='close']")
    public WebElement icon_close;

 

    @FindBy(how = How.CSS, using = "#rh_footer > div:nth-child(2) > div > div > div > a")
    public WebElement all_operatorbtn;

 

    @FindBy(how = How.XPATH, using = "//*[@id='root']/div/article[2]/div[1]/ul/li[38]/a")
    public WebElement selected_operator;

 
// this method will click on Top Operator
    public void clickOneTopOperator() {
        top_operator.click();
    }

 

    public void selectBusRoute() throws InterruptedException {
        bus_route.click();
        Thread.sleep(4000);
    }

 
// this method will clock the popup 
    public void clickCloseIcon() {
        icon_close.click();
    }

 
// this method will click on all operations 
    public void clickAllOperators() throws InterruptedException {
        Thread.sleep(1000);
        all_operatorbtn.click();
    }

 
// Method is used to switch from  main Window to Another window
    
    public void switchWindow() {
        String parentwindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        int count = allWindows.size();
        for (String child : allWindows) {
            if (!parentwindow.equalsIgnoreCase(child)) {
                driver.switchTo().window(child);
                WebDriverWait wait = new WebDriverWait(driver, 30);
                WebElement element = wait.until(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath("//*[@id='root']/div/article[1]/div[3]/h2")));
                selected_operator.click();
            }
        }
    }

 

}
 
