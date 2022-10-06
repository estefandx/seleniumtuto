package com.seleniumtuto.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PersonalInformationPage extends GeneralPage {

    public PersonalInformationPage(WebDriver tdriver) {
        super(tdriver);
    }

    @FindBy(id = "id_gender1")
    WebElement chkMr;

    @FindBy(id = "id_gender2")
    WebElement chkMrs;

    @FindBy(id = "customer_firstname")
    WebElement firstName;

    @FindBy(id = "customer_lastname")
    WebElement lastName;

    @FindBy(id = "passwd")
    WebElement password;

    @FindBy(id = "submitAccount")
    WebElement btnRegister;


    public void selectGender(String gender) throws InterruptedException {
        if (gender.equalsIgnoreCase("Mr")) {
            if (!chkMr.isSelected()) {
                chkMr.click();
            }
        } else {
            if (!chkMrs.isSelected()) {
                chkMrs.click();
            }
        }


    }

    public  void registerJs() throws InterruptedException {
        scrollToElement(btnRegister);
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
       // jse.executeScript("arguments[0].click()",btnRegister);
        scrollPage("top");
        Thread.sleep(20000);
    }


}
