package model;

public class Propietario {

    private String nombre;
    private String id;
    private String telefono;
    private Parqueadero parqueadero;

    public Propietario(String nombre, String id, String telefono, Parqueadero parqueadero) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.parqueadero = parqueadero;
    }

    /**
     * Constructor vacío.
     */
    public Propietario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Parqueadero getParqueadero() {
        return parqueadero;
    }

    public void setParqueadero(Parqueadero parqueadero) {
        this.parqueadero = parqueadero;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Propietario that = (Propietario) o;

        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (telefono != null ? !telefono.equals(that.telefono) : that.telefono != null) return false;
        return parqueadero != null ? parqueadero.equals(that.parqueadero) : that.parqueadero == null;
    }

    @Override
    public int hashCode() {
        int result = nombre != null ? nombre.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (telefono != null ? telefono.hashCode() : 0);
        result = 31 * result + (parqueadero != null ? parqueadero.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Propietario{" +
                "nombre='" + nombre + '\'' +
                ", id='" + id + '\'' +
                ", telefono='" + telefono + '\'' +
                ", parqueadero=" + parqueadero +
                '}';
    }
}
