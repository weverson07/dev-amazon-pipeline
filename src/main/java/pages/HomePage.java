package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    private WebDriver driver;
    private By campoPesquisa = By.id("twotabsearchtextbox");
    private By botaoBuscar = By.id("nav-search-submit-button");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void fecharModalSePresente() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
            WebElement btn = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-evg-dismissal].close")));

            if (btn.isDisplayed() && btn.isEnabled()) {
                btn.click();
            }
        } catch (TimeoutException e) {
           e.printStackTrace();
        }
    }

    public void digitarPesquisa(String texto) {
        driver.findElement(campoPesquisa).sendKeys(texto);
    }

    public void clicarBuscar() {
        try{
        WebElement searchButton = driver.findElement(botaoBuscar);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchButton);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchButton));

        searchButton.click();
        }catch(TimeoutException e){
            e.printStackTrace();
        }
    }
}
