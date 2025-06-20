import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class RegistrationTests {

    private WebDriver driver;
    private RegistrationPage registrationPage;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("http://localhost:8080/registruoti");
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void testSuccessfulRegistration() {
        registrationPage.register("newUser1234", "pass123", "pass123");

    }

    @Test
    public void testRegistrationFailsWithMismatchedPasswords() {
        registrationPage.register("testuser", "password123", "differentPassword");

    }

//    @AfterEach
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}


