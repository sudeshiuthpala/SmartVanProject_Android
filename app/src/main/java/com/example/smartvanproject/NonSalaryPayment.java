package com.example.smartvanproject;

public class NonSalaryPayment {
    private String driverId;
    private String fname;
    private String lname;

    public  NonSalaryPayment(String driverId,String fname,String lname){
        this.setDriverId(driverId);
        this.setFname(fname);
        this.setLname(lname);
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
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
