package com.example.smartvanproject;

public class SalaryPaymentClass {
    private int paymentId;
    private String driverId;
    private String driverfname;
    private String driverlname;
    private String amount;
    private String payment_date;

    public SalaryPaymentClass(int paymentId, String driverId, String driverfname, String driverlname, String amount, String payment_date) {
        this.setPaymentId(paymentId);
        this.setDriverId(driverId);
        this.setDriverfname(driverfname);
        this.setDriverlname(driverlname);
        this.setAmount(amount);
        this.setPayment_date(payment_date);
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getDriverfname() {
        return driverfname;
    }

    public void setDriverfname(String driverfname) {
        this.driverfname = driverfname;
    }

    public String getDriverlname() {
        return driverlname;
    }

    public void setDriverlname(String driverlname) {
        this.driverlname = driverlname;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPayment_date() {
        return payment_date;
    }

    public void setPayment_date(String payment_date) {
        this.payment_date = payment_date;
    }
}
