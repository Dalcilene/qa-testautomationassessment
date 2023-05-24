package org.example.stepdefinitons;

import org.example.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();

    @Given("user is in login page")
    public void userIsInLoginPage() {
        loginPage.checkLoginPageHeader();
    }

    @When("user perform login with {string} and {string}")
    public void userPerformLoginWithAnd(String username, String password) {
        loginPage.performLogin(username, password);
    }

    @Then("user will see message {string}")
    public void userWillSeeMessage(String message) {
        loginPage.checkLoginMessage(message);
    }

    @Given("user is logged in with {string} and {string}")
    public void userIsLoggedIn(String username, String password) {
        loginPage.performLogin(username, password);
    }
}
