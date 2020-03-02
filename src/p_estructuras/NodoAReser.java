package p_estructuras;

public class NodoAReser {

    private Reserva dato;
    private NodoAReser hijoIzq;
    private NodoAReser hijoDer;

    public NodoAReser(Reserva dato) {
        this.dato = dato;
    }

    public Reserva getDato() {
        return dato;
    }

    public void setDato(Reserva dato) {
        this.dato = dato;
    }

    public NodoAReser getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(NodoAReser hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public NodoAReser getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(NodoAReser hijoDer) {
        this.hijoDer = hijoDer;
    }

    @Override
    public String toString() {
        return dato.toString();
    }

}//fin del nodo del arbol de la reservacion
