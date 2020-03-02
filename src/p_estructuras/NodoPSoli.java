package p_estructuras;

public class NodoPSoli {

    private Solicitud dato;
    private NodoPSoli abajo;

    public NodoPSoli(Solicitud dato) {
        this.dato = dato;
    }

    public NodoPSoli getAbajo() {
        return abajo;
    }

    public void setAbajo(NodoPSoli abajo) {
        this.abajo = abajo;
    }

    public Solicitud getDato() {
        return dato;
    }

    public void setDato(Solicitud dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        String s = dato.toString();
        return s;
    }

}//fin del nodo de la pila de solicitudes
