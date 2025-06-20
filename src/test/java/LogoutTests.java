import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogoutTests {

    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }


    @Test
    public void testLogout() {
        driver.get("http://localhost:8080/prisijungti");
        loginPage.login("standard_user", "secret_sauce");

        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.logout();
    }

//    @AfterEach
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}

