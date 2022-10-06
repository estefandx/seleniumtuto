package com.seleniumtuto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthenticationPage  extends  GeneralPage{

    public AuthenticationPage(WebDriver tdriver) {
        super(tdriver);
    }

    @FindBy(id = "email_create")
    WebElement emailCreateAccount;

    @FindBy(id = "email")
    WebElement email;

    @FindBy(id = "SubmitCreate")
    WebElement btnCreateAccount;

    @FindBy(id = "passwd")
    WebElement txtPassword;

    @FindBy(id = "SubmitLogin")
    WebElement btnLogin;


    public void createAccount(String email) throws InterruptedException {
        waitForElementVisible(emailCreateAccount);
        emailCreateAccount.sendKeys(email);
        btnCreateAccount.click();
        Thread.sleep(5000);

    }







}
