import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActivityProject1 {
    public static void main(String[] args) {
       
        WebDriver driver = new FirefoxDriver();

        
        driver.get("http://alchemy.hguy.co/orangehrm");
        
        String pageTitle = driver.getTitle();
        
        if (pageTitle.equals("OrangeHRM")) {
            System.out.println("Title matches 'OrangeHRM'. Test Passed.");
        } else {
            System.out.println("Title does not match. Test Failed.");
        }
       
        driver.quit();
    }
}