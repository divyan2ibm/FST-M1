import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Activity9Project {
    public static void main(String[] args) {
        
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

       
        driver.get("http://alchemy.hguy.co/orangehrm");

        
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

      
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewMyDetails"))).click();

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Emergency Contacts')]"))).click();

        
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='emgcontact_list']//tbody/tr"));

        System.out.println("Emergency Contacts Information:");
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            for (WebElement cell : cells) {
                System.out.print(cell.getText() + "\t");
            }
            System.out.println();
        }

       
        driver.quit();
    }
}
