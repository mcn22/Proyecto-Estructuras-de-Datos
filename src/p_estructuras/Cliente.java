package p_estructuras;

public class Cliente {

    private String nombre;
    private float puntos;
    private String correo;
    private String pass;
    private char nivel;
    private int id;
    private String envio;

    public Cliente(String nombre, float puntos, String correo, String pass, char nivel, int id, String envio) {
        this.nombre = nombre;
        this.puntos = puntos;
        this.correo = correo;
        this.pass = pass;
        this.nivel = nivel;
        this.id = id;
        this.envio = envio;
    }

    public Cliente() {
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

    public String getEnvio() {
        return envio;
    }

    public void setEnvio(String envio) {
        this.envio = envio;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nPuntos: " + puntos + "\nCorreo: " + correo;
    }

    public float getPuntos() {
        return puntos;
    }

    public void setPuntos(float puntos) {
        this.puntos = puntos;
    }
    
    

}//fin de la clase cliente
