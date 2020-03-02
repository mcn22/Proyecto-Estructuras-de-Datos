package p_estructuras;

public class NodoLCClien {

    private Cliente dato;
    private ListaSFact datoFact;
    private NodoLCClien next;

    public NodoLCClien(Cliente dato, ListaSFact datoFact) {
        this.dato = dato;
        this.datoFact = datoFact;
    }

    public NodoLCClien() {
    }

    public Cliente getDato() {
        return dato;
    }

    public void setDato(Cliente dato) {
        this.dato = dato;
    }

    public ListaSFact getDatoFact() {
        return datoFact;
    }

    public void setDatoFact(ListaSFact datoFact) {
        this.datoFact = datoFact;
    }

    public NodoLCClien getNext() {
        return next;
    }

    public void setNext(NodoLCClien next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return  dato.toString();
    }

}//fin de nodo lista circular cliente
