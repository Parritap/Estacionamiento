package model;

import Exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

public class Parqueadero {

    private String nombre;
    private Puesto[][] listaPuestos;
    private ArrayList<RegistroParqueo> listaRegistroParqueo;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Propietario> listaPropietarios;

    //Constructores

    /**
     * Constructor con todos los parámetros;
     *
     * @param nombre
     * @param listaPuestos
     * @param listaRegistroParqueo
     * @param listaVehiculos
     * @param listaPropietario
     */
    public Parqueadero(String nombre, Puesto[][] listaPuestos, ArrayList<RegistroParqueo> listaRegistroParqueo, ArrayList<Vehiculo> listaVehiculos, ArrayList<Propietario> listaPropietario) {
        this.nombre = nombre;
        this.listaPuestos = listaPuestos;
        this.listaRegistroParqueo = listaRegistroParqueo;
        this.listaVehiculos = listaVehiculos;
        this.listaPropietarios = listaPropietario;
    }

    /**
     * Constructor únicamente con atributo nombre
     *
     * @param nombre Nombre del parqueadero.
     */
    public Parqueadero(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Constructor vacío
     */
    public Parqueadero() {
    }

    //Getters and Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Puesto[][] getListaPuestos() {
        return listaPuestos;
    }

    public void setListaPuestos(Puesto[][] listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    public ArrayList<RegistroParqueo> getListaRegistroParqueadero() {
        return listaRegistroParqueo;
    }

    public void setListaRegistroParqueadero(ArrayList<RegistroParqueo> listaRegistroParqueo) {
        this.listaRegistroParqueo = listaRegistroParqueo;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public void setListaVehiculos(ArrayList<Vehiculo> listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
    }

    public ArrayList<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }

    public void setListaPropietarios(ArrayList<Propietario> listaPropietarios) {
        this.listaPropietarios = listaPropietarios;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parqueadero that = (Parqueadero) o;

        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (!Arrays.deepEquals(listaPuestos, that.listaPuestos)) return false;
        if (listaRegistroParqueo != null ? !listaRegistroParqueo.equals(that.listaRegistroParqueo) : that.listaRegistroParqueo != null)
            return false;
        if (listaVehiculos != null ? !listaVehiculos.equals(that.listaVehiculos) : that.listaVehiculos != null)
            return false;
        return listaPropietarios != null ? listaPropietarios.equals(that.listaPropietarios) : that.listaPropietarios == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + Arrays.deepHashCode(listaPuestos);
        result = 31 * result + (listaRegistroParqueo != null ? listaRegistroParqueo.hashCode() : 0);
        result = 31 * result + (listaVehiculos != null ? listaVehiculos.hashCode() : 0);
        result = 31 * result + (listaPropietarios != null ? listaPropietarios.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parqueadero{" +
                "nombre='" + nombre + '\'' +
                ", listaPuestos=" + Arrays.toString(listaPuestos) +
                ", listaRegistroParqueadero=" + listaRegistroParqueo +
                ", listaVehiculos=" + listaVehiculos +
                ", listaPropietario=" + listaPropietarios +
                '}';
    }

    //  PUNTO 1.--------------------------------------------------------------------------------

    public Puesto[][] generarPuestos(int cantidadColumnas) throws Exception {

        Puesto[][] matrizPuestos = new Puesto[2][cantidadColumnas];

        if (cantidadColumnas < 1)
            throw new Exception("La cantidad de columnas no puede ser menor que 1");


        for (int i = 0; i < matrizPuestos.length; i++) {

            TipoVehiculo tipoVehiculo;
            if (i == 0) { //Si estamos en la primera fila, entonces a sus puestos se les asigna el tipo de Vehiculo carro
                tipoVehiculo = TipoVehiculo.MOTO;
            } else { //De lo contario se les asigna el tipo de vehiculo Moto.
                tipoVehiculo = TipoVehiculo.CARRO;
            }


            //Instanciamos los puestos del parqueadero, cosa que no haya uno solo nulo.
            for (int j = 0; j < matrizPuestos[i].length; j++) {
                //Se asigna el número al puesto, como tambien su parqueadero y el tipo de vehículo que va a alojar que declaramos anteriormente.
                matrizPuestos[i][j] = new Puesto("" + i + j + "", this, tipoVehiculo); //Notese que concatenemos en un String los index 'i' y 'j' como números para hacer la tarea de buscar un puesto mucho más fácil.
            }
        }

        return matrizPuestos;
    }


    /**
     * Método que genera la matriz de puestos.
     * Este método instancia todos los puestos pero unicamente asigna valores a dos atributos
     * específicos, Puesto.num y Puesto.parqueadero.
     *
     * @param columnas Cantidad de colmnas.
     * @param filas    Cantidad de filas.
     * @return Una matriz de puestos con numero asignadas al parqueadero actual.
     */
    public Puesto[][] generarPuestosV2(int columnas, int filas) {

        //Declaramos el tamaño de los puestos.
        Puesto[][] puestos = new Puesto[columnas][filas];

        //Instanciamos todos los puestos para que el método no lance un ArrayIndexOutOfBoundsException.
        //Generamos el número de cada uno, que no será más que la posición que ocupa dentro de la matriz.
        for (int i = 0; i < puestos.length; i++) {
            for (int j = 0; j < puestos[i].length; j++) {

                puestos[i][j] = new Puesto("" + i + j + "", this);
            }
        }

        //Ahora que ya tenemos los Puestos instanciados, ya podemos recorrer el arreglo libremente.
        for (int i = 0; i < puestos.length; i++) {

            //Haremos que los Carros sean los impares
            if (i % 2 == 1) {

                for (int j = 0; j < puestos[i].length; j++) {
                    puestos[i][j].setTipoVehiculo(TipoVehiculo.CARRO);
                }

                //Haremos que las motos sean las pares.
            } else {
                for (int j = 0; j < puestos[i].length; j++) {
                    puestos[i][j].setTipoVehiculo(TipoVehiculo.MOTO);
                }
            }
        }

        return puestos;

    }


    // PUNTO 2
    public String crearVehiculo(Vehiculo nuevoVehiculo, String identificacionPropietario) throws VehiculoException {
        String resultado = "";
        Vehiculo vehiculoEncontrado = null;
        Propietario propietario = null;
        // verificar si existe el vehiculo
        vehiculoEncontrado = buscarVehiculo(nuevoVehiculo.getPlaca()); //Primero buscamos si el vehiculo ya existe.
        if (vehiculoEncontrado == null) { //De ser null, significa que el vehículo no fue encontrado, y podemos pasara crearlo.
            // verificar si existe el propietario
            propietario = obtenerPropietario(identificacionPropietario);
            if (propietario == null) {
                throw new VehiculoException("NO existe un propietario para este vehiculo");
            } else {
                listaVehiculos.add(nuevoVehiculo);
                resultado = "Vehiculo Registrado";
            }
        } else {
            throw new VehiculoException("Este vehiculo ya se encunttra registrado");
        }
        return resultado;
    }


    public double obtenerSumaTotalesFila(int index) {

        double sumaTotal = 0;


        for (RegistroParqueo registro : listaRegistroParqueo) {
            if (registro.getPuesto().getNum().charAt(0) == index) {
                sumaTotal += registro.getTotal();
            }
        }
        return sumaTotal;
    }


    private Propietario obtenerPropietario(String identificacionPropietario) {

        for (Propietario propietario : listaPropietarios) {
            if (propietario != null && propietario.getIdentificacion().equals(identificacionPropietario)) {
                return propietario;
            }
        }
        return null;
    }

    private Vehiculo buscarVehiculo(String placa) {

        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo != null && vehiculo.getPlaca().equals(placa)) {
                return vehiculo;
            }
        }

        return null;
    }

//	1.0 Obtener una matriz con las siguientes condiciones: dos filas una
//	fila para carros y otra para motos : en la primera fila se ubican
//	los veh?culos de tipo carro que han parqueado m?s de dos veces
//	en el parqueadero, en la segunda fila los veh?culos de tipo moto
//	que han parqueado m?s de tres veces en el parqueadero.


    //Realizar un método que retorne la suma de los valores cobrados(Recaudo total fila)
    //en los Registros de una fila dada por el usuario correspondiente a la zona de parqueo.


    //obtener un arrelo de vehiculos que sean de un modelo dado por el usuario


    // obtener los propietarios de un un vehiculo que tenga una placa que termine en impar;


    public String eliminarVehiculo(String placa) throws VehiculoException {

        String mensaje = "";

        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlaca().equalsIgnoreCase(placa)) {
                listaVehiculos.remove(vehiculo);
                mensaje = "Vehiculo Eliminado";
                break;
            }
        }

        if (mensaje.equalsIgnoreCase("")) {
            throw new VehiculoException("Vehiculo no se encuentra registardo");
        }

        return mensaje;


    }

    public String actualizarVehiculo(String placaAnterior, String placaNueva, String modeloNuevo,
                                     TipoVehiculo tipoNuevo, String propietarioNuevo) throws VehiculoException {


        Vehiculo vehiculo = buscarVehiculo(placaAnterior);

        if (vehiculo != null) {
            vehiculo.setPlaca(placaNueva);
            vehiculo.setModelo(modeloNuevo);
            vehiculo.setTipoVehiculo(tipoNuevo);

            Propietario propietario = obtenerPropietario(propietarioNuevo);
            if (propietario != null) {
                vehiculo.setPropietario(propietario);
            } else {
                throw new VehiculoException("No hay propietario");
            }
        } else {
            throw new VehiculoException("No hay vehiculo");
        }
        return "OK";
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    // PUNTO 5.
    //5. Realizar un método que retorne la suma de los
    //valores cobrados(Recaudo total fila) en los Registros
    //de una fila dada por el usuario correspondiente a la zona de parqueo.

    public double obtenerRecaudoTotal(int fila) throws Exception {

        double total = 0;

        if (fila < 0 || fila >= listaPuestos.length) {
            throw new RuntimeException("La fila no es valida");
        }

        for (int columna = 0; columna < listaPuestos[fila].length; columna++) {
            total += obtenerRegistrosFila(listaPuestos[fila][columna]);
        }

        return total;

    }

    private double obtenerRegistrosFila(Puesto puesto) {
        double total = 0;

        for (int i = 0; i < listaRegistroParqueo.size(); i++) {
            RegistroParqueo registroParqueo = listaRegistroParqueo.get(i);
            Puesto puestoParqueo = registroParqueo.getPuesto();
            if (puestoParqueo == puesto) {
                total += registroParqueo.getTotal();
            }
        }
        return total;
    }


    //6. obtener los propietarios que han parqueado en la diagonal principal

    public ArrayList<Propietario> obtenerPropietariosDiagonal() {
        ArrayList<Propietario> listaPropietarios = new ArrayList<>();

        for (int i = 0; i < listaPuestos.length; i++) {
            for (int j = 0; j < listaPuestos.length; j++) {
                if (i == j) {
                    Puesto puesto = listaPuestos[i][j];
                    listaPropietarios.addAll(obtenerPropietariosPuesto(puesto));
                }
            }
        }
        return listaPropietarios;
    }

    private ArrayList<Propietario> obtenerPropietariosPuesto(Puesto puesto) {
        ArrayList<Propietario> listaPropietarios = new ArrayList<>();

        for (int i = 0; i < listaRegistroParqueo.size(); i++) {
            RegistroParqueo registroParqueo = listaRegistroParqueo.get(i);
            Puesto puestoParqueo = registroParqueo.getPuesto();
            if (puestoParqueo == puesto) {
                listaPropietarios.add(registroParqueo.obtenerPropietario());

            }
        }

        return listaPropietarios;
    }


    //PUNTO 8
/*
   Obtener una matriz con las siguientes condiciones: dos filas una fila para carros y otra para motos :
   en la primera fila se ubican los vehículos de tipo carro que han parqueado más de dos veces en el parqueadero,
   en la segunda fila los vehículos de tipo moto que han parqueado más de tres veces en el parqueadero.
 */

    private Vehiculo[][] obtenerMatrizCondicion7() {

        Vehiculo[][] matrix = new Vehiculo[2][];

        Vehiculo[] arregloCarros = new Vehiculo[obtenerNumCarrosCond7()];
        Vehiculo[] arregloMotos = new Vehiculo[obtenerNumMotosCond7()];


        return matrix;
    }

    private int obtenerNumMotosCond7() {


        return 0;
    }


    /**
     * Método que retornar la cantidad de carros que han parqueado más de dos veces en el parquedero.
     *
     * @return cantidad de carros que han parqueado más de dos veces en el parqueadero.
     */
    private int obtenerNumCarrosCond7() {

        ArrayList<Vehiculo> listaRepetidos = new ArrayList<>(); //La idea es al final sacarle el .size() a esta lista, eso es lo que vamos a retornar

        for (int i = 0; i < listaRegistroParqueo.size(); i++) {
            Vehiculo auxA = listaRegistroParqueo.get(i).getVehiculo();

            for (int j = 0; j < listaRegistroParqueo.size(); j++) {
                Vehiculo auxB = listaRegistroParqueo.get(i).getVehiculo();

                if (j != i) {
                    if (auxA != null && auxB != null) {
                        if (auxA.getPlaca() != null && auxB.getPlaca() != null) {

                            if (auxA.equals(auxB) && !listaRepetidos.contains(auxA)) {
                                listaRepetidos.add(auxA);
                            }
                        }
                    }
                }
            }
        }
        return listaRepetidos.size();
    }

    ////////////////////////////////////    QUIZ ///////////////////////////////////////////
    /*quiz: 10-05-2022
     * obtener una matriz de vehiculos con las siguientes condiciones
     * - una fila con los vehiculos de tipo carroo que tengan un modelo superiro a 2000
     * - una fila con los vehiculos de tipo moto que el propietario sea robinson
     */

    public Vehiculo[][] obtenerMatriz() {
        Vehiculo[][] matriz = new Vehiculo[2][];

        Vehiculo[] fila1 = null;
        Vehiculo[] fila2 = null;

        fila1 = obtenerVehiculoModelo(2000);
        fila2 = obtenerVehiculosPropietario("Robinson");

        matriz[0] = fila1;
        matriz[1] = fila2;

        return matriz;
    }

    private Vehiculo[] obtenerVehiculosPropietario(String string) {


        return null;
    }

    private Vehiculo[] obtenerVehiculoModelo(int modelo) {

        Vehiculo[] vehiculo = new Vehiculo[obtenerCantidadVehiculosModelo(modelo)];
        int cont = 0;
        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo vehiculoAux = listaVehiculos.get(i);
            if (vehiculoAux.verificarVehiculo(TipoVehiculo.CARRO, modelo)) {
                vehiculo[cont] = vehiculoAux;
                cont++;
            }
        }

        return vehiculo;
    }

    private int obtenerCantidadVehiculosModelo(int modelo) {
        int cont = 0;

        for (int i = 0; i < listaVehiculos.size(); i++) {
            Vehiculo vehiculo = listaVehiculos.get(i);
            if (vehiculo.verificarVehiculo(TipoVehiculo.CARRO, modelo)) {
                cont++;
            }
        }
        return cont;
    }

    

}
