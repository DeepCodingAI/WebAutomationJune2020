package datasuply;

import java.util.ArrayList;
import java.util.List;

public class DataReader {

    public static List<String> getListOfItems(){
        List<String> list = new ArrayList<String>();
        list.add("java books");
        list.add("tooth paste");
        list.add("coffee");
        list.add("laptop");
        list.add("honey");
        list.add("Comic Books");

        return list;
    }
}
