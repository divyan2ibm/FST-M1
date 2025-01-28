import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class ActivityProject5 {
    public static void main(String[] args) {
       
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

      
        driver.get("http://alchemy.hguy.co/orangehrm");

        
        driver.findElement(By.id("txtUsername")).sendKeys("orange");
        driver.findElement(By.id("txtPassword")).sendKeys("orangepassword123");
        driver.findElement(By.id("btnLogin")).click();

        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='menu_pim_viewMyDetails']"))).click();

       
        wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSave"))).click();

       
        WebElement firstName = driver.findElement(By.id("personal_txtEmpFirstName"));
        WebElement lastName = driver.findElement(By.id("personal_txtEmpLastName"));
        WebElement gender = driver.findElement(By.id("personal_optGender_1")); // Assuming '1' for male, '2' for female
        WebElement nationality = driver.findElement(By.id("personal_cmbNation"));
        WebElement dob = driver.findElement(By.id("personal_DOB"));

        
        firstName.clear();
        firstName.sendKeys("Divya");
        lastName.clear();
        lastName.sendKeys("N");

       
        if (!gender.isSelected()) {
            gender.click();
        }

        
        WebElement nationalityOption = nationality.findElement(By.xpath("//option[contains(text(),'Indian')]"));
        nationalityOption.click();

      
        dob.clear();
        dob.sendKeys("1990-01-01");

       
        driver.findElement(By.id("btnSave")).click();

       
        driver.quit();
    }
}
