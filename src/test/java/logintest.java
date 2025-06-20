import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import io.github.bonigarcia.wdm.WebDriverManager;

public class logintest {

    private WebDriver driver;

    @Test
    void LoginTestates() {

        // Создаем новый экземпляр ChromeDriver — запускаем браузер Chrome
        WebDriver driver = new ChromeDriver();

        // Открываем страницу логина по указанному URL
        driver.get("http://localhost:8080/prisijungti");

        // Находим поле ввода для имени пользователя по имени атрибута "username"
        WebElement inputUsername = driver.findElement(By.name("username"));

        // Вводим в поле имя пользователя "standard_user"
        inputUsername.sendKeys("standard_user");

        // Находим поле ввода пароля по имени атрибута "password" и вводим пароль "secret_sauce"
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        // Находим кнопку входа по XPath и кликаем по ней, чтобы отправить форму
        driver.findElement(By.xpath("/html/body/div/form/div/button")).click();

        // Закомментированное завершение работы браузера
        // driver.quit();
    }

    @Test
    public void testFailedLoginWithWrongPassword() {

        // Создаем новый экземпляр ChromeDriver — запускаем браузер Chrome
        WebDriver driver = new ChromeDriver();

        // Открываем страницу логина по указанному URL
        driver.get("http://localhost:8080/prisijungti");

        // Находим поле ввода для имени пользователя по имени атрибута "username"
        WebElement inputUsername = driver.findElement(By.name("username"));

        // Вводим в поле имя пользователя "standard_user"
        inputUsername.sendKeys("standard_user");

        // Находим поле ввода пароля по имени атрибута "password" и вводим неверный пароль "wrong_password"
        driver.findElement(By.name("password")).sendKeys("wrong_password");

        // Находим кнопку входа по XPath и кликаем по ней, чтобы отправить форму
        driver.findElement(By.xpath("/html/body/div/form/div/button")).click();

        // Закомментированное завершение работы браузера
        // driver.quit();
    }
}

