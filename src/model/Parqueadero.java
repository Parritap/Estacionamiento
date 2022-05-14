package model;

import Exceptions.*;

import java.util.ArrayList;
import java.util.Arrays;

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

    public Parqueadero(String nombre, ArrayList<Vehiculo> listaVehiculos) {
        this.nombre = nombre;
        this.listaVehiculos = listaVehiculos;
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
                matrizPuestos[i][j] = new Puesto("" + i + j + "", this, tipoVehiculo);
                //Notese que concatenemos en un String los index 'i' y 'j' como números para hacer la tarea de buscar un puesto mucho más fácil.
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
    ////////////////////////////////////////////////                    ///////////////////////////////////////////
    ///////////////////////////////////////////////         TALLER      ///////////////////////////////////////////
    //////////////////////////////////////////////                     ////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //PUNTO 5 TALLER.
    //5. Realizar un método que retorne la suma de los
    //valores cobrados(Recaudo total FILA) en los Registros
    //de una fila dada por el usuario correspondiente a la zona de parqueo.

    /**
     * Método que retorna la suma de los registros que están relacionados con la fila indicada en el argumento.
     *
     * @param fila int que indica la fila de interés.
     * @return Double que indica el total recaudado por todas las filas
     * @throws ArrayIndexOutOfBoundsException Si la fila indicada no existe dentro la listaPuestos.
     */
    public double obtenerSumaRecaudoFila(int fila) throws ArrayIndexOutOfBoundsException {

        double total = 0;

        if (fila < 0 || fila >= listaPuestos.length)
            throw new ArrayIndexOutOfBoundsException("La fila solicitada no es valida");

        for (RegistroParqueo regis : listaRegistroParqueo
        ) {

            if (regis != null) {

                Puesto auxPuesto = regis.getPuesto();

                if (auxPuesto != null && auxPuesto.getNum() != null) {

                    String numPuesto = auxPuesto.getNum();

                    //Recordar que el String.valueOf(int) retorna el int ingresado como un String.
                    if (String.valueOf(fila).charAt(0) == numPuesto.charAt(0))
                        total += regis.getTotal();
                }
            }

        }

        return total;
    }


    //6. obtener los propietarios que han parqueado en la diagonal principal

    /**
     * Método que retorna una lista con los propietarios que han estado en las diagonales de la listaPuestos.
     *
     * @return ArrayList con Propietarios que cumplan la condición indicada.
     */
    public ArrayList<Propietario> obtenerPropietariosDiagonal() {
        ArrayList<Propietario> listaPropietarios = new ArrayList<>();

        if (listaPuestos == null)
            throw new NullPointerException("La lista de Puestos es nula");

        for (int i = 0; i < listaPuestos.length; i++) {
            for (int j = 0; j < listaPuestos.length; j++) {
                if (i == j) {

                    if (listaPuestos[i][j] == null)
                        continue; //Esto es, si el puesto en la posición [i][j] == null, entonces saltar hasta la próxima iteración de j.

                    Puesto puesto = listaPuestos[i][j];
                    listaPropietarios.addAll(obtenerPropietariosPuesto(puesto));
                }
            }
        }
        return listaPropietarios;
    }


    /**
     * Método que retorna una lista con los todos los propietarios que han pasado por el puesto indicado en el argumento.
     *
     * @param puestoABuscar Puesto que se busca en la lista de registros del parqueadero.
     * @return ArrayList con todos los Propiestarios que han estado en el puesto indicado
     */
    private ArrayList<Propietario> obtenerPropietariosPuesto(Puesto puestoABuscar) {
        ArrayList<Propietario> listaPropietarios = new ArrayList<>();

        for (int i = 0; i < listaRegistroParqueo.size(); i++) {
            RegistroParqueo registroParqueo = listaRegistroParqueo.get(i);
            Puesto puestoParqueo = registroParqueo.getPuesto();
            if (puestoParqueo == puestoABuscar) {

                Propietario auxProp = registroParqueo.obtenerPropietario();

                if (!listaPropietarios.contains(auxProp)) //Esto verifica que la lista NO contenga ya el propietario buscado.
                    listaPropietarios.add(auxProp);
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


    /**
     * Método que retorna una matriz de dos filas. En la primera van los carros que han parqueado más de 2 veces.
     * En la segunda van las motos que han parqueado más de 3 veces.
     *
     * @return Matriz con los vehiculos que cumplen la condición.
     */
    public Vehiculo[][] obtenerMatrizPunto8() {

        Vehiculo[][] matrix = new Vehiculo[2][];

        matrix[0] = toArray(obtenerListaVehiculoCondicion8(TipoVehiculo.CARRO, 3)); //Ojo, en vez de 2 puse 3 por la naturaleza del método haParqueadoN_Veces.
        matrix[1] = toArray(obtenerListaVehiculoCondicion8(TipoVehiculo.MOTO, 4)); // Lo mismo va para esta línea de aquí.

        return matrix;
    }


    /**
     * Método que retorna una lista con los vehiculos del tipo indicado que hayan parqueado al menos i veces.
     *
     * @param tipoVehiculo Tipo de vehiculo a buscar
     * @param i            Cantidad de veces que el vehiculo debe haber parqueado como minimo.
     * @return Lista con los vehiculos que cumplan la condición.
     */
    private ArrayList<Vehiculo> obtenerListaVehiculoCondicion8(TipoVehiculo tipoVehiculo, int i) {

        ArrayList<Vehiculo> lista = new ArrayList<>();

        if (listaVehiculos == null)
            return lista; //Esto retorna una lista vacía (NO NULA) en caso de que listaVehiculos sea nula.

        for (Vehiculo v : listaVehiculos) {
            if (v != null && v.getTipoVehiculo() == tipoVehiculo && haParqueadoN_Veces(v, i) && !listaVehiculos.contains(v))
                lista.add(v);
        }
        return lista;
    }

    /**
     * Método que evalúa si el vehículo indicado en el argumento ha parqueado al menos i veces.
     *
     * @param v
     * @param i
     * @return
     */
    private boolean haParqueadoN_Veces(Vehiculo v, int i) {

        if (listaRegistroParqueo == null)
            return false; //Rompe el método para evitar excepciones.

        int contador = 0;
        for (RegistroParqueo regis : listaRegistroParqueo) {

            if (regis != null && regis.getVehiculo() != null && regis.getVehiculo().equals(v))
                contador++;

            if (contador == i)
                return true;
        }
        return false;
    }


    //Punto 9
    /*
       Devolver un listado ordenado con los nombres de los Propietarios de los vehículos que tienen modelo
       superior al indicado por el usuario.
     */


    /**
     * Método que retorna una lista con los nombres de los propietarios que poseen un auto cuyo modelo es mayor
     * al indicado en el argumento.
     *
     * @param modelo Modelo de carro.
     * @return
     */
    public ArrayList<String> obtenerListaNombresPunto9(String modelo) {

        ArrayList<String> lista = new ArrayList<>();
        for (Vehiculo v : listaVehiculos) {

            if (v != null && v.getModelo() != null && v.getPropietario() != null && v.getPropietario().getNombre() != null) {

                if (v.getModelo().compareTo(modelo) > 0 && !lista.contains(v.getPropietario().getNombre()))
                    lista.add(v.getPropietario().getNombre());
            }
        }
        return lista;
    }


    //Punto 10
    /*
     Devolver los propietarios de los vehículos (que están en este momento en el parqueadero) cuyas placas
     tienen dos vocales seguidas y dos números repetidos.
     */
    public ArrayList<Propietario> obtenerPropietariosPunto10() {
        ArrayList<Propietario> lista = new ArrayList<>();

        for (Puesto[] filaPuestos : listaPuestos) {

            for (Puesto p : filaPuestos) {

                if (p != null && p.getEstado().equals("ocupado")) {

                    for (RegistroParqueo regis : listaRegistroParqueo) {

                        if (regis != null && regis.getPuesto() != null && regis.getPuesto() == p) {

                            if (regis.getVehiculo() != null && placaCumpleCondicion(regis.getVehiculo().getPlaca())) {

                                if (regis.getVehiculo().getPropietario() != null) {

                                    if (!lista.contains(regis.getVehiculo().getPropietario()))
                                        lista.add(regis.getVehiculo().getPropietario());
                                }
                            }
                        }
                    }
                }
            }
        }
        return lista;
    }

    private boolean placaCumpleCondicion(String placa) {
        if (placa == null)
            return false;

        if (tieneNumerosRepetidos(placa) && tieneVocalesSeguidas(placa))
            return true;

        return true;
    }

    private boolean tieneVocalesSeguidas(String str) {

        char[] array = str.toCharArray();

        for (int i = 0; i < array.length - 1; i++) {
            if (Utils.esVocal(array[i]) && Utils.esVocal(array[i + 1]))
                return true;
        }
        return true;
    }

    private boolean tieneNumerosRepetidos(String placa) {
        if (placa == null)
            return false;

        char[] array = placa.toCharArray();

        Arrays.sort(array);


        for (int i = 0; i < array.length - 1; i++) {
            if (Utils.esDigito(array[i]) && Utils.esDigito(array[i + 1]))
                return true;

        }
        return false;
    }


    //PUNTO 11
/*
    Devolver la cantidad de registros que tiene un puesto dado(parametro puesto), usar el método equals().
 */

    /**
     * Método que obtiene la cantidad de registros que están relacionados con cierto puesto
     *
     * @param p
     * @return
     */
    public int obtenerCantidadRegisPunto11(Puesto p) {

        if (p == null)
            return 0;

        int contador = 0;

        for (RegistroParqueo regis : listaRegistroParqueo) {

            if (regis != null && regis.getPuesto() != null) {

                if (regis.getPuesto().equals(p))
                    contador++;
            }
        }
        return contador;
    }


    //PUNTO 12
    /*
     Determinar si en la matriz de puestos existen por lo menos dos vehículos con placas que terminan en número par
     consecutivos en una misma fila, o en la misma columna.
     */

    public boolean verificarCondicionPunto12() {

        int contador = 0;

        for (int i = 0; i < listaPuestos.length-1; i++) {
            for (int j = 0; j < listaPuestos[i].length -1; j++) {

                Puesto puestoA =listaPuestos[i][j];
                Puesto puestoContiguo =listaPuestos[i][j+1];
                Puesto puestoInferior =listaPuestos[i+1][j];

                if(puestoA!=null){

                    if(puestoContiguo!=null){
                        if (placasVehiculosTerminanPar(puestoA, puestoContiguo))
                            return true;
                    }

                    if(puestoInferior!=null){
                        if (placasVehiculosTerminanPar(puestoA, puestoContiguo))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Método que revisa si los vehiculos de los puestos pasados en el parámetro terminan en un número par.
     * @return True si los vehículos relacionados con esos puestos tiene placas cuyo último digito sea par.
     */
    private boolean placasVehiculosTerminanPar(Puesto pA, Puesto pB) {

        if (pA == null || pB == null)
            return false;

        String placaA = null;
        String placaB = null;

        for (RegistroParqueo regis: listaRegistroParqueo) {
            if(regis!=null && regis.getPuesto().equals(pA) && regis.getVehiculo()!=null && regis.getVehiculo().getPlaca()!=null){
                placaA = regis.getVehiculo().getPlaca();
            }else{
                return false;
            }
        }

        for (RegistroParqueo regis: listaRegistroParqueo) {
            if(regis!=null && regis.getPuesto().equals(pB) && regis.getVehiculo()!=null && regis.getVehiculo().getPlaca()!=null){
                placaB = regis.getVehiculo().getPlaca();
            }else{
                return false;
            }
        }
        boolean cumplePlacaA = Utils.esPar(placaA.charAt(placaA.length()-1));
        boolean cumplePlacaB = Utils.esPar(placaB.charAt(placaB.length()-1));

        return (cumplePlacaA && cumplePlacaB);
    }


    //PUNTO 12



    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////


    ///Parcial Pramación

    public boolean existeVehiculoEnLista(ArrayList<Vehiculo> lista, Vehiculo vehiculo) throws Exception {

        if (vehiculo == null || lista == null)
            throw new Exception("El vehiculo o la lista pasada es nula");


        for (int i = 0; i < lista.size(); i++) {

            if (vehiculo.equals(lista.get(i)))
                return true;
        }


        return false;
    }


    //PARCIAL PUNTO 1: DADA MI EQUIVOCACIÓN, HICE EL PRIMER PUNTO DE UN PARCIAL DIFERENTE, PERO LOS DEMÁS 3 PUNTOS SON DEL MISMO PARCIAL.
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

            if (listaRegistroParqueo != null && registro != null && registro.getFecha() != null) {

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

        for (int i = 0; i == 0 || i == listaPuestos.length - 1; i++) {  //Se me olvidó poner un auxiliar para que no quedara tan largo esto.
            for (int j = 0; j == 0 || j == listaPuestos[i].length - 1; j++) {

                if (listaPuestos[i][j] != null && listaPuestos[i][j].getEstado() != null && listaPuestos[i][j].getEstado().equals(estadoPuesto)) {  // Que según el enunciado, el estado dería ser "ocupado".

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
            if (v != null && v.getPropietario().getNombre() != null) {
                String nombreProp = v.getPropietario().getNombre();

                if (esCapicua(nombreProp) && v.getTipoVehiculo() == tipoVehiculo && !listaPropCondicion.contains(v.getPropietario()))
                    listaPropCondicion.add(v.getPropietario());

            }
        }

        return Propietario.toArray(listaPropCondicion);
    }


    private Vehiculo[] toArray(ArrayList<Vehiculo> lista) {

        Vehiculo[] array = new Vehiculo[lista.size()];

        for (int i = 0; i < array.length; i++) {

            array[i] = lista.get(i);
        }
        return array;
    }

    private boolean esCapicua(String nombreProp) {

        char[] charArray = nombreProp.toCharArray();

        boolean condicion = true;
        for (int i = 0, j = charArray.length - 1; i < charArray.length / 2; i++, j--) {

            if (charArray[i] != charArray[j]) {
                condicion = false;
                break;
            }
        }
        return condicion;
    }


    //PARCIAL PUNTO 4
    public ArrayList<Propietario> obtenerPropietarioModelo() {


        ArrayList<Propietario> listaPropietarios = new ArrayList<>();

        for (int i = 0; i < this.listaVehiculos.size(); i++) {
            Vehiculo vehiculo = listaVehiculos.get(i);
            if (vehiculo.verificarModeloPropietario()) {
                listaPropietarios.add(vehiculo.getPropietario());
            }

        }
        return listaPropietarios;

    }


}
