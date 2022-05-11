package model;

import Exceptions.StringException;

import java.util.ArrayList;
import java.util.Arrays;

public class Parqueadero {

    private String nombre;
    private Puesto[][] listaPuestos;
    private ArrayList<RegistroParqueo> listaRegistroParqueo;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<Propietario> listaPropietario;

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
        this.listaPropietario = listaPropietario;
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

    public ArrayList<Propietario> getListaPropietario() {
        return listaPropietario;
    }

    public void setListaPropietario(ArrayList<Propietario> listaPropietario) {
        this.listaPropietario = listaPropietario;
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
        return listaPropietario != null ? listaPropietario.equals(that.listaPropietario) : that.listaPropietario == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + Arrays.deepHashCode(listaPuestos);
        result = 31 * result + (listaRegistroParqueo != null ? listaRegistroParqueo.hashCode() : 0);
        result = 31 * result + (listaVehiculos != null ? listaVehiculos.hashCode() : 0);
        result = 31 * result + (listaPropietario != null ? listaPropietario.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Parqueadero{" +
                "nombre='" + nombre + '\'' +
                ", listaPuestos=" + Arrays.toString(listaPuestos) +
                ", listaRegistroParqueadero=" + listaRegistroParqueo +
                ", listaVehiculos=" + listaVehiculos +
                ", listaPropietario=" + listaPropietario +
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
    public String crearVehiculo(Vehiculo nuevoVehiculo,String identificacionPropietario)throws VehiculoException {
        String resultado 			= "";
        Vehiculo vehiculoEncontrado = null;
        Propietario propietario 	= null;
        // verificar si existe el vehiculo
        vehiculoEncontrado = buscarVehiculo(nuevoVehiculo.getPlaca()); //Primero buscamos si el vehiculo ya existe.
        if(vehiculoEncontrado == null){ //De ser null, significa que el vehículo no fue encontrado, y podemos pasara crearlo.
            // verificar si existe el propietario
            propietario = obtenerPropietario(identificacionPropietario);
            if(propietario == null){
                throw new VehiculoException("NO existe un propietario para este vehiculo");
            }
            else{
                listaVehiculos.add(nuevoVehiculo);
                resultado = "Vehiculo Registrado";
            }
        }else{
            throw new VehiculoException("Este vehiculo ya se encunttra registrado");
        }
        return resultado;
    }

    public Vehiculo buscarVehiculo(String placa) {

        for (Vehiculo vehiculo : listaVehiculos) {
            if (vehiculo.getPlaca() != null && vehiculo.getPlaca().equals(placa))
                return vehiculo;
        }
        return null;
    }

    public void eliminarVehiculo(String placa) {

        boolean bool = false; //Este bool se utiliza para romper el ciclo una vez hayamos encontrado el vehículo a eliminar.

        for (int i = 0; i < listaVehiculos.size() && !bool; i++) {
            if (listaVehiculos.get(i).getPlaca().equals(placa)) {
                listaVehiculos.remove(i);
                bool = true;
            }
        }
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
}
