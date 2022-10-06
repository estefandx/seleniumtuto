package com.seleniumtuto.stepdefinitions;

import com.seleniumtuto.functions.SelemiunFunctions;
import com.seleniumtuto.page.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class StepDefinitions {

    private static final Properties pro = new Properties();
    WebDriver driver;
    Logger log = Logger.getLogger(StepDefinitions.class);

    HomePage homePage = new HomePage(Hooks.driver);
    ContactUsPage contactUsPage = new ContactUsPage(Hooks.driver);
    AuthenticationPage authenticationPage = new AuthenticationPage(Hooks.driver);
    PersonalInformationPage personalInformationPage = new PersonalInformationPage(Hooks.driver);


    public StepDefinitions() {
        this.driver = Hooks.driver;
    }


    @Given("El cliente se encuentra en la pantalla de logeo")
    public  void elClienteSeencuentraEnLaPantallaDelogeo() throws IOException {
        System.out.println("antes de cargar la pagina");
        pro.load(new FileReader("src/test/resources/test.properties"));
        String url = pro.getProperty("MainAppuUrlBase");
        log.info(("navegar a:" + url));
        driver.get(url);

    }


    @Given("El ciente intresa al sitio (.*)$")
    public void elCienteIntresaAlSitioHttpAutomationpracticeComIndexPhp(String url) {
        driver.get(url);
        homePage.pageStatus();
    }

    @Then("Cargo la información del DOM (.*)$")
    public void cargoLaInformacionDelDOMTienda_registroJson(String fileName) throws Exception {
        SelemiunFunctions.FileName = fileName;
        SelemiunFunctions.readJson();
        log.info("Inicializar el archivo" +  fileName);
        JSONObject entity = SelemiunFunctions.readEntity("Email");
        System.out.println(entity);
        homePage.fillFormLogin("estefandx","holaaa");
        System.out.println(entity);

    }

    @When("selecciona contactar a la tienda y envia un mensaje a la tienda")
    public void seleccionaContactarALaTiendaYEnviaUnMensajeALaTienda() throws InterruptedException {
        homePage.contactUs();
        contactUsPage.selectSubjectHeading("Webmaster");
        
    }

    @Then("ve el mesaje de confirmacion")
    public void veElMesajeDeConfirmacion() {
    }

    @When("el usuario registra su correo y ve el formulario de registro")
    public void elUsuarioRegistraSuCorreoYVeElFormularioDeRegistro() throws InterruptedException {
        homePage.singUp();
        authenticationPage.createAccount("estefandx@hotmail.com");
        
    }

    @And("diligencia el formulario de registro")
    public void diligenciaElFormularioDeRegistro() throws InterruptedException {
        personalInformationPage.selectGender("Mrs");
        personalInformationPage.registerJs();

    }
}
