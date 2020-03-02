package p_estructuras;

public class Carta {

    private String nombre;
    private int cod;
    private char tipo;
    private float precio;

    public Carta(String nombre, int cod, char tipo, float precio) {
        this.nombre = nombre;
        this.cod = cod;
        this.tipo = tipo;
        this.precio = precio;
    }

    public Carta() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Cod: " + cod + " Nombre: " + nombre + " Tipo: " + tipo + " Precio: " + precio;
    }

}//fin de la clase carta
