import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    // Веб-драйвер, управляющий браузером
    private final WebDriver driver;

    // Находит поле ввода для имени пользователя по атрибуту name="username"
    @FindBy(name = "username")
    private WebElement username;

    // Находит поле ввода для пароля по атрибуту name="password"
    @FindBy(name = "password")
    private WebElement password;

    // Находит кнопку логина по указанному XPath
    @FindBy(xpath = "/html/body/div/form/div/button")
    private WebElement loginButton;

    // Конструктор класса, инициализирует веб-элементы через PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        // Инициализирует аннотированные элементы на странице (FindBy)
        PageFactory.initElements(driver, this);
    }

    // Метод для выполнения входа — вводит имя пользователя и пароль, затем нажимает кнопку
    public void login(String username, String password) {
        this.username.sendKeys(username); // Ввод имени пользователя
        this.password.sendKeys(password); // Ввод пароля
        loginButton.click();               // Клик по кнопке "Войти"
    }
}

