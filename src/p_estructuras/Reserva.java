package p_estructuras;

public class Reserva {

    private String nombre;
    private int cedula;
    private int telefono;
    private int mesa;
    private int idUser;
    private boolean ocupado;

    public Reserva(String nombre, int cedula, int telefono, int mesa, int idUser, boolean ocupado) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.mesa = mesa;
        this.idUser = idUser;
        this.ocupado = ocupado;
    }

    public Reserva() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nCedula: " + cedula + "\nTelefono: " + telefono + "\nMesa: " + mesa;
    }

}//fin de la clase reserva
