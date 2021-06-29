package com.company;

import java.sql.Struct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;


import static java.lang.Math.floor;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Cities> cities1=CitiesDAO.readCityCSV("cities.csv");
        List<Country> countries1=CountryDAO.readCountryCSV("countries.csv");
            List<Cities> cities=new ArrayList<>();
            for(Cities city:cities1){
                if(city!=null)
                    cities.add(city);
//                    System.out.println(city);
            }
//        System.out.println(cities.size());
        List<Country> countries =new ArrayList<>();
        for(Country country:countries1){
            if(country!=null) {
                countries.add(country);
//                System.out.println(country);
            }}
//            System.out.println(countries.size());
        Map<Country,List<Cities>> merge = new HashMap<>();
        for(Country country : countries){
            List<Cities> citylist=new ArrayList<>();
                String code = country.getCode();
            for(Cities city : cities){

//                if(city.getCountry_id()!=null & code !=null) {

//                }
                if (city.getCountry_id().equals(code))
                    citylist.add(city);

            }
            merge.put(country,citylist);
        }
//           System.out.println(merge);
//        merge.forEach((k, v) -> v.stream().map(Cities::getPopulation).sorted().collect(Collectors.toList()));
////        merge.forEach((k,v) -> v.stream().filter(b -> b.getPopulation()!=null));
//        merge.forEach((k,v)->System.out.println("CountryName : "+k.getCountry()+" <=======> "+v));

//        merge.forEach((k,v)->System.out.println(k +" The max value of cities is : "+v.stream().map(Cities::getPopulation).max(Double::compareTo)));

//        merge.forEach((k,v)->System.out.println(k +" The max value of Population is : "+v.stream().map(Cities::getPopulation).max(Double::compareTo)+" The max value of Capital is : "+v.stream().map(Cities::getCapital).max(String::compareToIgnoreCase)));



        double median, lowerQuartile, upperQuartile,average;

        List<Double> sortedCity = cities.stream().map(Cities::getPopulation).sorted().collect(Collectors.toList());

        if (sortedCity.size() % 2 == 0) {
            median = (sortedCity.get((sortedCity.size()/2)) + sortedCity.get((sortedCity.size())/2 + 1))/2;
            lowerQuartile = (sortedCity.get(sortedCity.size()/4) + sortedCity.get((sortedCity.size()/4)+ 1))/2;
            upperQuartile = (sortedCity.get((int)floor(sortedCity.size()*.75)) + sortedCity.get((int)floor(sortedCity.size()*.75))+1)/2;
        }
        else {
            median = sortedCity.get(sortedCity.size()/2);
            lowerQuartile = sortedCity.get(sortedCity.size()/4);
            upperQuartile = sortedCity.get((int)floor(sortedCity.size()*.75));
        }
//System.out.println("Median value is : "+ median+ " lowerQuartile value is : "+lowerQuartile+" upperQuartile value is : "+upperQuartile);

////        average
//        sortedCity.stream().flatMap(s -> s.stream().map(Cities::getPopulation)).average();
//        sortedCity.stream().map(Cities::getPopulation).average().getAsDouble();
         System.out.println(cities.stream().mapToDouble(Cities::getPopulation).average().getAsDouble());



    }
}
