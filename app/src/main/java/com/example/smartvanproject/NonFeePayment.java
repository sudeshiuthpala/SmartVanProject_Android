package com.example.smartvanproject;

public class NonFeePayment {
    private int childId;
    private String fname;
    private String lname;

    public  NonFeePayment(int childId,String fname,String lname){
        this.setChildId(childId);
        this.setFname(fname);
        this.setLname(lname);
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
}
