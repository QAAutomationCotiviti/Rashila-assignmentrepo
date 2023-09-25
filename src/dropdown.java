import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.sql.SQLOutput;
import java.util.List;

public class dropdown {
    public void loginsucess(WebDriver driver) {
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        usernamefield.sendKeys("standard_user");
        WebElement pwfield = driver.findElement(By.id("password"));
        pwfield.sendKeys("secret_sauce");
        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();
    }

    public  static void selectsort(WebDriver driver, String text) {
        Select select = new Select(driver.findElement(By.className("product_sort_container")));
        select.selectByVisibleText(text);
    }

    public static void productdetail(WebDriver driver) {
        List<WebElement> productElements = driver.findElements(By.className("inventory_item"));
        System.out.println("List of Products:");

        for (WebElement productElement : productElements) {
            WebElement productNameElement = productElement.findElement(By.className("inventory_item_name"));
            String productName = productNameElement.getText();

            WebElement productdesc = productElement.findElement(By.className("inventory_item_desc"));
            String description = productdesc.getText();

            WebElement productprice = productElement.findElement(By.className("inventory_item_price"));
            String price = productprice.getText();

            System.out.println(productName);
            System.out.println(description);
            System.out.println(price);
        }

    }

    public static void addtocart(WebDriver driver) {
        WebElement cartbtn = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        cartbtn.click();

        WebElement removebtn = driver.findElement(By.id("remove-sauce-labs-backpack"));
        String remove= removebtn.getText();

        if (remove.contains("Remove")) {
            System.out.println("item added to cart");
        }
        else {
            System.out.println("item not added to cart");
        }
    }
    public static void removecart(WebDriver driver){
        WebElement carticon = driver.findElement(By.id("shopping_cart_container"));
        carticon.click();

        WebElement removebtn = driver.findElement(By.id("remove-sauce-labs-backpack"));
        removebtn.click();
        List<WebElement> cartList = driver.findElements(By.className("cart-item"));

        if(cartList.isEmpty()) {
            System.out.println("item removed from cart");
        }
        else {
            System.out.println("item still in cart");
        }
    }
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        dropdown obj = new dropdown();
        obj.loginsucess(driver);

        selectsort(driver, "Price (low to high)");
        selectsort(driver, "Price (high to low)");
        selectsort(driver, "Name (A to Z)");
        selectsort(driver, "Name (Z to A)");

        productdetail(driver);

        addtocart(driver);
        removecart(driver);

    }
}
