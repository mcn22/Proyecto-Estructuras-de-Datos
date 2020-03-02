package p_estructuras;

public class NodoLSCorr {

    private String dato;
    private NodoLSCorr next;

    public NodoLSCorr(String dato) {
        this.dato = dato;
    }

    public NodoLSCorr() {
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public NodoLSCorr getNext() {
        return next;
    }

    public void setNext(NodoLSCorr next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return dato;
    }

}//fin de la clase nodoLscorr
