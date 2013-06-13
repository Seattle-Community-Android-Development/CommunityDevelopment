package com.example.groupproject;

/**
 * Created by toddfrisch on 5/31/13.
 */
public class Event {
    private String name;
    public String header;
    private String description;
    private long time; //to store time in time in milliseconds from 1970
    private Address address;
    private double longitude;
    private double latitude;


    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getDescription() {
        return description;

    }

    public long getTime() {
        return time;
    }

    public Address getAddress() {
        return address;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
