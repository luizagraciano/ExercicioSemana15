package cucumber.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.pages.LoginPage;
import cucumber.pages.SecurePage;
import cucumber.suport.Web;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

public class StepDefinitions {

    private WebDriver navegador;
    private LoginPage loginPage;
    private SecurePage securePage;

    @Before
    public void setUp(){
        navegador = Web.criarChrome();
    }

    //Scenario Login com sucesso
    @Given("Usuario esteja na pagina de Login")
    public void usuario_esteja_na_pagina_de_login() {
        this.loginPage = new LoginPage(navegador);
    }

    @When("Usuario preencher campo Username")
    public void usuario_preencher_campo_username() {
        loginPage.preencherId("username", "tomsmith");
    }

    @When("Usuario preencher campo Password")
    public void usuario_preencher_campo_password() {
        loginPage.preencherId("password", "SuperSecretPassword!");
    }

    @When("Usuario clicar no botão Login")
    public void usuario_clicar_no_botão_login() {
        loginPage.clicarXpath("/html/body/div[2]/div/div/form/button/i");
    }

    @Then("Usuario deve ser redirecionado para pagina de Secure Area")
    public void usuario_deve_ser_redirecionado_para_pagina_de_secure_area() {
        this.securePage = new SecurePage(navegador);
        securePage.paginaCerta("https://the-internet.herokuapp.com/secure");
        securePage.mensagemSucesso("flash", "You logged into a secure area!");
    }

    //Scenario Login com senha em branco
    @When("Usuario nao preencher campo Password")
    public void usuario_nao_preencher_campo_password() {
        loginPage.preencherId("password", "");
    }

    @Then("Usuario deve receber mensagem de senha invalida")
    public void usuario_deve_receber_mensagem_de_senha_invalida() {
        loginPage.mensagemErro("flash", "Your password is invalid!");
    }

    //Scenario Login com usuario em branco
    @When("Usuario nao preencher campo Username")
    public void usuario_nao_preencher_campo_username() {
        loginPage.preencherId("username", "");
    }

    @Then("Usuario deve receber mensagem de usuario invalido")
    public void usuario_deve_receber_mensagem_de_usuario_invalido() {
        loginPage.mensagemErro("flash", "Your username is invalid!");
    }

    //Scenario Login com senha incorreta
    @When("Usuario preencher campo Password com senha incorreta")
    public void usuario_preencher_campo_password_com_senha_incorreta() {
        loginPage.preencherId("password", "123456789");
    }

    //Scenario Login com usuario incorreto
    @When("Usuario preencher campo Username com usuario incorreto")
    public void usuario_preencher_campo_username_com_usuario_incorreto() {
        loginPage.preencherId("username", "usuarioteste");
    }    

    @After
    public void tearDown(){
        navegador.manage().timeouts()
        .implicitlyWait(Duration.ofSeconds(5));
        navegador.quit();
    }

}
