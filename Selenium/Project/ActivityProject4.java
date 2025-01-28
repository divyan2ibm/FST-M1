import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;


public class ActivityProject4 {
    public static void main(String[] args) {
       
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

       
        driver.get("http://alchemy.hguy.co/orangehrm");

        
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu_pim_viewPimModule']/b"))).click();

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[3]/div[2]/div/form/div[1]/input[1]"))).click();


       
        driver.findElement(By.id("firstName")).sendKeys("Divya");
        driver.findElement(By.id("lastName")).sendKeys("N");

       
        driver.findElement(By.id("btnSave")).click();

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu_pim_viewEmployeeList']"))).click();
        WebElement searchField = driver.findElement(By.xpath("//*[@id='empsearch_employee_name_empName']"));
        searchField.sendKeys("Divya N");
        driver.findElement(By.xpath("//*[@id='searchBtn']")).click();

        driver.quit();
    }
}
