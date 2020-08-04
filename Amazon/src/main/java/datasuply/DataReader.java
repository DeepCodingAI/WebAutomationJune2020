package datasuply;

import base.CommonAPI;
import datasources.ConnectToSqlDB;
import reporting.TestLogger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static ConnectToSqlDB connectToSqlDB = new ConnectToSqlDB();
    public List<String> getListOfItems(){
        TestLogger.log(getClass().getSimpleName() + ": " + CommonAPI.convertToString(new Object(){}.getClass().getEnclosingMethod().getName()));
        List<String> list = new ArrayList<String>();
        list.add("java books");
        list.add("tooth paste");
        list.add("coffee");
        list.add("laptop");
        list.add("honey");
        list.add("Comic Books");

        return list;
    }

    public static List<String> getItemsListFromDB()throws Exception, IOException, SQLException, ClassNotFoundException {
        List<String> list = new ArrayList<>();
        list = connectToSqlDB.readDataBase("ItemList", "items");
        return list;
    }
}
