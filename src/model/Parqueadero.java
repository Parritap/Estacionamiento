package model;

import Exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Parqueadero {

    private String nombre;
    private Puesto[][] listaPuestos;
    private ArrayList<RegistroParqueo> listaRegistroParqueo;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Propietario> listaPropietarios;

    //Constructores

    /**
     * Constructor con todos los par�metros;
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
     * Constructor �nicamente con atributo nombre
     *
     * @param nombre Nombre del parqueadero.
     */
    public Parqueadero(String nombre) {
        this.nombre = nombre;
    }

    public Parqueadero(String nombre, ArrayList<Vehiculo> listaVehiculos) {
        this.nombre = nombre;
        this.listaVehiculos = listaVehiculos;
    }

    /**
     * Constructor vac�o
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
                //Se asigna el n�mero al puesto, como tambien su parqueadero y el tipo de veh�culo que va a alojar que declaramos anteriormente.
                matrizPuestos[i][j] = new Puesto("" + i + j + "", this, tipoVehiculo); //Notese que concatenemos en un String los index 'i' y 'j' como n�meros para hacer la tarea de buscar un puesto mucho m�s f�cil.
            }
        }

        return matrizPuestos;
    }


    /**
     * M�todo que genera la matriz de puestos.
     * Este m�todo instancia todos los puestos pero unicamente asigna valores a dos atributos
     * espec�ficos, Puesto.num y Puesto.parqueadero.
     *
     * @param columnas Cantidad de colmnas.
     * @param filas    Cantidad de filas.
     * @return Una matriz de puestos con numero asignadas al parqueadero actual.
     */
    public Puesto[][] generarPuestosV2(int columnas, int filas) {

        //Declaramos el tama�o de los puestos.
        Puesto[][] puestos = new Puesto[columnas][filas];

        //Instanciamos todos los puestos para que el m�todo no lance un ArrayIndexOutOfBoundsException.
        //Generamos el n�mero de cada uno, que no ser� m�s que la posici�n que ocupa dentro de la matriz.
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



    public String crearVehiculo(Vehiculo nuevoVehiculo, String identificacionPropietario) throws VehiculoException {
        String resultado = "";
        Vehiculo vehiculoEncontrado = null;
        Propietario propietario = null;
        // verificar si existe el vehiculo
        vehiculoEncontrado = buscarVehiculo(nuevoVehiculo.getPlaca()); //Primero buscamos si el vehiculo ya existe.
        if (vehiculoEncontrado == null) { //De ser null, significa que el veh�culo no fue encontrado, y podemos pasara crearlo.
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


    //Realizar un m�todo que retorne la suma de los valores cobrados(Recaudo total fila)
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



    //5. Realizar un m�todo que retorne la suma de los
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
   en la primera fila se ubican los veh�culos de tipo carro que han parqueado m�s de dos veces en el parqueadero,
   en la segunda fila los veh�culos de tipo moto que han parqueado m�s de tres veces en el parqueadero.
 */

    public Vehiculo[][] obtenerMatrizCondicionPunto7() throws Exception {

        Vehiculo[][] matrix = new Vehiculo[2][];

        Vehiculo[] arregloCarros = (Vehiculo[]) obtenerListaCarrosCond8().toArray();
        Vehiculo[] arregloMotos = (Vehiculo[]) obtenerListaMotosCond8().toArray();

        matrix[0] = arregloCarros;
        matrix[1] = arregloMotos;

        return matrix;
    }

    private ArrayList<Vehiculo> obtenerListaCarrosCond8() {

        ArrayList<Vehiculo> listaCarros = new ArrayList<>();

        for (Vehiculo vehiculo :
                obtenerListaVehiculosCondicion()) {

            if (vehiculo.getTipoVehiculo() == TipoVehiculo.CARRO) {
                listaCarros.add(vehiculo);
            }
        }

        return listaCarros;
    }

    private ArrayList<Vehiculo> obtenerListaMotosCond8() {

        ArrayList<Vehiculo> listaMotos = new ArrayList<>();

        for (Vehiculo vehiculo :
                obtenerListaVehiculosCondicion()) {

            if (vehiculo.getTipoVehiculo() == TipoVehiculo.MOTO) {
                listaMotos.add(vehiculo);
            }
        }

        return listaMotos;

    }

    /**
     * M�todo que obtiene la lista
     *
     * @return
     */
    private ArrayList<Vehiculo> obtenerListaVehiculosCondicion() {

        int[] vehiculosRepetidos = new int[listaVehiculos.size()];

        for (RegistroParqueo registro :
                listaRegistroParqueo) {

            Vehiculo vehiculoRegistro = registro.getVehiculo();
            vehiculosRepetidos[listaVehiculos.indexOf(vehiculoRegistro)]++;

        }

        return filtrarVehiculos(vehiculosRepetidos);
    }

    private ArrayList<Vehiculo> filtrarVehiculos(int[] vehiculosRepetidos) {

        ArrayList<Vehiculo> listaVehiculosCondicion = new ArrayList<>();

        for (Vehiculo vehiculo :
                listaVehiculos) {

            if (vehiculo.getTipoVehiculo() == TipoVehiculo.CARRO && vehiculosRepetidos[listaVehiculos.indexOf(vehiculo)] > 2) {
                listaVehiculosCondicion.add(vehiculo);
            } else if (vehiculo.getTipoVehiculo() == TipoVehiculo.MOTO && vehiculosRepetidos[listaVehiculos.indexOf(vehiculo)] > 3) {
                listaVehiculosCondicion.add(vehiculo);
            }
        }

        return listaVehiculosCondicion;
    }

//   ////////////////////////////////////    QUIZ ///////////////////////////////////////////
//   /*quiz: 10-05-2022
//    * obtener una matriz de vehiculos con las siguientes condiciones
//    * - una fila con los vehiculos de tipo carroo que tengan un modelo superiro a 2000
//    * - una fila con los vehiculos de tipo moto que el propietario sea robinson
//    */

//   public Vehiculo[][] obtenerMatriz() {
//       Vehiculo[][] matriz = new Vehiculo[2][];

//       Vehiculo[] fila1 = null;
//       Vehiculo[] fila2 = null;

//       fila1 = obtenerVehiculoModelo(2000);
//       fila2 = obtenerVehiculosPropietario("Robinson");

//       matriz[0] = fila1;
//       matriz[1] = fila2;

//       return matriz;
//   }

//   private Vehiculo[] obtenerVehiculosPropietario(String string) {


//       return null;
//   }

//   private Vehiculo[] obtenerVehiculoModelo(int modelo) {

//       Vehiculo[] vehiculo = new Vehiculo[obtenerCantidadVehiculosModelo(modelo)];
//       int cont = 0;
//       for (int i = 0; i < listaVehiculos.size(); i++) {
//           Vehiculo vehiculoAux = listaVehiculos.get(i);
//           if (vehiculoAux.verificarVehiculo(TipoVehiculo.CARRO, modelo)) {
//               vehiculo[cont] = vehiculoAux;
//               cont++;
//           }
//       }

//       return vehiculo;
//   }

//   private int obtenerCantidadVehiculosModelo(int modelo) {
//       int cont = 0;

//       for (int i = 0; i < listaVehiculos.size(); i++) {
//           Vehiculo vehiculo = listaVehiculos.get(i);
//           if (vehiculo.verificarVehiculo(TipoVehiculo.CARRO, modelo)) {
//               cont++;
//           }
//       }
//       return cont;
//   }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    ///Parcial Pramaci�n

    public boolean existeVehiculoEnLista(ArrayList<Vehiculo> lista, Vehiculo vehiculo) throws Exception {

        if (vehiculo == null || lista == null)
            throw new Exception("El vehiculo o la lista pasada es nula");


        for (int i = 0; i < lista.size(); i++) {

            if (vehiculo.equals(lista.get(i)))
                return true;
        }


        return false;
    }


    //PARCIAL PUNTO 1: DADA MI EQUIVOCACI�N, HICE EL PRIMER PUNTO DE UN PARCIAL DIFERENTE, PERO LOS DEM�S 3 PUNTOS SON DEL MISMO PARCIAL.
    public Vehiculo[][] obtenerMatrizParcialPunto1() throws Exception {

        Vehiculo[][] matrix = new Vehiculo[2][];

        matrix[0] = (Vehiculo[]) generarMatrizVehiculoMatrizFechaYTotal(TipoVehiculo.MOTO, "06-06-22", 10000).toArray();
        matrix[1] = (Vehiculo[]) generarMatrizVehiculoNombreVocales().toArray();

        return matrix;
    }

    private ArrayList<Vehiculo> generarMatrizVehiculoNombreVocales() throws Exception {

        ArrayList<Vehiculo> listaCondicion = new ArrayList<Vehiculo>();

        for (Vehiculo v : listaVehiculos
        ) {

            if (v != null && v.getTipoVehiculo() == TipoVehiculo.CARRO && v.getPropietario() != null && v.getPropietario().getNombre() != null) {

                String nombProp = v.getPropietario().getNombre();
                if (tieneTresVocales(nombProp) && !existeVehiculoEnLista(listaCondicion, v))
                    listaCondicion.add(v);
            }

        }

        return listaCondicion;
    }

    private boolean tieneTresVocales(String nombProp) {

        char[] vocales = "aeiouAEIOU".toCharArray();
        ArrayList<Character> vocalesEncontradas = new ArrayList<>();

        for (int i = 0; i < nombProp.length(); i++) {

            for (char vocal : vocales) {

                if (nombProp.charAt(i) == vocal && !vocalesEncontradas.contains(vocal)) {
                    vocalesEncontradas.add(vocales[i]);
                }
            }
        }


        return vocalesEncontradas.size() >= 3;
    }

    private ArrayList<Vehiculo> generarMatrizVehiculoMatrizFechaYTotal(TipoVehiculo tipoVehiculo, String fecha, double totalParqueo) throws Exception {

        ArrayList<Vehiculo> listaCondicion = new ArrayList<Vehiculo>();

        for (RegistroParqueo registro : listaRegistroParqueo
        ) {

            if (listaRegistroParqueo != null && registro != null && registro.getFecha()!=null ) {

                String fechaRegis = registro.getFecha();
                double totalRegis = registro.getTotal();

                if (fechaRegis != null && fechaRegis.equals(fecha) && totalRegis > totalParqueo) {
                    Vehiculo auxVehiculo = registro.getVehiculo();

                    if (auxVehiculo != null && auxVehiculo.getTipoVehiculo() == tipoVehiculo && !existeVehiculoEnLista(listaCondicion, auxVehiculo)) {
                        listaCondicion.add(auxVehiculo);
                    }
                }
            }
        }

        return listaCondicion;
    }


    // PARCIAL PUNTO 2
    public ArrayList<Puesto> obtenerPuestosCondicionParcialPunto2(String estadoPuesto, TipoVehiculo tipoVehiculo) {

        ArrayList<Puesto> listaPuestosCondicion = new ArrayList<>();

        for (int i = 0; i == 0 || i == listaPuestos.length - 1; i++) {  //Se me olvid� poner un auxiliar para que no quedara tan largo esto.
            for (int j = 0; j == 0 || j == listaPuestos[i].length - 1; j++) {

                if (listaPuestos[i][j] != null && listaPuestos[i][j].getEstado() != null && listaPuestos[i][j].getEstado().equals(estadoPuesto)) {  // Que seg�n el enunciado, el estado der�a ser "ocupado".

                    if (listaPuestos[i][j].getTipoVehiculo() == tipoVehiculo && !listaPuestosCondicion.contains(listaPuestos[i][j]))
                        listaPuestosCondicion.add(listaPuestos[i][j]);

                }
            }
        }
        return listaPuestosCondicion;
    }


    //PARCIAL PUNTO 3
    public Propietario[] obtenerPropiertariosCondicionParcialPunto3(TipoVehiculo tipoVehiculo) {

        ArrayList<Propietario> listaPropCondicion = new ArrayList<>();

        for (Vehiculo v : listaVehiculos
        ) {
            if (v != null && v.getPropietario().getNombre()!=null){
                String nombreProp = v.getPropietario().getNombre();

                if (esCapicua(nombreProp) && v.getTipoVehiculo() == tipoVehiculo && !listaPropCondicion.contains(v.getPropietario()))
                    listaPropCondicion.add(v.getPropietario());

            }
        }

        return toArray(listaPropCondicion);
    }

    private Propietario[] toArray(ArrayList<Propietario> lista) {

        Propietario[] array = new Propietario[lista.size()];

        for (int i = 0; i < array.length ; i++) {

            array[i] = lista.get(i);
        }
        return  array;
    }

    private boolean esCapicua(String nombreProp) {

        char[] charArray = nombreProp.toCharArray();

        boolean condicion = true;
        for (int i = 0, j=charArray.length-1; i < charArray.length/2; i++, j--) {

            if (charArray[i] != charArray[j]) {
                condicion = false;
                break;
            }
        }
        return condicion;
    }


    //PARCIAL PUNTO 4
    public ArrayList<Propietario> obtenerPropietarioModelo(){


        ArrayList<Propietario> listaPropietarios = new ArrayList<>();

        for (int i = 0; i < this.listaVehiculos.size(); i++) {
            Vehiculo vehiculo = listaVehiculos.get(i);
            if(vehiculo.verificarModeloPropietario()){
                listaPropietarios.add(vehiculo.getPropietario());


            }

        }


        return listaPropietarios;

    }


}
