package cucumber.pages;

import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage{

    public SecurePage(WebDriver navegador) {
        super(navegador);
    }

    public boolean paginaCerta(String urlEsperada){
        return navegador.getCurrentUrl().equals(urlEsperada);
    }
    
}
