package p_estructuras;

public class NodoLSCart {

    private Carta dato;
    private NodoLSCart next;

    public NodoLSCart(Carta dato) {
        this.dato = dato;
    }

    public Carta getDato() {
        return dato;
    }

    public void setDato(Carta dato) {
        this.dato = dato;
    }

    public NodoLSCart getNext() {
        return next;
    }

    public void setNext(NodoLSCart next) {
        this.next = next;
    }

    @Override
    public String toString() {
        String s = dato.toString();
        return s;
    }

}//fin de la clase nodolsprod
