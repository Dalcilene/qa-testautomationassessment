package org.example.selenium.elements;

import org.openqa.selenium.By;

public class Button extends CustomWebElement{

    public Button(By locator){
        super(locator);
    }

    public void click(){
        element.click();
    }
}
