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

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//b[text()='My Info']"))).click();

       
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Qualifications']"))).click();

        
        wait.until(ExpectedConditions.elementToBeClickable(By.id("addWorkExperience"))).click();

        
        WebElement employer = driver.findElement(By.id("experience_employer"));
        employer.sendKeys("OpenAI Inc.");

        WebElement jobTitle = driver.findElement(By.id("experience_jobtitle"));
        jobTitle.sendKeys("AI Specialist");

        WebElement fromDate = driver.findElement(By.id("experience_from_date"));
        fromDate.clear();
        fromDate.sendKeys("2020-01-01");

        WebElement toDate = driver.findElement(By.id("experience_to_date"));
        toDate.clear();
        toDate.sendKeys("2023-01-01");

        WebElement comments = driver.findElement(By.id("experience_comments"));
        comments.sendKeys("Worked on developing advanced AI systems.");

       
        driver.findElement(By.id("btnWorkExpSave")).click();

       
        driver.quit();
    }
}
