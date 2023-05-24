package org.example.selenium.elements;

import org.example.selenium.SeleniumBase;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class Label extends CustomWebElement{

    public Label(By locator) {
        super(locator);
    }

    public String getValue(){
        return element.getText();
    }

    public void highlight() {
        ((JavascriptExecutor) SeleniumBase.getInstance().getDriver()).executeScript("arguments[0].style.border='2px solid red'", this.element);
    }

    public void highlight(String color) {
        ((JavascriptExecutor) SeleniumBase.getInstance().getDriver()).executeScript("arguments[0].style.border='2px solid"+color+"'", this.element);
    }
    public Object checkElementValue(String value){
        Assertions.assertEquals(value, this.getValue());
        this.highlight();
        return this;
    }
}
