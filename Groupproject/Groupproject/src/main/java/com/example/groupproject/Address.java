package com.example.groupproject;

/**
 * Created by toddfrisch on 5/31/13.
 */
public class Address {
    private String streetNumber;
    private String city;
    private StateCode state;
    private String postalCode;

    public Address(String streetNumber, String city, StateCode state,
                   String postalCode) {
        this.streetNumber = streetNumber;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }


    public String getCity(){
        return city;
    }
    public String getPostalCode(){
        return postalCode;
    }
    public StateCode getState(){
        return state;
    }
    public String getStreetNumber(){
        return streetNumber;
    }


    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(streetNumber + "\n");
        sb.append(String.format("%s, %s %s", city, state.toString(), postalCode));
        return sb.toString();
    }

}
