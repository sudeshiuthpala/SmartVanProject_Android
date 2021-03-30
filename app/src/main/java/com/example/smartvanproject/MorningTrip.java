package com.example.smartvanproject;

public class MorningTrip {
    private int tripid;
    private String vanid;
    private String route;
    private String starttime;
    private String endtime;
    private String date;

    public MorningTrip(int tripid,String vanId,String route,String starttime,String endtime,String date){
        this.setTripid(tripid);
        this.setVanid(vanId);
        this.setRoute(route);
        this.setStarttime(starttime);
        this.setEndtime(endtime);
        this.setDate(date);
    }

    public int getTripid() {
        return tripid;
    }

    public void setTripid(int tripid) {
        this.tripid = tripid;
    }

    public String getVanid() {
        return vanid;
    }

    public void setVanid(String vanid) {
        this.vanid = vanid;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
