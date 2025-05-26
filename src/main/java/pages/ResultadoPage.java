package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultadoPage {
    private WebDriver driver;

    private By tituloResultado = By.cssSelector(".s-suggestion");
    
    public ResultadoPage(WebDriver driver) {
        this.driver = driver;
    }

    public String obterTituloResultado() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(tituloResultado));
        return elemento.getText();
    }
}
