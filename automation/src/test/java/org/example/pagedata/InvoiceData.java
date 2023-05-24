package org.example.pagedata;

import org.json.JSONException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InvoiceData {
    private String hotelName;
    private String invoiceDate;
    private String dueDate;
    private String invoiceNumber;
    private String bookingCode;
    private String customerDetails;
    private String room;
    private String checkIn;
    private String checkOut;
    private String totalStayCount;
    private String totalStayAmount;
    private String depositNow;
    private String taxVat;
    private String totalAmount;
    private String jsonPath;

    public InvoiceData() {
        jsonPath = "src/test/resources/testData/testData.json";
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getInvoiceDate() {
        return invoiceDate;
    }
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public String getCustomerDetails() {
        return customerDetails;
    }

    public void setCustomerDetails(String customerDetails) {
        this.customerDetails = customerDetails;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getTotalStayCount() {
        return totalStayCount;
    }

    public void setTotalStayCount(String totalStayCount) {
        this.totalStayCount = totalStayCount;
    }

    public String getTotalStayAmount() {
        return totalStayAmount;
    }

    public void setTotalStayAmount(String totalStayAmount) {
        this.totalStayAmount = totalStayAmount;
    }

    public String getDepositNow() {
        return depositNow;
    }

    public void setDepositNow(String depositNow) {
        this.depositNow = depositNow;
    }

    public String getTaxVat() {
        return taxVat;
    }

    public void setTaxVat(String taxVat) {
        this.taxVat = taxVat;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public InvoiceData getInvoiceJson(String dataKey) throws IOException, JSONException {
        JSONParser jsonParser = new JSONParser();
        try (FileReader fileReader = new FileReader(jsonPath)) {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(fileReader);
            JSONObject rendezvousHotel = (JSONObject) jsonObject.get(dataKey);
            InvoiceData invoice = new InvoiceData();
            invoice.setHotelName(getStringFromJSONObject(rendezvousHotel, "hotelName"));
            invoice.setInvoiceDate(getStringFromJSONObject(rendezvousHotel, "invoiceDate"));
            invoice.setDueDate(getStringFromJSONObject(rendezvousHotel, "dueDate"));
            invoice.setInvoiceNumber(getStringFromJSONObject(rendezvousHotel, "invoiceNumber"));
            invoice.setBookingCode(getStringFromJSONObject(rendezvousHotel, "bookingCode"));
            invoice.setCustomerDetails(getStringFromJSONObject(rendezvousHotel, "customerDetails"));
            invoice.setRoom(getStringFromJSONObject(rendezvousHotel, "room"));
            invoice.setCheckIn(getStringFromJSONObject(rendezvousHotel, "checkIn"));
            invoice.setCheckOut(getStringFromJSONObject(rendezvousHotel, "checkOut"));
            invoice.setTotalStayCount(getStringFromJSONObject(rendezvousHotel, "totalStayCount"));
            invoice.setTotalStayAmount(getStringFromJSONObject(rendezvousHotel, "totalStayAmount"));
            invoice.setDepositNow(getStringFromJSONObject(rendezvousHotel, "depositNow"));
            invoice.setTaxVat(getStringFromJSONObject(rendezvousHotel, "taxVat"));
            invoice.setTotalAmount(getStringFromJSONObject(rendezvousHotel, "totalAmount"));

            return invoice;
        } catch (FileNotFoundException e) {
            throw new IOException("Unable to open JSON file: " + jsonPath, e);
        } catch (ParseException e) {
            throw new JSONException("Unable to parse JSON file: " + jsonPath);
        }
    }

    private String getStringFromJSONObject(JSONObject jsonObject, String key) {
        if (jsonObject.containsKey(key)) {
            try {
                return (String) jsonObject.get(key);
            } catch (ClassCastException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

}
