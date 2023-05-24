package org.example.stepdefinitons;

import io.cucumber.java.en.When;
import org.example.pageobjects.InvoiceListPage;
import io.cucumber.java.en.Then;

public class InvoiceListSteps {

    InvoiceListPage invoiceListPage = new InvoiceListPage();

    @Then("user should be redirected to the Invoice List page")
    public void userShouldBeRedirectedToTheInvoiceListaPage() {
        invoiceListPage.checkInvoiceListPageHeader();
    }
    @When("the user clicks the Invoice Details link for the {int} item presented on the screen")
    public void theUserClicksTheInvoiceDetailsLinkForTheItemPresentedOnTheScreen(int position) {
        invoiceListPage.openInvoiceDetails(position);
    }


}
