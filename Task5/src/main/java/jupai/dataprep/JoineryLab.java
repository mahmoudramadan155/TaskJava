package jupai.dataprep;

import joinery.DataFrame;
import joinery.impl.js.DataFrameAdapter;
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.joining.DataFrameJoiner;

import java.io.IOException;
import java.util.*;

public class JoineryLab {
    String path ="src/main/resources/data/titanic.csv";

    public static void main(String[] args) {
        JoineryLab J = new JoineryLab();

        try {
            DataFrame<Object> df= DataFrame.readCsv (J.path);
            DataFrame<Object> df1= DataFrame.readCsv (J.path);

//            System.out.println (df.describe().toString());
//            System.out.println (df.mean());
//           System.out.println(df.length());
//            DataFrame<Object> colMean=df.groupBy(row ->row.get(0)).mean();
//            System.out.println(colMean);

//            System.out.println(df1.join(df));
//            df1.joinOn(df).col("pclass");
             List<Object> sex = df.col("sex");
//            System.out.println(sex);

//            ArrayList<String> gender =(ArrayList) df.col("sex");
            List<Object> mappedGenderValues = new ArrayList<>();

            for (Object v : sex) {
                if ((v != null) && (v.equals ("female"))) {
                    mappedGenderValues.add (new Integer (1));
                } else {
                    mappedGenderValues.add (new Integer (0));
                }
            }

//            NumberColumn mappedGenderColumn = .create("gender", mappedGenderValues);
//            df.add("Gender").append(mappedGenderValues);
//            df.add("Gender",mappedGenderValues);
        df.add("Gender", mappedGenderValues);
            System.out.println( df.describe());
//           System.out.println(df.toString()) ;


        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

}
