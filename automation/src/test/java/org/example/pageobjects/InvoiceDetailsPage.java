package org.example.pageobjects;

import org.example.pagedata.InvoiceData;
import org.example.selenium.SeleniumBase;
import org.example.selenium.elements.Label;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceDetailsPage {
    Label hotelName;
    Label invoiceDate;
    Label dueDate;
    Label invoiceNumber;
    Label bookingCode;
    Label customerDetails;
    Label room;
    Label checkIn;
    Label checkOut;
    Label totalStayCount;
    Label totalStayAmount;
    Label depositNow;
    Label taxVat;
    Label totalAmount;

    public InvoiceDetailsPage() {
        changeTab();
        hotelName = findLabel("//h4[@class='mt-5']");
        invoiceNumber = findLabel("//h6[@class='mt-2']");
        invoiceDate = findLabel("//li[span[contains(text(),'Invoice Date:')]]");
        dueDate = findLabel("//li[span[contains(text(),'Due Date:')]]");
        bookingCode = findLabel("//td[text()='Booking Code']/following-sibling::td");
        room = findLabel("//td[text()='Room']/following-sibling::td");
        totalStayCount = findLabel("//td[text()='Total Stay Count']/following-sibling::td");
        totalStayAmount = findLabel("//td[text()='Total Stay Amount']/following-sibling::td");
        checkIn = findLabel("//td[text()='Check-In']/following-sibling::td");
        checkOut = findLabel("//td[text()='Check-Out']/following-sibling::td");
        customerDetails = findLabel("//h5[contains(text(),'Customer Details')]/following-sibling::div");
        depositNow = findLabel( "//table[2]/tbody/tr/td[1]");
        taxVat = findLabel( "//table[2]/tbody/tr/td[2]");
        totalAmount = findLabel("//table[2]/tbody/tr/td[3]");
    }

    private Label findLabel(String xpath) {
        try {
            WebElement element = SeleniumBase.getInstance().getDriver().findElement(By.xpath(xpath));
            return new Label(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            // Handles the exception, for example by displaying an error message or writing a log.
            System.out.println("Element not found: " + xpath);
            return null;
        }
    }

    public InvoiceDetailsPage changeTab(){
        SeleniumBase.getInstance().changeToNextTab();
        Label hotelName  = new Label(By.xpath("//h4"));
        return this;
    }

    private InvoiceDetailsPage checkAttributeValue(Label attribute, String value){
        attribute.checkElementValue(value);
        return this;
    }

    public InvoiceDetailsPage checkHotelNameValue(String value){return  checkAttributeValue(this.hotelName, value); }
    public InvoiceDetailsPage checkInvoiceDateValue(String value) {
        String expectedDate = value;
        String actualText = invoiceDate.getValue();
        String actualDate = extractDateFromText(actualText);
        assertEquals(expectedDate, actualDate);
        return this;
    }

    private String extractDateFromText(String text) {
        String pattern = "\\d{2}/\\d{2}/\\d{4}"; // date pattern "dd/mm/yyyy"
        Pattern regexPattern = Pattern.compile(pattern);
        Matcher matcher = regexPattern.matcher(text);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }
    public InvoiceDetailsPage checkDueDateValue(String value){
        String expectedDate = value;
        String actualText = dueDate.getValue();
        String actualDate = extractDateFromText(actualText);
        assertEquals(expectedDate, actualDate);
        return this;
    }
    public InvoiceDetailsPage checkInvoiceNumberValue(String value){
        return checkAttributeValue(this.invoiceNumber, value);
    }
    public InvoiceDetailsPage checkBookingCodeValue(String value){
        return checkAttributeValue(this.bookingCode, value);
    }
    public InvoiceDetailsPage checkRoomValue(String value){
        return checkAttributeValue(this.room, value);
    }
    public InvoiceDetailsPage checkStayCountValue(String value){
        return checkAttributeValue(this.totalStayCount, value);
    }
    public InvoiceDetailsPage checkStayAmountValue(String value){
        return checkAttributeValue(this.totalStayAmount, value);
    }
    public InvoiceDetailsPage checkCheckInDateValue(String value){
        return checkAttributeValue(this.checkIn, value);
    }
    public InvoiceDetailsPage checkCheckOutDateValue(String value){
        return checkAttributeValue(this.checkOut, value);
    }
    public InvoiceDetailsPage checkCustomerAddressValue(String value){
        return checkAttributeValue(this.customerDetails, value);
    }
    public InvoiceDetailsPage checkDepositNowtValue(String value){
        return checkAttributeValue(this.depositNow, value);
    }
    public InvoiceDetailsPage checkTaxVatValue(String value){
        return checkAttributeValue(this.taxVat, value);
    }
    public InvoiceDetailsPage checkTotalAmountValue(String value){
        return checkAttributeValue(this.totalAmount, value);
    }

    public InvoiceDetailsPage checkAllAttributes(InvoiceData data){
        if (data.getHotelName() != null) {
            checkHotelNameValue(data.getHotelName());
        }
        if (data.getInvoiceDate() != null) {
            checkInvoiceDateValue(data.getInvoiceDate());
        }
        if (data.getDueDate() != null) {
            checkDueDateValue(data.getDueDate());
        }
        if (data.getInvoiceNumber() != null) {
            checkInvoiceNumberValue(data.getInvoiceNumber());
        }
        if (data.getBookingCode() != null) {
            checkBookingCodeValue(data.getBookingCode());
        }
        if (data.getCustomerDetails() != null) {
            checkCustomerAddressValue(data.getCustomerDetails());
        }
        if (data.getRoom() != null) {
            checkRoomValue(data.getRoom());
        }
        if (data.getCheckIn() != null) {
            checkCheckInDateValue(data.getCheckIn());
        }
        if (data.getCheckOut() != null) {
            checkCheckOutDateValue(data.getCheckOut());
        }
        if (data.getTotalStayAmount() != null) {
            checkStayAmountValue(data.getTotalStayAmount());
        }
        if (data.getTotalStayCount() != null) {
            checkStayCountValue(data.getTotalStayCount());
        }
        if (data.getDepositNow() != null) {
            checkDepositNowtValue(data.getDepositNow());
        }
        if (data.getTaxVat() != null) {
            checkTaxVatValue(data.getTaxVat());
        }
        if (data.getTotalAmount() != null) {
            checkTotalAmountValue(data.getTotalAmount());
        }

        return this;
    }
}


