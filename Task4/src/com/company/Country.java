package com.company;

public class Country {
    private String Country,code;

    public Country(String Country, String code) {
        this.Country = Country;
        this.code = code;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String Country) {
        this.Country = Country;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Country{" + "Country=" + Country + ", code=" + code + '}';
    }
}
