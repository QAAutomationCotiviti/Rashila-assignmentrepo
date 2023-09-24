import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestFinal {
    public void successfulLoginTest(WebDriver driver, String username, String password){
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        WebElement pwfield = driver.findElement(By.id("password"));

        usernamefield.sendKeys(username);
        pwfield.sendKeys(password);

        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();

        System.out.println("login successful");
        usernamefield.clear();
        pwfield.clear();

    }
    public void failLoginTest(WebDriver driver, String username, String password){
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        WebElement pwfield = driver.findElement(By.id("password"));

        usernamefield.sendKeys(username);
        pwfield.sendKeys(password);

        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();

        System.out.println("login unsuccessful");
        usernamefield.clear();
        pwfield.clear();

    }

    public void emptyFieldTest(WebDriver driver, String username, String password){
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        WebElement pwfield = driver.findElement(By.id("password"));

        usernamefield.sendKeys(username);
        pwfield.sendKeys(password);

        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();

        System.out.println("Cant login, fields must not be empty");
        usernamefield.clear();
        pwfield.clear();

    }
    public void lockedUserTest(WebDriver driver){
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        WebElement pwfield = driver.findElement(By.id("password"));

        usernamefield.sendKeys("locked_out_user");
        pwfield.sendKeys("secret_sauce");

        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();

        System.out.println("This user is locked out");

    }

    public void problemUserTest(WebDriver driver) {
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        WebElement pwfield = driver.findElement(By.id("password"));

        usernamefield.sendKeys("problem_user");
        pwfield.sendKeys("secret_sauce");

        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();

        System.out.println("This user have problem displaying right product images");
        usernamefield.clear();
        pwfield.clear();

    }

    public void glitchUserTest(WebDriver driver){
        WebElement usernamefield = driver.findElement(By.id("user-name"));
        WebElement pwfield = driver.findElement(By.id("password"));

        usernamefield.sendKeys("performance_glitch_user");
        pwfield.sendKeys("secret_sauce");

        WebElement loginbtn = driver.findElement(By.id("login-button"));
        loginbtn.click();

        System.out.println("This user have glitch issue while logging in");
        usernamefield.clear();
        pwfield.clear();

    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        LoginTestFinal obj = new LoginTestFinal();

        obj.failLoginTest(driver, "abc", "secret_sauce");
        obj.emptyFieldTest(driver, "standard_user", "");
        obj.lockedUserTest(driver);
        obj.problemUserTest(driver);
        obj.glitchUserTest(driver);
        obj.successfulLoginTest(driver, "standard_user", "secret_sauce");


    }
}
