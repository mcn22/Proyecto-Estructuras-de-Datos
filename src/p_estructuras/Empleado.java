package p_estructuras;

public class Empleado {

    private String nombre;
    private char nivel;
    private int id;
    private int telefono;
    private String puesto;

    public Empleado(String nombre, char nivel, int id, int telefono, String puesto) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.id = id;
        this.telefono = telefono;
        this.puesto = puesto;
    }

    public Empleado() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public char getNivel() {
        return nivel;
    }

    public void setNivel(char nivel) {
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nId: " + id + "\nTelefono: " + telefono + "\nPuesto: " + puesto;
    }

}//fin de la clase empleado
