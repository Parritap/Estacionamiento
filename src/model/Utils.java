package model;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    public static String setearString(String str) {
        String newString = str;

        if (newString == null) {
            newString = "";
        }
        return newString;
    }


    public static Vehiculo[] arrayListToArray(ArrayList<Vehiculo> list) {

        int size = list.size();

        Vehiculo[] array = new Vehiculo[size];

        for (int i = 0; i < array.length; i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    /**
     * Método que retorna true si el String pasasdo en el argumento cumple las siguientes condiciones:
     * 1) Tiene un solo carácter
     * 2) Es un dígito.
     *
     * @param str String a evaluar.
     * @return True si @str es un dígito.
     */
    public static boolean esDigito(String str) {

        Pattern pat = Pattern.compile("\\d");
        Matcher mat = pat.matcher(str);

        return mat.matches();
    }

    /**
     * Método que informa si el char pasado en el argumento es dígito o no.
     *
     * @param c
     * @return
     */
    public static boolean esDigito(char c) {

        String str = "" + c;

        Pattern pat = Pattern.compile("\\d");
        Matcher mat = pat.matcher(str);

        return mat.matches();
    }


    /**
     * Método que verifica si un carácter es vocal o no.
     * @return True de ser vocal.
     */
    public static boolean esVocal(char c) {

        String s = "aeiouAEIOU";

        char[] vowels = s.toCharArray();

        for (char v : vowels) {

            if (c == v)
                return true;
        }
        return false;
    }


    /**
     * Convierte un String a un entero y luego verifica si este es par.
     * @param str String a convertir a entero.
     * @return True si el numero obtenido es par.
     */
    public static boolean esPar(String str) {
        return Integer.parseInt(str) % 2 ==0;
    }

    public static boolean esPar(int i) {
        return i % 2 ==0;
    }

    public static boolean esPar(char c) {
        return Character.getNumericValue(c) % 2 == 0;
    }

}
