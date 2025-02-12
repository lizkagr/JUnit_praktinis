import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

class LoginTests {

    private WebDriver driver;
    private LoginPage loginPage;
    private com.saucedemo.pages.InventoryPage inventoryPage;

    @BeforeEach
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(5));
        loginPage = new LoginPage(driver);  // Initialize LoginPage object
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void testLoginAndShoppingCart() {
        driver.get("https://www.saucedemo.com/");

        // Perform login using Page Object Model
        inventoryPage = loginPage.login("standard_user", "secret_sauce");

        // Check that we are on the inventory page
        assertEquals("https://www.saucedemo.com/inventory.html", inventoryPage.getCurrentUrl());

        // Check if the shopping cart link is visible
        assertTrue(inventoryPage.isCartLinkVisible());
    }

    @Test
    void testInvalidLogin() {
        driver.get("https://www.saucedemo.com/");

        // Perform login with invalid credentials
        loginPage.login("standard_user", "wrong_password");

        // Check that the error message is displayed
        String expectedErrorMessage = "Epic sadface: Username and password do not match any user in this service";
        assertEquals(expectedErrorMessage, loginPage.getErrorMessage());
    }

    @Test
    void testLockedOutUser() {
        driver.get("https://www.saucedemo.com/");

        // Perform login with locked-out user
        loginPage.login("locked_out_user", "secret_sauce");

        // Check that the error message contains the appropriate text
        String expectedErrorMessage = "Epic sadface: Sorry, this user has been locked out";
        assertTrue(loginPage.getErrorMessage().contains(expectedErrorMessage));
    }
}

