package Test;

import model.Parqueadero;
import model.Vehiculo;

import java.util.ArrayList;
import java.util.Collections;

public class RandomTest {

    public static void main(String[] args) throws Exception {

        Parqueadero parqueadero = new Parqueadero("myParquedero", new ArrayList<Vehiculo>());

        Vehiculo v1 = new Vehiculo("aaa");

        Vehiculo v2 = new Vehiculo("bbb");

        Vehiculo v3 = new Vehiculo("aaa");

        Vehiculo v4 = new Vehiculo("ccc");

        Vehiculo v5 = new Vehiculo("fff");

        Collections.addAll(parqueadero.getListaVehiculos(), v1,v2,v3,v4);

        Vehiculo[][] vehiculos = parqueadero.obtenerMatrizCondicionPunto7();

        System.out.println(vehiculos);

    }
}
