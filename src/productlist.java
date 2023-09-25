import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class productlist {

    public void loginsucess(WebDriver driver) {
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        usernamefield.sendKeys("standard_user");
        WebElement pwfield = driver.findElement(By.id("password"));
        pwfield.sendKeys("secret_sauce");
        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();
    }

    public static void listproduct(WebDriver driver){
        List<WebElement> productElements = driver.findElements(By.xpath("//*[@class='inventory_item_name']"));
        for (WebElement productElement : productElements) {
            String product_name = productElement.getText();
            System.out.println("Product Name: "+ product_name);
        }
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        productlist obj = new productlist();
        obj.loginsucess(driver);
        listproduct(driver);


    }
}
