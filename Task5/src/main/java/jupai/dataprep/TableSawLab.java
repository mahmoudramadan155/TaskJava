package jupai.dataprep;

import tech.tablesaw.api.*;
import tech.tablesaw.joining.DataFrameJoiner;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TableSawLab {
    String path ="src/main/resources/data/titanic.csv";
    String path1 ="src/main/resources/data/vgsales.csv";

    public static void main(String[] args) {

        TableSawLab TS =new TableSawLab();
        try {
            Table TST = TS.loadDataFromCVS(TS.path);
            Table TST1 = TS.loadDataFromCVS(TS.path);

            String structure = TS.getDataInfoStructure(TST);
            System.out.println(structure);
            System.in.read ();

            String summary = TS.getDataSummary(TST);
            System.out.println(summary);
            System.in.read ();

            Table addcolumn = TS.addDateColumnToData(TST);
            System.out.println(TS.getDataInfoStructure(addcolumn));
            System.in.read ();

            Table convert_S_G = TS.mapTextColumnToNumber(TST);
            System.out.println(TS.getDataInfoStructure(convert_S_G));
            System.in.read ();

            convert_S_G.removeColumns("sex");
            System.out.println(convert_S_G.structure());
            System.in.read ();

            Table joinT = TST.joinOn("pclass").inner(true,TST1);
            System.out.println(joinT.toString());
            System.in.read ();

//            Table mergeT = TST.emptyCopy();


//            Table concatT = TST.concat(addcolumn);
            Table mergeT = TST.append(addcolumn);

            System.out.println(mergeT.toString());
//            System.in.read ();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }



    ///  Load Data From CSV File
    public Table loadDataFromCVS(String path) throws IOException {
        Table titanicData = Table.read ().csv (path);
        return titanicData;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /// get the structure of the data
    public String getDataInfoStructure(Table data) {
        Table dataStructure = data.structure ();
        return dataStructure.toString ();
//        return data.structure ().toString();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //get Data Summary
    public String getDataSummary(Table data) {
        Table summary = data.summary ();
        return summary.toString ();
//        return data.summary().toString();
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Adding Columns
    public Table addDateColumnToData(Table data) {
        int rowCount = data.rowCount ();
        List<LocalDate> dateList = new ArrayList<LocalDate>();
        for (int i = 0; i < rowCount; i++) {
            dateList.add (LocalDate.of (2021, 3, i % 31 == 0 ? 1 : i % 31));
        }
        DateColumn dateColumn = DateColumn.create ("Fake Date", dateList);
        data.addColumns(dateColumn);
//        data.insertColumn (data.columnCount (), dateColumn);
        return data;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // mapping text data to numeric values on the sex field female=1,male=0 and adding a column named gender
    public Table mapTextColumnToNumber(Table data) {
        NumberColumn mappedGenderColumn = null;
        StringColumn gender = (StringColumn) data.column ("Sex");
        List<Number> mappedGenderValues = new ArrayList<Number> ();
        for (String v : gender) {
            if ((v != null) && (v.equals ("female"))) {
                mappedGenderValues.add (new Double (1));
            } else {
                mappedGenderValues.add (new Double (0));
            }
        }
        mappedGenderColumn = DoubleColumn.create ("gender", mappedGenderValues);
        data.addColumns (mappedGenderColumn);
        return data;
    }
}
