package datasuply;

import base.CommonAPI;
import datasources.ConnectToExcelFile;


import java.io.IOException;

public class FetchTheSteps {
    ConnectToExcelFile excelFile = new ConnectToExcelFile();
    public String[] getDataFromExcelFile() throws IOException {
        String path = System.getProperty("user.dir")+"/NYP/data/nyp-test-steps.xls";
        String [] data = excelFile.fileReader2(path,0);
        return data;
    }

    public String[] getDataFromExcelFileForFeaturesChoice() throws IOException{
        String path = System.getProperty("user.dir")+"/data/nyp-test-steps.xls";
        String [] data = excelFile.fileReader2(path,0);
        return data;
    }
}
