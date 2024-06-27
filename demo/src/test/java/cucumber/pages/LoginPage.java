package cucumber.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver navegador) {
        super(navegador);
    }

    WebElement loginForm = navegador.findElement(By.id("login"));

    public void preencherId(String id, String dado){
        loginForm.findElement(By.id(id)).sendKeys(dado);
    }

    public void clicarXpath(String xpath){
        loginForm.findElement(By.xpath(xpath)).click();
    }

    public void mensagemErro(String id, String erro){
        String mensagem = navegador.findElement(By.id(id)).getText();
        assertTrue(mensagem.contains(erro));
    }
    
}
