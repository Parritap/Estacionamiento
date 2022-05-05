package model;

public class Puesto {

    private String num;
    private String estado;
    private Double precio;
    private Parqueadero parqueadero;
    private TipoVehiculo tipoVehiculo;

    public Puesto(String num, String estado, Double precio, Parqueadero parqueadero, TipoVehiculo tipoVehiculo) {
        this.num = num;
        this.estado = estado;
        this.precio = precio;
        this.parqueadero = parqueadero;
        this.tipoVehiculo = tipoVehiculo;
    }

    public Puesto (String num, Parqueadero parqueadero){
        this.num = num;
        this.parqueadero = parqueadero;
    }

    /**
     * Constructor vacío.
     */
    public Puesto() {
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    public TipoVehiculo getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(TipoVehiculo tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Puesto puesto = (Puesto) o;

        if (num != null ? !num.equals(puesto.num) : puesto.num != null) return false;
        if (estado != null ? !estado.equals(puesto.estado) : puesto.estado != null) return false;
        if (precio != null ? !precio.equals(puesto.precio) : puesto.precio != null) return false;
        if (parqueadero != null ? !parqueadero.equals(puesto.parqueadero) : puesto.parqueadero != null) return false;
        return tipoVehiculo == puesto.tipoVehiculo;
    }

    @Override
    public int hashCode() {
        int result = num != null ? num.hashCode() : 0;
        result = 31 * result + (estado != null ? estado.hashCode() : 0);
        result = 31 * result + (precio != null ? precio.hashCode() : 0);
        result = 31 * result + (parqueadero != null ? parqueadero.hashCode() : 0);
        result = 31 * result + (tipoVehiculo != null ? tipoVehiculo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Puesto{" +
                "num='" + num + '\'' +
                ", estado='" + estado + '\'' +
                ", precio=" + precio +
                ", parqueadero=" + parqueadero +
                ", tipoVehiculo=" + tipoVehiculo +
                '}';
    }


}


