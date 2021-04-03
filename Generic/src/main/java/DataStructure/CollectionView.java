package DataStructure;

import java.util.HashMap;

public class CollectionView {
    public static void main(String[] args) {

        HashMap<Integer, String> map = new HashMap<Integer, String>();

        map.put(1, "NYC");
        map.put(2, "LA");
        map.put(3, "Denver");
        map.put(4, "Boston");
        map.put(5, "San Jose");
        map.put(6, "Seattle");


//        //retrieve all the data with
//        for (Map.Entry<Integer,String> entry: map.entrySet()){
//            System.out.println(entry.getKey()+" "+entry.getValue());


        System.out.println("******************************************");
        // second method to retrieve value
        for (Integer in:map.keySet()){
            System.out.println(in+" : " +map.get(in));

        } //map+key will be sent to int in
    }
}
