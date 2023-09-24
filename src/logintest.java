import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class logintest {
    public void dologin(WebDriver driver, String username, String password ) {
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        usernamefield.sendKeys(username);
        WebElement pwfield = driver.findElement(By.id("password"));
        pwfield.sendKeys(password);
        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();
        usernamefield.clear();
        pwfield.clear();

        String err_msg = driver.findElement(By.xpath("//*[@data-test='error']")).getText();
        System.out.println(err_msg);

        List<WebElement> productElements = driver.findElements(By.xpath("//*[@id='item_"+"_title_link']/div"));
        for (WebElement productElement : productElements) {
            String product_name = productElement.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
            System.out.println("Product Name: "+ product_name);
        }
    }


    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        logintest obj = new logintest();
        obj.dologin(driver, "standard_user", "112");
        obj.dologin(driver, "abc", "secret_sauce");
        obj.dologin(driver, "abc", "112");
        obj.dologin(driver, "standard_user", "");
        obj.dologin(driver, "", "secret_sauce");
        obj.dologin(driver, "", "");
        obj.dologin(driver, "standard_user", "secret_sauce");
    }
}
