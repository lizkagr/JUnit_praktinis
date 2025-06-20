import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    @FindBy(name = "username")
    private WebElement usernameInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(name = "passwordConfirm")
    private WebElement confirmPasswordInput;

    @FindBy(xpath = "//*[@id=\"userForm\"]/button")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void register(String username, String passwordConfirm, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        confirmPasswordInput.sendKeys(passwordConfirm);
        registerButton.click();
    }
}


