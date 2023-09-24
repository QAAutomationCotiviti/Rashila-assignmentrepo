import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class workwithchrome {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
//        WebElement search = driver.findElement(By.id("APjFqb"));
        WebElement search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        search.sendKeys("Test");
        search.sendKeys(Keys.ENTER);

        Actions action = new Actions(driver);

        action.moveByOffset(1, 2).click().build().perform();
    }
}
