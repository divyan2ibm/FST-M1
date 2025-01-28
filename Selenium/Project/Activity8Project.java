import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Activity8Project {
    public static void main(String[] args) {
       
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        driver.get("http://alchemy.hguy.co/orangehrm");

       
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

       
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_leave_applyLeave"))).click();

        
        WebElement leaveType = driver.findElement(By.id("applyleave_txtLeaveType"));
        leaveType.click();
        leaveType.findElement(By.xpath("//option[contains(text(),'Sick Leave')]")).click();

       
        driver.findElement(By.id("applyleave_txtFromDate")).sendKeys("2025-02-10");
        driver.findElement(By.id("applyleave_txtToDate")).sendKeys("2025-02-12");

     
        driver.findElement(By.id("applyBtn")).click();

       
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_leave_viewMyLeaveList"))).click();

       
        WebElement leaveStatus = driver.findElement(By.xpath("//table[@id='leaveListTable']//td[contains(text(),'Sick Leave')]"));
        if (leaveStatus.isDisplayed()) {
            System.out.println("Leave applied successfully.");
        } else {
            System.out.println("Leave application failed.");
        }

      
        driver.quit();
    }
}
