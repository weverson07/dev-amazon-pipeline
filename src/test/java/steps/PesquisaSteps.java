package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.*;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.ResultadoPage;
import utils.DriverFactory;

public class PesquisaSteps {

    private WebDriver driver;
    private HomePage homePage;
    private ResultadoPage resultadoPage;

    @Before
    public void setup() {
        driver = DriverFactory.getDriver();
        homePage = new HomePage(driver);
        resultadoPage = new ResultadoPage(driver);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver();
    }

    @Dado("que eu estou na página inicial")
    public void que_eu_estou_na_página_inicial() {
        driver.get("https://www.amazon.com.br/");
    }

    @Quando("eu pesquiso por {string}")
    public void eu_pesquiso_por(String produto) {
        homePage.fecharModalSePresente();
        homePage.digitarPesquisa(produto);
    }

    @Então("eu vejo resultados relacionados ao clicar")
    public void eu_vejo_resultados_relacionados_a() {
        String titulo = resultadoPage.obterTituloResultado();
        System.out.println("Título encontrado: " + titulo);
    }
}
