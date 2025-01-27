import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ActivityProject2 {
    public static void main(String[] args) {
        
        WebDriver driver = new FirefoxDriver();

        
        driver.get("http://alchemy.hguy.co/orangehrm");

        
        WebElement headerImage = driver.findElement(By.xpath("//img[@src='/orangehrm/symfony/web/webres_5d69118beeec64.10301452/themes/default/images/login/logo.png']"));

        
        String relativeImageURL = headerImage.getDomAttribute("src");

       
        String baseURL = "http://alchemy.hguy.co";
        String fullImageURL = relativeImageURL.startsWith("http") ? relativeImageURL : baseURL + relativeImageURL;

        
        System.out.println("Header image URL is: " + fullImageURL);

        
        driver.quit();
    }
}
