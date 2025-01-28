import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class Activity7Project {
    public static void main(String[] args) {
        
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

       
        driver.get("http://alchemy.hguy.co/orangehrm");

        
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

      
        wait.until(ExpectedConditions.elementToBeClickable(By.id("menu_pim_viewPimModule"))).click();

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul[@id='sidenav']/li[3]/a[contains(text(),'Qualifications')]"))).click();

    
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnAdd"))).click();

     
        WebElement qualificationType = driver.findElement(By.id("addQualification_qualificationType"));
        qualificationType.sendKeys("Bachelor's Degree"); // Example: Add qualification type

        WebElement schoolName = driver.findElement(By.id("addQualification_schoolName"));
        schoolName.sendKeys("University of XYZ");

        WebElement yearOfCompletion = driver.findElement(By.id("addQualification_yearOfCompletion"));
        yearOfCompletion.sendKeys("2015");

        WebElement comments = driver.findElement(By.id("addQualification_comments"));
        comments.sendKeys("Completed with distinction");

      
        driver.findElement(By.id("btnSave")).click();

       
        WebElement qualificationConfirmation = driver.findElement(By.xpath("//div[contains(text(),'Qualification added successfully')]"));
        if (qualificationConfirmation.isDisplayed()) {
            System.out.println("Qualification added successfully.");
        } else {
            System.out.println("Failed to add qualification.");
        }

      
        driver.quit();
    }
}
