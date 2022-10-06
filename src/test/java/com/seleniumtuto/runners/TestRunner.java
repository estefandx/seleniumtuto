package com.seleniumtuto.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/PaginaLogin.feature",glue = {"com.seleniumtuto.stepdefinitions"}
)
public class TestRunner {
}
