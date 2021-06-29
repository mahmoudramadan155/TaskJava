package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CitiesDAO {
    public CitiesDAO() {
    }
    public static List<Cities> readCityCSV(String fieldName){
        List<Cities> city = new ArrayList<>();
        String[] line;
        try {
            Scanner file = new Scanner(new File(fieldName));
            file.nextLine();
            while(file.hasNext()){
                line =file.nextLine().split(",");
                city.add(createCities(line));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error Not Found File");
        }
        return city;
    }

    private static Cities createCities(String[] line){
         String City_id,city,Country_id,capital;

        Double population;
        Cities x=null;
        if(line.length==5){
              City_id = line[0];
              city = line[1];
              Country_id = line[2];
              capital = line[3];
              population = Double.valueOf(line[4]);
              x=new Cities(City_id,city,Country_id,capital,population);
        }
        return x;

    }

}
