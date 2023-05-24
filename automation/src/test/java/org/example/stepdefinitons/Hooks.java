package org.example.stepdefinitons;

import io.cucumber.java.AfterAll;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.example.selenium.SeleniumBase;
import org.junit.After;

public class Hooks {
    private static int stepCounter = 0;

    @Before
    public void before(){
        SeleniumBase
                .getInstance()
                .startBrowser("https://automation-sandbox-python-mpywqjbdza-uc.a.run.app", true);
    }

    @AfterStep
    public static void afterStep(final Scenario scenario){
        SeleniumBase
                .getInstance()
                .takeScreenShot(scenario.getName()+"_step_"+stepCounter);
    }

    @After
    public static void afterScenario(){
        stepCounter=0;
    }

    @AfterAll
    public static void afterTests(){
        SeleniumBase.getInstance().quitDriver();
    }
}
