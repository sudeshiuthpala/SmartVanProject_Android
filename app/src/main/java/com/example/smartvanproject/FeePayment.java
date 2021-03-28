package com.example.smartvanproject;

public class FeePayment {
    private int paymentId;
    private int childId;
    private String childfname;
    private String childlname;
    private String amount;
    private String payment_date;

    public FeePayment(int paymentId,int childId,String childfname,String childlname,String amount,String payment_date){
        this.setPaymentId(paymentId);
        this.setChildId(childId);
        this.setChildfname(childfname);
        this.setChildlname(childlname);
        this.setAmount(amount);
        this.setPayment_date(payment_date);
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getChildfname() {
        return childfname;
    }

    public void setChildfname(String childfname) {
        this.childfname = childfname;
    }

    public String getChildlname() {
        return childlname;
    }

    public void setChildlname(String childlname) {
        this.childlname = childlname;
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
