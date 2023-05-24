package org.example.stepdefinitons;

import io.cucumber.java.en.Then;
import org.example.pagedata.InvoiceData;
import org.example.pageobjects.InvoiceDetailsPage;
import org.json.JSONException;
import java.io.IOException;

public class InvoiceDetailsSteps {

    InvoiceDetailsPage invoiceDetailsPage = new InvoiceDetailsPage();
    InvoiceData invoiceData = new InvoiceData();

    @Then("the invoice information should be correctly presented on the page with the information identified with key {string}")
    public void theInvoiceInformationShouldBeCorrectlyPresentedOnThePageWithTheInformationIdentifiedWithKey(String rendezvousHotel) throws JSONException {
        try {
            invoiceData = invoiceData.getInvoiceJson(rendezvousHotel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        invoiceDetailsPage.checkAllAttributes(invoiceData);
    }
}
