package com.seleniumtuto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends  GeneralPage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='email']")
    private WebElement email;

    @FindBy(xpath = "//a[@class='login']")
    private WebElement singIn;

    @FindBy(id = "contact-link")
    private  WebElement contacUs;




    public void fillFormLogin(String username,String password) throws InterruptedException {
        //WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(singIn));
        singIn.click();
        email.click();
        email.sendKeys(username);
        Thread.sleep(5000);

    }

    public void contactUs(){
        waitForElementPresent(contacUs);
        contacUs.click();
    }

    public void singUp(){
        singIn.click();
    }

}
