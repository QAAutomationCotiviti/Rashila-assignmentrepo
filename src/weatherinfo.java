import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class weatherinfo {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();

        WebElement search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        search.sendKeys("Weather Today");
        search.sendKeys(Keys.ENTER);

        WebElement translate = driver.findElement(By.xpath("//*[text()='Change to English']"));
        translate.click();

        WebElement statusElement = driver.findElement(By.id("wob_dcp"));
        String status = statusElement.getText();

        WebElement temperatureElement = driver.findElement(By.id("wob_tm"));
        String temperature = temperatureElement.getText();

        WebElement unitElement =driver.findElement(By.xpath("//span[@aria-label='°Celsius']"));
        String unit = unitElement.getText();

        WebElement dayElement = driver.findElement(By.id("wob_dts"));
        String day = dayElement.getText();

        System.out.println("Weather Status:" + status);
        System.out.println("Temperature:" + temperature +unit);
        System.out.println("Day:" + day);

    }
}
