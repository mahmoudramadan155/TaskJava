package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	// write your code here
        List<Pyramid> pyramids = PyramidCsvDao.readPyramidCSV("pyramids.csv");

        for(Pyramid p : pyramids)
            System.out.println(p.toString());

//        List<Pyramid> pyramidInfo=new ArrayList<>();
//        File file =new File("pyramids.csv");
//        List<String> lines = new ArrayList<String>();
//        try {
//            lines = Files.readAllLines(file.toPath());
//        } catch (IOException e) {
//            System.out.println("File not found");
//        }
//
//        for(int lineIdx=1;lineIdx<lines.size(); lineIdx++){
//            String line =lines.get(lineIdx);
//            String[] fields = line.split(",");
//            double height1;
//            if(fields[7].equals(""))
//                height1=0;
//            else{
//                height1 = Double.valueOf(fields[7]);
//            }
//            Pyramid p =new Pyramid(fields[0],fields[2],fields[4],height1);
//            pyramidInfo.add(p);
//
//        }
//        for(int i = 0;i< pyramidInfo.size();i++){
//            System.out.println(pyramidInfo.get(i));
//        }
    }
}
