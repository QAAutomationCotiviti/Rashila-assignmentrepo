import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class weatherhomework {

    public void displayweather (WebDriver driver, String query){

        WebElement search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        search.sendKeys(query);
        search.sendKeys(Keys.ENTER);
        search = driver.findElement(By.xpath("//*[@id='APjFqb']"));
        search.clear();

        WebElement statusElement = driver.findElement(By.id("wob_dcp"));
        WebElement temperatureElement = driver.findElement(By.id("wob_tm"));
        WebElement unitElement =driver.findElement(By.xpath("//span[@aria-label='°Celsius']"));
        WebElement dayElement = driver.findElement(By.id("wob_dts"));
        WebElement locElement = driver.findElement(By.xpath("//span[@class='BBwThe']"));


        System.out.println(" Weather");
        System.out.println("Location:" + locElement.getText());
        System.out.println("Weather Status:" + statusElement.getText());
        System.out.println("Temperature:" + temperatureElement.getText() +unitElement.getText());
        System.out.println("Day:" + dayElement.getText());


    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();


        weatherhomework obj = new weatherhomework();
        obj.displayweather(driver, "today's weather");
        obj.displayweather(driver, "tomorrow's weather");

        WebElement translate = driver.findElement(By.xpath("//*[text()='Change to English']"));
        translate.click();




    }
}
