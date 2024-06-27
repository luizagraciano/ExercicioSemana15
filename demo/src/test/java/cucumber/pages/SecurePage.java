package cucumber.pages;

import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage{

    public SecurePage(WebDriver navegador) {
        super(navegador);
    }

    public boolean paginaCerta(String urlEsperada){
        return navegador.getCurrentUrl().equals(urlEsperada);
    }

    public void mensagemSucesso(String id, String sucesso){
        String mensagem = navegador.findElement(By.id(id)).getText();
        assertTrue(mensagem.contains(sucesso));
    }
    
}
