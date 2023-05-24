package org.example.selenium.elements;

import org.example.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public abstract class CustomWebElement {

    public CustomWebElement(By locator){
        element = SeleniumBase.getInstance().getDriver().findElement(locator);
    }
    By locator;
    WebElement element;

    long timeOutInSeconds = 5L;

    Duration duration = Duration.ofSeconds(timeOutInSeconds);
}
