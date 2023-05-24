package org.example.selenium.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import java.security.Key;

public class Input extends CustomWebElement{


    public Input(By locator){
        super(locator);
    }
    public void sendText(String text){
        element.sendKeys(text);
    }

    public void goToNextInput(){
        element.sendKeys(Keys.TAB);
    }
}
