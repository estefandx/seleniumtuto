package com.seleniumtuto.functions;

import com.seleniumtuto.stepdefinitions.Hooks;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.Duration;

public class SelemiunFunctions {

    private static Logger log = Logger.getLogger(SelemiunFunctions.class);

    static WebDriver driver;


    public static String FileName = "";
    public static String PagesFilePath = "src/test/resources/page/";

    public SelemiunFunctions(){
        driver = Hooks.driver;
    }

    public static Object readJson() throws Exception {
        FileReader reader = new FileReader(PagesFilePath + FileName);
        try {
            if (reader != null) {
                JSONParser jsonParser = new JSONParser();
                return jsonParser.parse(reader);
            } else {
                return null;
            }
        } catch (FileNotFoundException | NullPointerException e) {
            log.error(" No existe el archivo" + FileName);
            throw new IllegalStateException("No existe El archivo" + FileName);

        }

    }

    public static JSONObject readEntity(String element) throws Exception {
        JSONObject entity = null;

        JSONObject jsonObject = (JSONObject) readJson();
        entity = (JSONObject) (jsonObject != null ? jsonObject.get(element) : null);
        log.info(entity.toJSONString());
        return entity;

    }



}
