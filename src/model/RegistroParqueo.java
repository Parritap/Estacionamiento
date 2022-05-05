package model;

public class RegistroParqueo {

    private String fecha;
    private String horaLlegada;
    private String horaSalida;
    private double total;
    private Parqueadero parqueadero;
    private Puesto puesto;
    private Vehiculo vehiculo;

    public RegistroParqueo(String fecha, String horaLlegada, String horaSalida, double total, Parqueadero parqueadero, Puesto puesto, Vehiculo vehiculo) {
        this.fecha = fecha;
        this.horaLlegada = horaLlegada;
        this.horaSalida = horaSalida;
        this.total = total;
        this.parqueadero = parqueadero;
        this.puesto = puesto;
        this.vehiculo = vehiculo;
    }

    /**
     * Constructor vacío.
     */
    public RegistroParqueo() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegistroParqueo that = (RegistroParqueo) o;

        if (Double.compare(that.total, total) != 0) return false;
        if (fecha != null ? !fecha.equals(that.fecha) : that.fecha != null) return false;
        if (horaLlegada != null ? !horaLlegada.equals(that.horaLlegada) : that.horaLlegada != null) return false;
        if (horaSalida != null ? !horaSalida.equals(that.horaSalida) : that.horaSalida != null) return false;
        if (parqueadero != null ? !parqueadero.equals(that.parqueadero) : that.parqueadero != null) return false;
        if (puesto != null ? !puesto.equals(that.puesto) : that.puesto != null) return false;
        return vehiculo != null ? vehiculo.equals(that.vehiculo) : that.vehiculo == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = fecha != null ? fecha.hashCode() : 0;
        result = 31 * result + (horaLlegada != null ? horaLlegada.hashCode() : 0);
        result = 31 * result + (horaSalida != null ? horaSalida.hashCode() : 0);
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (parqueadero != null ? parqueadero.hashCode() : 0);
        result = 31 * result + (puesto != null ? puesto.hashCode() : 0);
        result = 31 * result + (vehiculo != null ? vehiculo.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "RegistroParqueo{" +
                "fecha='" + fecha + '\'' +
                ", horaLlegada='" + horaLlegada + '\'' +
                ", horaSalida='" + horaSalida + '\'' +
                ", total=" + total +
                ", parqueadero=" + parqueadero +
                ", puesto=" + puesto +
                ", vehiculo=" + vehiculo +
                '}';
    }


}
