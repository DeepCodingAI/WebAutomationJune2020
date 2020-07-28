package table;

import base.CommonAPI;
import java.util.List;

public class SqlTablePage extends CommonAPI {

    public void readTableData(){
        //Reading single web element and read text
        String st = getTextByCss(".w3-table-all.notranslate tr:nth-child(5)");
        System.out.println(st);
        //Reading multiple web elements and read text
        /*List<String> list = readListOfText(".w3-table-all.notranslate tr:nth-child(5) td:nth-child(4)");
        for(String text:list){
            System.out.print(text);
        }*/
    }
}
