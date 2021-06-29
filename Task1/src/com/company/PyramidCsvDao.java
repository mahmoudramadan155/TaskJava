package com.company;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class PyramidCsvDao {
    public PyramidCsvDao(){

    }

    public static List <Pyramid> readPyramidCSV(String fileName){
        List<Pyramid> pyramids = new ArrayList<Pyramid>();

        try {
            String [] line;
            Scanner fileInput = new Scanner(new File(fileName));
            //fileInput.useDelimiter("\n");
            fileInput.nextLine();
            while(fileInput.hasNextLine()) {

                line = fileInput.nextLine().split(",");

//                        Pyramid pyramidInfo=new Pyramid(line[0],line[2],line[4],Double.parseDouble(line[7]));
//
//                        pyramids.add(pyramidInfo);
                pyramids.add(createPyramid(line));
            }
            fileInput.close();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("An error not found file");
        }
        return pyramids;
    }
    private static Pyramid createPyramid(String [] line) {

        double height1;
        if(line[7].equals(""))
            height1=0;
        else{
            height1 = Double.valueOf(line[7]);
        }
        String pharaoh = line[0];
        String modern_name = line[2];
        String site = line[4];
        double height = Double.parseDouble(line[7]);

        return new Pyramid(pharaoh , modern_name , site , height);

    }

}
