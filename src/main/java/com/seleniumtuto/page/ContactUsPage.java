package com.seleniumtuto.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage  extends  GeneralPage{

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_contact")
    WebElement subjectHeading;





    public void selectSubjectHeading(String option) throws InterruptedException {
        Select select = new Select(subjectHeading);
        select.selectByVisibleText(option);
        Thread.sleep(5000);
    }


}
