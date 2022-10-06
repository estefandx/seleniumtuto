package com.seleniumtuto.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class GeneralPage {

    static WebDriver driver;
    public static final int EXPLICIT_TUMEOUT = 5;

    public static Map<String, String> HandleMywindows = new HashMap<>();

    public GeneralPage(WebDriver tdriver) {
        driver = tdriver;
        PageFactory.initElements(driver, this);
    }

    public void waitForElementPresent(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TUMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_TUMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void scrollPage(String to) {

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        if (to.equalsIgnoreCase("top")) {
            jse.executeScript("scroll(0,-250)");
        } else {
            jse.executeScript("scroll(0,300)");
        }

    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void pageStatus() {
        String getActual = driver.getCurrentUrl();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(webDriver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));

    }

    public void openNewTabWithUrl(String url) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript(String.format("window.opwn('%s','_blank');"));
    }


    public void changeLastWindow() {
        for (String winhandle : driver.getWindowHandles()) {
            driver.switchTo().window(winhandle);
        }
    }

    public void windowsHadle(String windowsName) {
        if (this.HandleMywindows.containsKey(windowsName)) {
            driver.switchTo().window(this.HandleMywindows.get(windowsName));
        } else {
            for (String winhandle : driver.getWindowHandles()) {
                this.HandleMywindows.put(windowsName, winhandle);
                System.out.println("la nueva ventana" + windowsName + "se a guardado con valor " + this.HandleMywindows.get(windowsName));
                driver.switchTo().window(winhandle);
            }
        }
    }


}
