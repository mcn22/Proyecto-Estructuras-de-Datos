package p_estructuras;

public class Solicitud {

    private String nombre;
    private int edad;
    private String puesto;
    private int telefono;

    public Solicitud(String nombre, int edad, String puesto, int telefono) {
        this.nombre = nombre;
        this.edad = edad;
        this.puesto = puesto;
        this.telefono = telefono;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nEdad: " 
                + edad + "\nPuesto: " + puesto 
                + "\nTelefono: " + telefono;
    }

}//fin de la clase solicitud
