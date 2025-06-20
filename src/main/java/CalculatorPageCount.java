import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculatorPageCount {
    private WebDriver driver;

    // Локаторы полей ввода и кнопки (замени под себя)
    private final By inputField1 = By.id("sk1");
    private final By inputField2 = By.id("sk2");
    private final By calculateButton = By.xpath("//*[@id=\"number\"]/input[3]");

    public CalculatorPageCount(WebDriver driver) {
        this.driver = driver;
    }

    public void enterFirstNumber(String number) {
        driver.findElement(inputField1).clear();
        driver.findElement(inputField1).sendKeys(number);
    }

    public void enterSecondNumber(String number) {
        driver.findElement(inputField2).clear();
        driver.findElement(inputField2).sendKeys(number);
    }

    public void clickCalculate() {
        driver.findElement(calculateButton).click();
    }

    // Метод, чтобы ввести два числа и нажать кнопку
    public void calculate(String num1, String num2) {
        enterFirstNumber(num1);
        enterSecondNumber(num2);
        clickCalculate();
    }
}



