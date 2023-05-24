package org.example.pageobjects;

import org.example.selenium.elements.Button;
import org.example.selenium.elements.Label;
import org.openqa.selenium.By;
import org.junit.jupiter.api.Assertions;

public class InvoiceListPage {
    Label header = new Label(By.xpath("//h2"));
    Button invoiceLink;
    String invoiceLinkXpath = "//a[contains(text(),'Invoice Details')][%s]";

    public InvoiceListPage openInvoiceDetails(int positionOnGrid){
        invoiceLinkXpath = String.format(invoiceLinkXpath, positionOnGrid);
        invoiceLink = new Button(By.xpath(invoiceLinkXpath));
        invoiceLink.click();
        return this;
    }

    public InvoiceListPage checkInvoiceListPageHeader(){
        Assertions.assertEquals("Invoice List", header.getValue());
        header.highlight();
        return this;
    }

}
