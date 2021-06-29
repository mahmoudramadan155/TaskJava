package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CountryDAO {
    public CountryDAO() {
    }
    static List<Country> country;
    public static List<Country> readCountryCSV(String fieldName){
        country = new ArrayList<>();

        String[] line;
        try {
            Scanner file = new Scanner(new File(fieldName));
            file.nextLine();
            while(file.hasNext()){
                line =file.nextLine().split(",");

                country.add(createCountry(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error Not Found File");
        }
        return country;
    }

    private static Country createCountry(String[] line) {

        Country x=null;

        if (line.length == 2) {

            String Country = line[0];
            String code = line[1];
            x= new Country(Country, code);
        }
        return x;
    }

   /* private static void createCountry(String[] line) {

        if (line.length == 2) {

            String Country = line[0];
            String code = line[1];
            Country x= new Country(Country, code);
            for (Country element : country) {
                if (!country.contains(x)) {
                    country.add(x);
                }
            }
        }

    }*/
}
