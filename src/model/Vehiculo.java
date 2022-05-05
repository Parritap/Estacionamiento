package model;

public class Vehiculo {

    private String placa;
    private String modelo;
    private Propietario propietario;
    private Parqueadero parqueadero;
    private Enum <TipoVehiculo> tipoVehiculo;


    //-----------------------------------Getters and Setters-----------------------------------------------------

    public Vehiculo(String placa, String modelo, Propietario propietario, Enum<TipoVehiculo> tipoVehiculo, Parqueadero parqueadero) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        this.parqueadero = parqueadero;
        this.tipoVehiculo = tipoVehiculo;
    }

    /**
     * Constructor vacio
     */
    public Vehiculo() {
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public Enum<TipoVehiculo> getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(Enum<TipoVehiculo> tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }


    //-------------------------------------------------------------------------------------------------------

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vehiculo vehiculo = (Vehiculo) o;

        if (placa != null ? !placa.equals(vehiculo.placa) : vehiculo.placa != null) return false;
        if (modelo != null ? !modelo.equals(vehiculo.modelo) : vehiculo.modelo != null) return false;
        if (propietario != null ? !propietario.equals(vehiculo.propietario) : vehiculo.propietario != null)
            return false;
        if (parqueadero != null ? !parqueadero.equals(vehiculo.parqueadero) : vehiculo.parqueadero != null)
            return false;
        return tipoVehiculo != null ? tipoVehiculo.equals(vehiculo.tipoVehiculo) : vehiculo.tipoVehiculo == null;
    }

    @Override
    public int hashCode() {
        int result = placa != null ? placa.hashCode() : 0;
        result = 31 * result + (modelo != null ? modelo.hashCode() : 0);
        result = 31 * result + (propietario != null ? propietario.hashCode() : 0);
        result = 31 * result + (parqueadero != null ? parqueadero.hashCode() : 0);
        result = 31 * result + (tipoVehiculo != null ? tipoVehiculo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", propietario=" + propietario +
                ", parqueadero=" + parqueadero +
                ", tipoVehiculo=" + tipoVehiculo +
                '}';
    }

    //------------------------------------------------------------------------------------------------------------
}
