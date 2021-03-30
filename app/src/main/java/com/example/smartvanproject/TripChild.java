package com.example.smartvanproject;

public class TripChild {
    private String childfname;
    private String childlname;
    private String childschool;
    private String childlocation;

    public TripChild(String fname,String lname,String school,String location){
        this.setChildfname(fname);
        this.setChildlname(lname);
        this.setChildschool(school);
        this.setChildlocation(location);
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

    public String getChildschool() {
        return childschool;
    }

    public void setChildschool(String childschool) {
        this.childschool = childschool;
    }

    public String getChildlocation() {
        return childlocation;
    }

    public void setChildlocation(String childlocation) {
        this.childlocation = childlocation;
    }
}
