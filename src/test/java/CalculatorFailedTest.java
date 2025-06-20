import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorFailedTest {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("http://localhost:8080/prisijungti");

            // Создаем объект страницы логина
            LoginPage loginPage = new LoginPage(driver);

            // Выполняем логин
            loginPage.login("standard_user", "secret_sauce");

            // Ждем, пока появится элемент калькулятора после успешного логина
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("sk1")));

            // Создаем объект страницы калькулятора
            CalculatorPageCount calculatorPage = new CalculatorPageCount(driver);

            // Вводим числа и считаем
            calculatorPage.calculate("09999999999", "078978978978");

            // Можно добавить проверку результата здесь

        } finally {
            driver.quit();
        }
    }
}
