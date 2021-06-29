package com.company;

public class Cities {
    private String City_id,city,Country_id,capital;

    private Double population;

public Cities(){}
    public Cities(String City_id, String city, String Country_id, String capital, Double population) {
        this.City_id = City_id;
        this.city = city;
        this.Country_id = Country_id;
        this.capital = capital;
        this.population = population;
    }

    public String getCity_id() {
        return City_id;
    }

    public void setCity_id(String City_id) {
        this.City_id = City_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry_id() {
        return Country_id;
    }

    public void setCountry_id(String Country_id) {
        this.Country_id = Country_id;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public  Double getPopulation() {
        return population;
    }

    public void setPopulation(Double population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "Cities{" + "City_id=" + City_id + ", city=" + city + ", Country_id=" + Country_id + ", capital=" + capital + ", population=" + population + '}';
    }
}
