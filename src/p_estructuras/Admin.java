package p_estructuras;

public class Admin {

    private String nombre;
    private String correo;
    private String pass;
    private char nivel;
    private int id;

    public Admin(String nombre, String correo, String pass, char nivel, int id) {
        this.nombre = nombre;
        this.correo = correo;
        this.pass = pass;
        this.nivel = nivel;
        this.id = id;
    }

    public Admin() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    @Override
    public String toString() {
        return "Nombre: " + nombre + " Correo" + correo
                + " Id: " + id;
    }

}//fin de la clase admin
