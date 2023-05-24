package org.example;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberContextConfiguration
@CucumberOptions(plugin = {"pretty", "json:target/surefire-reports/cucumber/cucumber.json"}, features = "src/test/resources/features")

public class CucumberIT {
}
