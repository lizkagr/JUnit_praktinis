import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import static org.junit.jupiter.api.Assertions.*;


public class loginTest {

    private WebDriver driver;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }


    @Test
    void LoginTestates() {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

        WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
        cartLink.click();
        driver.quit();
    }


    @Test
    public void testFailedLoginWithWrongPassword() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("wrong_password");

        driver.findElement(By.id("login-button")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assertEquals(errorMessage.getText(), "Epic sadface: Username and password do not match any user in this service");

        driver.quit();
    }


    @Test
    void testLockedUser() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement inputUsername = driver.findElement(By.id("user-name"));
        inputUsername.sendKeys("locked_out_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
        assertTrue(errorMessage.getText().contains("Epic sadface: Sorry, this user has been locked out."));

        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(files = "src/test/resources/logins.csv", numLinesToSkip = 1)
    public void testLogin(String username, String password) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement inputUsername = driver.findElement(By.id("user-name"));
        WebElement passwordField = driver.findElement(By.id("password"));

        inputUsername.sendKeys(username);
        passwordField.sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        if (username.equals("locked_out_user")) {
            WebElement errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']"));
            assertTrue(errorMessage.getText().contains("Epic sadface: Sorry, this user has been locked out."));
        } else {
            assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
        }
    }

    @Test
    public void testConnectionTimeout() {
        assertTimeout(java.time.Duration.ofSeconds(2), () -> {
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.saucedemo.com/");
            WebElement usernameField = driver.findElement(By.id("user-name"));
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            usernameField.sendKeys("performance_glitch_user");
            driver.findElement(By.id("login-button")).click();
        });
    }

}
