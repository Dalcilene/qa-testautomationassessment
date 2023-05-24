package org.example.pageobjects;

import org.example.selenium.elements.Button;
import org.example.selenium.elements.Input;
import org.example.selenium.elements.Label;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginPage {

    private Input username;
    private Input password;
    private Button loginButton;
    private Label header;
    private Label alert;

    public LoginPage(){
        username = new Input(By.xpath("//form//input[@name='username']"));
        password = new Input(By.cssSelector("input[name='password']"));
        header = new Label(By.xpath("//h1"));
        loginButton = new Button(By.id("btnLogin"));
    }

    public LoginPage checkLoginPageHeader(){
        Assertions.assertEquals("Login", header.getValue());
        header.highlight();
        return this;
    }

    public LoginPage performLogin(String username, String password){
        return this
                .fillUsername(username)
                .fillPassword(password)
                .clickLoginButton();
    }

    public LoginPage fillUsername(String username){
        this.username.sendText(username);
        return this;
    }

    public LoginPage fillPassword(String password){
        this.password.sendText(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        this.loginButton.click();
        return this;
    }

    public LoginPage checkLoginMessage(String message) {
        alert = new Label(By.cssSelector("div.alert"));
        Assertions.assertTrue(alert.getValue().contains(message));
        alert.highlight("yellow");
        return this;
    }
}
