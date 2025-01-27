import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActivityProject3 {
    public static void main(String[] args) {
        
        WebDriver driver = new FirefoxDriver();

        
        driver.get("http://alchemy.hguy.co/orangehrm");

        
        driver.findElement(By.xpath("//*[@id='txtUsername']")).sendKeys("orange");

       
        driver.findElement(By.xpath("//*[@id='txtPassword']")).sendKeys("orange123");

       
        driver.findElement(By.xpath("//*[@id='btnLogin']")).click();

       
        String welcomeText = driver.findElement(By.id("welcome")).getText();
        if (welcomeText.contains("Welcome")) {
            System.out.println("Login successful! Homepage loaded.");
        } else {
            System.out.println("Login failed! Homepage did not load.");
        }

       
        driver.quit();
    }
}
