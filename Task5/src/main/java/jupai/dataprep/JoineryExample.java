package jupai.dataprep;

import joinery.DataFrame;

import java.io.IOException;
import java.util.Date;

public class JoineryExample {
    public static void main(String args[]){
        try {

           DataFrame<Object>  df1= DataFrame.readCsv ("src/main/resources/data/vgsales.csv")
                    .retain("Year", "NA_Sales","EU_Sales","JP_Sales")
                    .describe ();
           System.out.println (df1.toString ());
            System.out.println ("=========================================================================================");
            System.in.read();
            DataFrame<Object>  df= DataFrame.readCsv ("src/main/resources/data/vgsales.csv")
                    .retain("Year", "NA_Sales","EU_Sales","JP_Sales")
                    .groupBy(row ->row.get(0))
                    .mean ();
            df.iterrows ().forEachRemaining (System.out::println);

            System.out.println ("=========================================================================================");
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
