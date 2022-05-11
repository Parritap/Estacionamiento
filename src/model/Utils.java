package model;

import java.util.ArrayList;

public class Utils {

    public static String setearString(String str) {
        String newString = str;

        if (newString == null) {
            newString = "";
        }
        return newString;
    }


    public static Vehiculo[] arrayList_to_Array (ArrayList<Vehiculo> list){

        int size = list.size();

        Vehiculo[] array = new Vehiculo[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }
}
