import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ActivityProject6 {
    public static void main(String[] args) {
       
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        
        driver.get("http://alchemy.hguy.co/orangehrm");

      
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

       
        WebElement directoryMenuItem = driver.findElement(By.xpath("//b[contains(text(),'Directory')]"));

        
        wait.until(ExpectedConditions.visibilityOf(directoryMenuItem));
        wait.until(ExpectedConditions.elementToBeClickable(directoryMenuItem));

        
        if (directoryMenuItem.isDisplayed() && directoryMenuItem.isEnabled()) {
            directoryMenuItem.click();
        }

        
        WebElement heading = driver.findElement(By.tagName("h1"));
        if (heading.getText().equals("Search Directory")) {
            System.out.println("Heading verified: " + heading.getText());
        } else {
            System.out.println("Heading mismatch: " + heading.getText());
        }

        
        driver.quit();
    }
}
